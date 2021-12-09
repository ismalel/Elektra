package com.ismael.elektra.ui.view.detail

class DetailPresenter(val view: DetailContract.View) : DetailContract.Presenter {

    override fun onClickButton() {
        view.onClosedActivity()
    }

    override fun initEmpData() {
        view.onShowEmpInfo()
    }
}