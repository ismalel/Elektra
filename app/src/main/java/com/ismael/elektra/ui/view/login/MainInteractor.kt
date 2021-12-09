package com.ismael.elektra.ui.view.login

import android.annotation.SuppressLint
import com.ismael.elektra.data.repository.login.request.ILoginRepository
import com.ismael.elektra.data.repository.login.request.LoginRepository

class MainInteractor(val presenter: MainContract.Presenter): MainContract.Interactor {
    val loginRepository: ILoginRepository = LoginRepository()

    @SuppressLint("CheckResult")
    override fun login(empID: String) {
        loginRepository.login(empID)
            .subscribe({
                loginResponse ->
                when(loginResponse.statusID){
                    1 -> presenter.onSuccessLoginRequest(loginResponse.datos)
                    2 -> presenter.onFailureLoginRequest("Usuario no encontrado")
                }
            }){
                throwable: Throwable ->
                when(throwable.message.toString()){
                    "HTTP 500 ","HTTP 400 " -> presenter.onFailureLoginRequest("Error del servidor")
                    else -> {
                        presenter.onFailureLoginRequest("Error de conexion")
                    }
                }
            }
    }
}