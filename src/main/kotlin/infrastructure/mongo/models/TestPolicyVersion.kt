package infrastructure.mongo.models

import java.time.LocalDate

class TestPolicyVersion(var isValid: Boolean, val version: Int, val fecha: LocalDate) {

}