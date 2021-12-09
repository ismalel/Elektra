package com.ismael.elektra.ui.view.login

import android.app.Activity
import com.ismael.elektra.data.repository.login.response.Datos
import com.ismael.elektra.data.repository.login.response.LoginResponse

class MainPresenter(val view: MainContract.View) : MainContract.Presenter {
    val interactor : MainContract.Interactor = MainInteractor(this)

    override fun onLoginButtonClicked() {
        if(view.getEmpID().isNotEmpty()){
            interactor.login(view.getEmpID())
        }else{
            view.showMessageError("Ingrese Empleado ID")
        }
    }

    override fun onSuccessLoginRequest(datos: Datos) {
        view.changeView(datos)
    }

    override fun onFailureLoginRequest(error: String) {
        view.showMessageError(error)
    }
}