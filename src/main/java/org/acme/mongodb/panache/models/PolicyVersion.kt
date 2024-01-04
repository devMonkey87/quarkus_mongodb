package org.acme.mongodb.panache.models

import java.time.LocalDate

data class PolicyVersion(var isValid: Boolean, val version: Int, val fecha: LocalDate)
