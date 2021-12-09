package com.ismael.elektra.ui.view.login

import com.ismael.elektra.data.repository.login.response.Datos
import com.ismael.elektra.data.repository.login.response.LoginResponse

interface MainContract {

    interface View{
        fun getEmpID(): String
        fun showMessageError(message: String)
        fun changeView(datos: Datos);
    }

    interface Presenter{
        fun onLoginButtonClicked()
        fun onSuccessLoginRequest(datos: Datos)
        fun onFailureLoginRequest(error: String)
    }

    interface Interactor{
        fun login(empID: String)
    }
}