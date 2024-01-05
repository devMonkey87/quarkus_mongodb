package infrastructure.mongo.resources

import io.quarkus.mongodb.panache.PanacheMongoEntityBase
import infrastructure.mongo.entities.Person
import org.bson.types.ObjectId
import javax.transaction.Transactional
import javax.ws.rs.*

@Path("/persons")
class PersonResource {
    @Transactional
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    fun create(newPerson: Person): Person {
        PanacheMongoEntityBase.persist(newPerson)
        return newPerson
    }

    @GET
    @Produces("application/json")
    fun listAll(): List<Person> {
        return PanacheMongoEntityBase.listAll()
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    @Consumes("application/json")
    fun getById(@PathParam("id") id: String?): Person {
        val personId = ObjectId(id)
        return PanacheMongoEntityBase.findById(personId) ?: throw WebApplicationException(404)
    }

    @PUT
    @Path("{id}")
    @Produces("application/json")
    @Consumes("application/json")
    fun update(@PathParam("id") id: String?, personToSave: Person): Person {
        val personId = ObjectId(id)
        val person = PanacheMongoEntityBase.findById<Person>(personId)
        if (personId == null) {
            throw WebApplicationException(404)
        }
        person.name = personToSave.name
        person.update()
        return person
    }

    @DELETE
    @Path("{id}")
    fun delete(@PathParam("id") id: String?) {
        val personId = ObjectId(id)
        val deleted = PanacheMongoEntityBase.deleteById(personId)
        if (!deleted) {
            throw WebApplicationException(404)
        }
    }
}