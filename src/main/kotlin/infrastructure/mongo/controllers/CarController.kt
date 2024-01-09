package infrastructure.mongo.controllers

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import infrastructure.mongo.entities.Car
import io.quarkus.mongodb.panache.PanacheMongoEntityBase
import org.bson.Document
import org.bson.types.ObjectId
import org.litote.kmongo.save
import javax.transaction.Transactional
import javax.ws.rs.*

@Path("/cars")
class CarController {

    private val client: MongoClient = MongoClients.create("mongodb://localhost:27017")

    @Transactional
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    fun create(newCar: Car): Car {
        val collection = client.getDatabase("user").getCollection("Car")

        val carDocument = Document("name", newCar.name)
            .append("wheels", newCar.wheels)

        // Insertar el documento en la colección
        collection.insertOne(carDocument)
        return newCar
    }

        @GET
        @Produces("application/json")
        fun listAll(): List<Car> {

            val collection = client.getDatabase("user").getCollection("Car")

            val find = collection.find()
            println("sSSSSSs"+ find.count())


            return emptyList()
        }

    @GET
    @Path("{id}")
    @Produces("application/json")
    @Consumes("application/json")
    fun getById(@PathParam("id") id: String?): Car {
        val carId = ObjectId(id)


        return PanacheMongoEntityBase.findById(carId) ?: throw WebApplicationException(404)
    }

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