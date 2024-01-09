package infrastructure.mongo.entities

import com.fasterxml.jackson.annotation.JsonProperty
import io.quarkus.mongodb.panache.PanacheMongoEntity

class Car {

    var id = null
    @JsonProperty
    var name: String? = null
    var wheels = 0
}


