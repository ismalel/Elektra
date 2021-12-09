package com.ismael.elektra.ui.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ismael.elektra.R
import com.ismael.elektra.data.repository.login.response.Datos
import com.ismael.elektra.databinding.ActivityMainBinding
import com.ismael.elektra.ui.view.detail.DetailView

class MainView : AppCompatActivity(), MainContract.View {
    lateinit var binding: ActivityMainBinding
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MainPresenter(this)
        binding.btnLogin.setOnClickListener{
            presenter.onLoginButtonClicked()
        }
    }

    override fun getEmpID(): String {
        return binding.etUser.text.toString()
    }

    override fun showMessageError(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

    override fun changeView(datos: Datos) {
        val intent = Intent(this,DetailView::class.java)
        intent.putExtra("emp_id",getEmpID())
        intent.putExtra("nombre", datos.nombre+" "+datos.apPaterno+" "+datos.apMaterno)
        intent.putExtra("edad", datos.info.edad)
        intent.putExtra("sexo", datos.info.sexoDesc)
        intent.putExtra("puesto", datos.puesto.puestoDesc)
        intent.putExtra("gerencia", datos.gerencia.gerenciaDesc)
        startActivity(intent)
    }
}