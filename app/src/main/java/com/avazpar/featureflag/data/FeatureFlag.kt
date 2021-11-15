package com.avazpar.featureflag.data

enum class FeatureFlag(
    override val id: String,
    override val title: String,
    override val defaultValue: Boolean
) : Feature {
    CREDIT_SCORE(id = "credit_score_id", title = "Credit Score", defaultValue = false)
}