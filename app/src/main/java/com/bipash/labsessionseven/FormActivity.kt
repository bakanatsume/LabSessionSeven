package com.bipash.labsessionseven

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup

class FormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var txtName : EditText
    private lateinit var txtAddress : EditText
    private lateinit var txtNumber : EditText
    private lateinit var rdoGroup : RadioGroup
    private lateinit var btnSubmit : Button

    private var gender = ""
//    private  var studentRecord = arrayListOf<StudentDetails>();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        txtName = findViewById(R.id.txtName)
        txtAddress = findViewById(R.id.txtAddress)
        txtNumber = findViewById(R.id.txtNumber)
        rdoGroup = findViewById(R.id.rdoGroup)
        btnSubmit =findViewById(R.id.btnSubmit)

        rdoGroup.setOnCheckedChangeListener(object :RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when(checkedId){
                    R.id.rdoMale->{
                        gender = "Male"
                    }
                    R.id.rdoFemale->{
                        gender = "Female"
                    }
                }
            }

        })

        btnSubmit.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnSubmit->{
                val name = txtName.text.toString()
                val address = txtAddress.text.toString()
                val number = txtAddress.text.toString()

                var student = (StudentDetails(name,address,number,gender))

                var intent = Intent()
                intent.putExtra("getDetails",student)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}