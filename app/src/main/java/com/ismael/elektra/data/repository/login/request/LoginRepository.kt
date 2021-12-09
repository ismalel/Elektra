package com.ismael.elektra.data.repository.login.request

import com.ismael.elektra.data.repository.login.LoginRetrofitModule
import com.ismael.elektra.data.repository.login.response.LoginResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

class LoginRepository: ILoginRepository {
    val loginRetrofitModule: LoginRetrofitModule = LoginRetrofitModule()

    override fun login(empID: String?): Observable<LoginResponse> {
        return loginRetrofitModule.login()
            .login(empID)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.flatMap { loginData ->
                when(loginData.statusID){
                    1,2 -> return@flatMap Observable.just(loginData)
                    else -> {
                        throw Exception(loginData.statusDesc)
                    }
                }
            }!!
    }
}