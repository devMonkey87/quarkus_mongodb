package infrastructure.mongo

import com.mongodb.MongoClientSettings
import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import infrastructure.mongo.entities.Car
import org.bson.codecs.configuration.CodecRegistries
import org.bson.codecs.pojo.PojoCodecProvider
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class MongoClientConfig {

    private val LOCAL_MONGO_URL: String = "mongodb://localhost:27017"

    fun instance(): MongoDatabase {


        val mongoClient = MongoClient.create(LOCAL_MONGO_URL)
        return mongoClient.getDatabase("user")
    }

}
