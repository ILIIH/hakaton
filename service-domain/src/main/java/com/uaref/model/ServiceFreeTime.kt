package com.uaref.model

data class ServiceFreeTime(val from: String, val until: String) {
    override fun toString(): String {
        return "$from-$until"
    }
}
