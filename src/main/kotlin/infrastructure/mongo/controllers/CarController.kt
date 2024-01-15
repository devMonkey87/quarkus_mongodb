package infrastructure.mongo.controllers

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoCollection
import infrastructure.config.ConfigProperties
import infrastructure.mongo.entities.Car
import org.bson.Document
import javax.inject.Inject
import javax.transaction.Transactional
import javax.ws.rs.*

private const val MY_DYNAMIC_VALUE = "Valor"

@Path("/cars")
class CarController @Inject constructor(
    private val configProperties: ConfigProperties
) {

    private val client: MongoClient = MongoClients.create("mongodb://localhost:27017")


    @Transactional
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    fun create(@HeaderParam(MY_DYNAMIC_VALUE) valorcito: String, car: Car): Car {
        val collection = client.getDatabase("user").getCollection("Car")



        println("EEEEEE")
        println(valorcito)

        println(configProperties.parametro)

        val movieDataClass = collection

        val carDocument = Car()
        carDocument.name = "sdaa"
        carDocument.wheels = 7


        // Insertar el documento en la colección
        val echo = collection.insertOne(Document(Car::name.name, "misCollons").append(Car::wheels.name, 122))

        val wasAcknowledged = echo.wasAcknowledged()

        println(wasAcknowledged)

        return car

    }

    @GET
    @Produces("application/json")
    fun listAll(): List<Car> {

        val collection: MongoCollection<Car> = client.getDatabase("user").getCollection("Car", Car::class.java)
        println("IIIIIIIIIII")

        println("DOCUMENT CAR COUNT: " + collection.countDocuments())


        return emptyList()
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