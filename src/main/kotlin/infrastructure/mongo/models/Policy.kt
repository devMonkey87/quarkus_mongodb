package infrastructure.mongo.models

data class Policy(val name: String, val policyVersions: List<PolicyVersion>)
