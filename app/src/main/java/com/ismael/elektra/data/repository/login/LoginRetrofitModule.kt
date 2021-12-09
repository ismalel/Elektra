package com.ismael.elektra.data.repository.login

import com.ismael.elektra.data.remote.RetrofitClient

class LoginRetrofitModule {

    fun login(): ILoginAPI.Login{
        return RetrofitClient().getRetrofitInstance(RetrofitClient().getURLApi())!!.create(ILoginAPI.Login::class.java)
    }
}