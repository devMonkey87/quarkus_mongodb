package infrastructure.mongo.repository

import infrastructure.mongo.entities.Person
import io.quarkus.mongodb.panache.PanacheMongoRepository
import javax.enterprise.context.ApplicationScoped


@ApplicationScoped
class PersonRepository : PanacheMongoRepository<Person> {
}