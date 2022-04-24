package com.khushal.splashscreenwithlifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_welcomepage.*

class Welcomepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcomepage)
        wlcsave.setOnClickListener {
            var name=wlcbikename.text.toString()
            var desc=wlcbikedsc.text.toString()
            var price=wlcbikeprice.text.toString().toInt()
            var setcap=wlcbikestecap.text.toString().toInt()
            var fullcap=wlcfullcap.text.toString().toInt()
            var b1=Bike(name,desc,price,setcap,fullcap)
            var db=DBHelper(this)
            var flag=db.bikeinsert(b1)
            if(flag)
            {
                Toast.makeText(this," bike record inserted", Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(this,"record not inserted", Toast.LENGTH_LONG).show()
            }
        }
        wlcview.setOnClickListener {
            var intent= Intent(this,ViewAll::class.java)
            startActivity(intent)
        }
        wlcviewmul.setOnClickListener {
            var intent= Intent(this,OpreationActivity::class.java)
            startActivity(intent)
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mymenu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id = item.itemId
        if (id == R.id.menulogout) {
            var preference = getSharedPreferences("MyPref", MODE_PRIVATE)
            var editor = preference.edit()
            editor.clear()
            editor.commit()
            var intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
            Toast.makeText(
                applicationContext, "Logout Successfully",
                Toast.LENGTH_LONG
            ).show()
        }
        return super.onOptionsItemSelected(item)
    }
}