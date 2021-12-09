package com.ismael.elektra.data.repository.login.response

data class Datos(
    val empID: String,
    val nombre: String,
    val apPaterno: String,
    val apMaterno: String,
    val info: Info,
    val puesto: Puesto,
    val gerencia: Gerencia
)
