package infrastructure.mongo.entities

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class Person(
    @BsonId
    var id: ObjectId? = null,
    var name: String? = null,
    var status: String? = null,
    var account: Int = 0
)



