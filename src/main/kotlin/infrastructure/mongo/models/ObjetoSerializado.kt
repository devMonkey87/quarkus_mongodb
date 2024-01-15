package infrastructure.mongo.models

import kotlinx.serialization.Serializable


@Serializable
data class ObjetoSerializado(val nombre: String, val numeros: Int)
