package infrastructure.mongo.models

open class UnderwritingRule(
    var state: String
) {
    companion object {
        /**
         * Creates a [UnderwritingRule] instance from the given map containing the rule result data.
         *
         * @param result The map containing the rule result data.
         * @return The created [UnderwritingRule] instance.
         */
        fun of(ruleName: String, result: Map<String, String>): UnderwritingRule {
            val state = result["state"] as String

            return UnderwritingRule(state)
        }
    }
}