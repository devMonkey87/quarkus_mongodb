package org.acme.mongodb.panache.entities

import com.fasterxml.jackson.annotation.JsonProperty
import io.quarkus.mongodb.panache.PanacheMongoEntity

class Person : PanacheMongoEntity() {
    @JsonProperty
    var name: String? = null
    var status: String? = null
    var account = 0
}

fun test(valor1: String, valor2:String= "test"){

}

fun another(){
    test(valor1 = "hola")

}
