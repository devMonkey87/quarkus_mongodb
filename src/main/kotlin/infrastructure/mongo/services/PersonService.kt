package infrastructure.mongo.services

import infrastructure.mongo.entities.Person


interface PersonService {

    fun getAll(): List<Person>

    fun findById(id: String): Person

    fun findByName(id: String): Person


    fun save(person: Person)

    fun update(person: Person)

}
