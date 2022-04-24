package com.khushal.splashscreenwithlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_opreation.*

class OpreationActivity : AppCompatActivity() {
    var total:Long=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opreation)
        opbtn.setOnClickListener {
            var price:TextView=findViewById(R.id.opprice)
            var id=opid.text.toString().toInt()
            var qyt=opqyt.text.toString().toInt()
            var db = DBHelper(this)
            var arr=db.bike_opretion()
           for (arr1 in arr)
           {
               var oid=arr1.opid.toInt()
               if(id.equals(oid))
               {
                var price=arr1.opprice
                   total=price*qyt.toLong()

                   break
               }
           }
            price.setText(total.toString())

        }
    }
}