package infrastructure.mongo.services

import infrastructure.mongo.entities.Person
import infrastructure.mongo.repository.PersonRepository
import org.bson.types.ObjectId
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class PersonServiceImpl(private val personRepository: PersonRepository) : PersonService {
    override fun getAll(): List<Person> {
        return personRepository.listAll()
    }

    override fun findById(id: String): Person {
        return personRepository.findById(ObjectId(id))

    }

    override fun findByName(name: String): Person {
        return personRepository.find("name", name).firstResult()
    }

    override fun save(person: Person) {
        return personRepository.persist(person)

    }

    override fun update(person: Person) {
        return personRepository.update(person)
    }

}