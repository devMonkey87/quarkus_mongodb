package infrastructure.mongo.entities

import com.fasterxml.jackson.annotation.JsonProperty
import io.quarkus.mongodb.panache.PanacheMongoEntity

class Person : PanacheMongoEntity() {
    @JsonProperty
    var name: String? = null
    var status: String? = null
    var account = 0
}


