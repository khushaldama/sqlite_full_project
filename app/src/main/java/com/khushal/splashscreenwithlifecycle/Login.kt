package com.khushal.splashscreenwithlifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    var flag=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnlLogin.setOnClickListener{
            var lusername=edtEmail.text.toString()
            var lpass=edtPass.text.toString()
            if(TextUtils.isEmpty(lusername)|| TextUtils.isEmpty(lpass))
            {
                Toast.makeText(this,"PLEASE ENTER THE USERNAME / PASSWORD CORRECTLY",
                    Toast.LENGTH_LONG).show()
            }
            else{
                var db=DBHelper(this)
                var arr=db.retrivedata()
                for (chkuser in arr) {
                    if (lusername.equals("${chkuser.d_username}") && lpass.equals("${chkuser.d_password}")) {
                        var preference = getSharedPreferences("MyPref", MODE_PRIVATE)
                        var editor = preference.edit()
                        editor.putString("user", lusername)
                        editor.commit()
                        Toast.makeText(this, "Login Successfully", Toast.LENGTH_LONG).show()

                        var intent = Intent(this, Welcomepage::class.java)
                        startActivity(intent)
                        finish()
                        flag = true
                    }
                }
                    if(!flag) {
                    Toast.makeText(this, "Invalid Username and Password", Toast.LENGTH_LONG).show() }

            }
        }
        btnLoginPage.setOnClickListener{
            var intent=Intent(this,Signup::class.java)
            startActivity(intent)
            finish()
        }

    }
}