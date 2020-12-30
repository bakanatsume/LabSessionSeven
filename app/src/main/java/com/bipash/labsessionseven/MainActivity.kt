package com.bipash.labsessionseven

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var listView : ListView
    private lateinit var txtDetails : TextView
    private lateinit var btnAdd : Button

    private var getDetails = arrayListOf<StudentDetails>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)
        txtDetails = findViewById(R.id.txtDetails)
        btnAdd = findViewById(R.id.btnAdd)



        btnAdd.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnAdd ->{
                startActivityForResult(Intent(this, FormActivity::class.java), 1)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1){
            if(resultCode==Activity.RESULT_OK){
                var student = data?.getSerializableExtra("getDetails") as StudentDetails
                getDetails.add(student)
                val adapter = ArrayAdapter(
                        this,
                        android.R.layout.simple_list_item_1,
                        getDetails
                )

                listView.adapter = adapter

                listView.setOnItemClickListener { parent, view, position, id ->
                    txtDetails.text =parent.getItemAtPosition(position).toString()
                }
            }
        }
    }
}