package playgrounds

import infrastructure.mongo.models.TestPolicy
import infrastructure.mongo.models.TestPolicyVersion
import java.time.LocalDate

class KotlinCollections {
    private fun testCollections() {
        val polizarecuperada = TestPolicy(
            name = "test",
            policyVersions = listOf(
                TestPolicyVersion(version = 2, isValid = true, fecha = LocalDate.now()),
                TestPolicyVersion(version = 1, isValid = false, fecha = LocalDate.now()),
                TestPolicyVersion(version = 3, isValid = true, fecha = LocalDate.now())

            )
        )

        val filtrado = filterValidPolicyVersionByVersionNumber(polizarecuperada, 3)

        val newPolicyVersions = polizarecuperada.policyVersions.map {
            if (it.version == 3) {
                it.isValid = false
            }
        }
    }

    private fun filterValidPolicyVersionByVersionNumber(policy: TestPolicy, policyVersionNumber: Number): TestPolicy {
        val policyVersions = policy.policyVersions
        if (policyVersions.isEmpty()) {
            return policy
        }

        val policyVersionList = policyVersions.filter { it.version == policyVersionNumber }
        return TestPolicy(policyVersions = policyVersionList, name = "test")
    }
}