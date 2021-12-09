package com.ismael.elektra.data.repository.login.request

import com.ismael.elektra.data.repository.login.response.LoginResponse
import io.reactivex.Observable

interface ILoginRepository {
    fun login(empID: String?) : Observable<LoginResponse>
}