package infrastructure.mongo.controllers

import io.quarkus.mongodb.panache.PanacheMongoEntityBase
import infrastructure.mongo.entities.Person
import infrastructure.mongo.services.PersonService
import org.bson.types.ObjectId
import javax.transaction.Transactional
import javax.ws.rs.*

@Path("/persons")
class PersonController(private val personService: PersonService) {
    @Transactional
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    fun create(newPerson: Person): Person {
        personService.save(newPerson)
        return newPerson
    }

    @GET
    @Produces("application/json")
    fun listAll(): List<Person> {
        return personService.getAll()
    }

/*    @GET
    @Path("{id}")
    @Produces("application/json")
    @Consumes("application/json")
    fun getById(@PathParam("id") id: String?): Person {
        val personId = ObjectId(id)
        return PanacheMongoEntityBase.findById(personId) ?: throw WebApplicationException(404)
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