package com.khushal.splashscreenwithlifecycle

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_view_all.*
import kotlinx.android.synthetic.main.custom_dialog.*

class ViewAll : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_all)
        updateRecyclerView()
    }
    private fun updateRecyclerView() {
        var db = DBHelper(this)
        var arr=db.bike_retriveall()
        var adapter= BikeAdapter(this,arr)
        bhailog.adapter=adapter
    }
    fun delete(position: Int) {
        Toast.makeText(applicationContext,"im here", Toast.LENGTH_LONG).show()
        var db=DBHelper(this)
        var arr:ArrayList<Bike> = db.GetAllBike()
        var fruit=arr.get(position)
        Toast.makeText(applicationContext,"${fruit.id}", Toast.LENGTH_LONG).show()
        db.Delete(fruit.id)
        updateRecyclerView()

    }
    fun update(position: Int)
    {
        var db=DBHelper(this)
        var arr:ArrayList<Bike_updeta> = db.retriveAll()
        var person=arr.get(position)
        var dialog= Dialog(this)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_dialog)
        dialog.txtUpadateId.setText(person.bid.toString())
        dialog.edtupadetename.setText(person.bname)
        dialog.edtUpdatedesc.setText(person.bdesc)
        dialog.btnUpdate.setOnClickListener {
            var id=dialog.txtUpadateId.text.toString().toInt()
            var name=dialog.edtupadetename.text.toString()
            var desc=dialog.edtUpdatedesc.text.toString()
            var p=Bike_updeta(id,name,desc)
            db.update(p)
            dialog.dismiss()
            updateRecyclerView()
        }
        dialog.show()
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