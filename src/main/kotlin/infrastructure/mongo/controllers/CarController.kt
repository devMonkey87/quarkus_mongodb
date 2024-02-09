package infrastructure.mongo.controllers

import com.mongodb.MongoClientSettings
import com.mongodb.client.model.Filters
import infrastructure.config.ConfigProperties
import infrastructure.mongo.MongoClientConfig
import infrastructure.mongo.entities.Car
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import org.bson.Document
import org.bson.codecs.configuration.CodecRegistries
import org.bson.codecs.pojo.PojoCodecProvider
import java.math.BigDecimal
import javax.transaction.Transactional
import javax.ws.rs.*

private const val MY_DYNAMIC_VALUE = "Valor"

@Path("/cars")
class CarController(
    private val configProperties: ConfigProperties,
    private val mongoDatabase: MongoClientConfig
) {

    @Transactional
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    fun create(@HeaderParam(MY_DYNAMIC_VALUE) valorcito: String, car: Car): Car {

        GlobalScope.launch {
            insert()
        }
        return car
    }


    @GET
    @Produces("application/json")
    fun listAll(): List<Car> {
        var result: List<Car> = emptyList()
        GlobalScope.launch {
            result = getAll()
        }

        return result

    }

    private suspend fun insert() {
        println("test")
        val pojoCodecProvider = PojoCodecProvider.builder().automatic(true).register(Car::class.java).build()

        val codecRegistry = CodecRegistries.fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            CodecRegistries.fromProviders(pojoCodecProvider)
        )
        val collection = mongoDatabase.instance().getCollection<Car>("Car").withCodecRegistry(codecRegistry)

        var codecRegistry1 = collection.codecRegistry


        val carEntity = Car(null, name = "aloooo", wheels = 7, price = BigDecimal.valueOf(20.545))

        val carDocument = Document(mapOf("name" to "car1")).append("price", BigDecimal.valueOf(20.545))

        val insertOne = collection.insertOne(carEntity)

        println(insertOne)


    }

    private suspend fun getAll(): List<Car> {
        val collection = mongoDatabase.instance().getCollection<Car>("Car")

        println("DOCUMENT CAR COUNT: " + collection.countDocuments())

        return collection.find(Filters.eq("name", "car1")).toList()


    }

    /*    @GET
        @Path("{id}")
        @Produces("application/json")
        @Consumes("application/json")
        fun getById(@PathParam("id") id: String?): Car {
            val carId = ObjectId(id)


            return PanacheMongoEntityBase.findById(carId) ?: throw WebApplicationException(404)
        }*/

    /*    @PUT
        @Path("{id}")
        @Produces("application/json")
        @Consumes("application/json")
        fun update(@PathParam("id") id: String?, personToSave: Person): Person {
            val personId = ObjectId(id)
            val person = PanacheMongoEntityBase.findById<Person>(personId)
            person.name = personToSave.name
            person.update()
            return person
        }*/

    /*    @DELETE
        @Path("{id}")
        fun delete(@PathParam("id") id: String?) {
            val personId = ObjectId(id)
            val deleted = PanacheMongoEntityBase.deleteById(personId)
            if (!deleted) {
                throw WebApplicationException(404)
            }
        }*/


}