package com.ismael.elektra.ui.view.detail

import com.ismael.elektra.data.repository.login.response.Datos

interface DetailContract {

    interface View{
        fun onClosedActivity()
        fun onShowEmpInfo()
    }

    interface Presenter{
        fun onClickButton()
        fun initEmpData()
    }
}