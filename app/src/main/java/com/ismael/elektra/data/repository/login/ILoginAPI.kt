package com.ismael.elektra.data.repository.login

import com.ismael.elektra.data.repository.login.response.LoginResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface ILoginAPI {

    interface Login{
        @GET("users/getInfoEmpleado")
        fun login(@Query("idEmpleado") idEmpleado: String?) : Observable<LoginResponse?>?
    }
}