package infrastructure.config

import io.quarkus.arc.config.ConfigProperties


@ConfigProperties(prefix = "miTest")
interface ConfigProperties {
    val parametro: String

}