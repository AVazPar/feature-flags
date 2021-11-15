package com.avazpar.featureflag.data

interface Feature {
    val id: String
    val title: String
    val defaultValue: Boolean
}