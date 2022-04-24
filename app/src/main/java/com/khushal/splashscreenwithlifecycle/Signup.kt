package com.khushal.splashscreenwithlifecycle

import android.content.Intent
import android.media.MediaCodec.MetricsConstants.MODE
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.Preference
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signup.*

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        btnSignup.setOnClickListener{
            var username=edtsignUsername.text.toString()
            var pass=edtsignPassword.text.toString()
            var s1=Users(username,pass)
            var db=DBHelper(this)
            var flag=db.insertdata(s1)
            if(flag)
            {
                Toast.makeText(this,"record inerted", Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(this,"record not inserted", Toast.LENGTH_LONG).show()
            }
        }
        btnsLogin.setOnClickListener(){
            var intent =Intent(this,Login::class.java)
            startActivity(intent)
            finish()
        }
    }
}