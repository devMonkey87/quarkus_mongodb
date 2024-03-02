package infrastructure.mongo.entities

class HomePolicy(
    nombre: String,
    salas: String,
    lob: String
) : Policy(nombre = nombre, paquita = salas, lob = lob) {

}