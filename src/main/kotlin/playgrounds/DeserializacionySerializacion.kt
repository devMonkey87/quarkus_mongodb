package playgrounds

import infrastructure.mongo.models.ObjetoSerializado

class DeserializacionySerializacion {

    private var miElemento: ObjetoSerializado = ObjetoSerializado("caso1", 3)


    fun doRandomStuff() {

        println("nada")
    }

    fun getElementNombre(): String{
        return this.miElemento.nombre
    }

    fun getElementSerializado(): ObjetoSerializado{
        return this.miElemento
    }


}