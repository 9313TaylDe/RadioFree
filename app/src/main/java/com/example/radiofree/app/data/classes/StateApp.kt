package com.example.radiofree.app.data.classes

enum class StateApp(val loading: Boolean, val state: String) {
    SUCCESS(loading = true, state = ""),
    ERROR(loading = false, state = ""),
    PROCESSING(loading = false, state = "")
}