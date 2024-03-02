package infrastructure.mongo.models

open class UnderwritingResult(
    val rules: List<UnderwritingRule>
) {
    open fun hasStop(): Boolean = hasState("STOP")

    open fun hasState(state: String): Boolean = rules.any { it.state.equals(state, ignoreCase = true) }


}