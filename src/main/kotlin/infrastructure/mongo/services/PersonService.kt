package infrastructure.mongo.services

import infrastructure.mongo.entities.Person


interface PersonService {

    fun getAll(): List<Person>

    fun save(person: Person)

}
