package com.khushal.splashscreenwithlifecycle

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var image:ImageView=findViewById(R.id.splash)
        var text: TextView =findViewById(R.id.text)
        var rotateAnimation=AnimationUtils.loadAnimation(this,R.anim.fade_in)
        image.startAnimation(rotateAnimation)

        var translate=AnimationUtils.loadAnimation(this,R.anim.text_anim)
        text.startAnimation(translate)

        var ss : SharedPreferences=getSharedPreferences("MyPref", MODE_PRIVATE)
        var st = ss.getString("user","")
        Handler().postDelayed(
            {
            if(st.equals("")) {
                var intent: Intent = Intent(this, Login::class.java);
                startActivity(intent)
                finish()
            }
            else
            {
                var intent = Intent(this,Welcomepage::class.java)
                startActivity(intent)
                finish()
            }
        },3000)
    }
}