package org.acme.mongodb.panache.models

data class Policy(val name: String, val policyVersions: List<PolicyVersion>)
