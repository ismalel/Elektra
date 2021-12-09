package com.ismael.elektra.ui.view.detail

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ismael.elektra.R
import com.ismael.elektra.data.repository.login.response.Datos
import com.ismael.elektra.databinding.ActivityDetailViewBinding

class DetailView : AppCompatActivity(), DetailContract.View{
    lateinit var binding: ActivityDetailViewBinding
    lateinit var presenter: DetailContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = DetailPresenter(this)
        presenter.initEmpData()

        binding.btnDetail.setOnClickListener {
            presenter.onClickButton()
        }
    }

    override fun onClosedActivity() {
        finish()
    }

    @SuppressLint("SetTextI18n")
    override fun onShowEmpInfo() {
        binding.tvNombre.text = "Nombre: " +intent.extras!!.getString("nombre")
        binding.tvEdadr.text = "Edad: "+intent.extras!!.getInt("edad")
        binding.tvSexo.text = "Sexo: " +intent.extras!!.getString("sexo")
        binding.tvPuesto.text = "Puesto: " +intent.extras!!.getString("puesto")
        binding.tvGerencia.text = "Gerencia: "+intent.extras!!.getString("gerencia")
    }
}