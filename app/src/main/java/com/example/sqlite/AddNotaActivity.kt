package com.example.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddNotaActivity : AppCompatActivity() {
    var myNotasDbHelper:NotasDbHelper?=null
    val DB_NAME = "notas.db"
    val DB_VERSION = 1

    var editTitulo:EditText?=null
    var editContenido:EditText?=null
    var btnAdd:Button?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_nota)
        myNotasDbHelper = NotasDbHelper(this,DB_NAME,null,DB_VERSION)
        myNotasDbHelper!!.open()

        editTitulo = findViewById(R.id.editText)
        editContenido = findViewById(R.id.editContenido)
        btnAdd = findViewById(R.id.btnAdd)

        btnAdd!!.setOnClickListener{
            val titulo = editTitulo!!.text.toString()
            val contenido = editContenido!!.text.toString()

            myNotasDbHelper!!.addNota(titulo,contenido)

            editTitulo!!.setText("")
            editContenido!!.setText("")
        }
    }
}