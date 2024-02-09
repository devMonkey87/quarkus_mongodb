package infrastructure.mongo.entities

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.math.BigDecimal

@Serializable
data class Car @JsonCreator constructor(
    @JsonProperty("id") @Contextual val id: ObjectId?,
    @JsonProperty("name") val name: String,
    @JsonProperty("wheels") val wheels: Int,
    @JsonProperty("price") @Contextual val price: BigDecimal?
)



