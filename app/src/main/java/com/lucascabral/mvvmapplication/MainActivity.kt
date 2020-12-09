package com.lucascabral.mvvmapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.titleTextView.observe(this, Observer {
            titleTextView.text = it
        })

        viewModel.login.observe(this, Observer {
            if (it) {
                Toast.makeText(applicationContext,
                        "Login feito com sucesso",
                        Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext,
                        "Falha ao fazer login",
                        Toast.LENGTH_SHORT).show()
            }
        })

        loginButton.setOnClickListener {
            val userLogin = loginEditText.text.toString()
            viewModel.login(userLogin)
        }
    }


}