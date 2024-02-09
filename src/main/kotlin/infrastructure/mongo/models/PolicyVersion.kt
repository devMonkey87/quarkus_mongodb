package infrastructure.mongo.models

import java.time.LocalDate

data class PolicyVersion(val isValid: Boolean, val version: Int, val fecha: LocalDate?)
