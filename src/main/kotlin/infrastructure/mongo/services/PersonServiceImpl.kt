package infrastructure.mongo.services

import infrastructure.mongo.entities.Person
import infrastructure.mongo.repository.PersonRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class PersonServiceImpl(private val personRepository: PersonRepository) : PersonService {
    override fun getAll(): List<Person> {
        return personRepository.listAll()
    }

    override fun save(person: Person) {
        personRepository.persist(person)

    }

}