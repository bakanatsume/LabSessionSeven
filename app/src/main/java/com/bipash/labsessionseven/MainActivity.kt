package com.bipash.labsessionseven

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var listView : ListView
    private lateinit var txtDetails : TextView

    private lateinit var getDetails : ArrayList<StudentDetails>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivityForResult(Intent(this, FormActivity::class.java), 1)

        listView = findViewById(R.id.listView)
        txtDetails = findViewById(R.id.txtDetails)

        getDetails =intent.getSerializableExtra("receiveDetails") as ArrayList<StudentDetails>

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            getDetails
        )

        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val showDetails =parent.getItemAtPosition(position).toString()
            Toast.makeText(this, "$showDetails", Toast.LENGTH_SHORT).show()
        }
    }
}