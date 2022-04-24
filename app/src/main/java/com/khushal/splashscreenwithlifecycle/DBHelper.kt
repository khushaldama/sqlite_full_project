package com.khushal.splashscreenwithlifecycle

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(var context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {
        private var DB_NAME = "SIGNUP"
        private var TB_NAME = "SIGNUP_DETAILS"
        private var DB_VERSION = 1

        private var D_USERNAME = "d_username"
        private var D_PASSWORD = "d_password"

        private var TABLE_NAME = "bike"
        private var DB_BIKE_ID = "bikeid"
        private var DB_BIKE_NAME = "bikename"
        private var DB_BIKE_DECS = "bikedescription"
        private var DB_BIKE_PRICE = "bikeprice"
        private var DB_BIKE_SETCAP = "setcap"
        private var DB_BIKE_FULLCAP = "fullcap"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        var query = "CREATE TABLE $TB_NAME($D_USERNAME TEXT PRIMARY KEY,$D_PASSWORD TEXT)"

        var bikequery = "CREATE TABLE $TABLE_NAME($DB_BIKE_ID INTEGER PRIMARY KEY AUTOINCREMENT" +
                ",$DB_BIKE_NAME TEXT,$DB_BIKE_DECS TEXT,$DB_BIKE_PRICE INTEGER,$DB_BIKE_SETCAP INTEGER,$DB_BIKE_FULLCAP INTEGER)"

        p0?.execSQL(query);
        p0?.execSQL(bikequery);
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        var query = "DROP TABLE $TB_NAME IF EXISTS"

        var bikequery = "DROP TABLE $TABLE_NAME IF EXISTS"
        p0?.execSQL(query);
        p0?.execSQL(bikequery);
        onCreate(p0)
    }

    fun insertdata(users: Users): Boolean {
        var db = writableDatabase
        var cv = ContentValues()
        cv.put(D_USERNAME, users.d_username)
        cv.put(D_PASSWORD, users.d_password)
        var flag = db.insert(TB_NAME, null, cv)
        if (flag > 0) {
            return true
        } else {
            return false
        }
    }

    fun bikeinsert(emp: Bike): Boolean {
        var db=writableDatabase
        var cv= ContentValues()
        cv.put(DB_BIKE_NAME,emp.bike_name)
        cv.put(DB_BIKE_DECS,emp.bike_desc)
        cv.put(DB_BIKE_PRICE,emp.bike_price)
        cv.put(DB_BIKE_SETCAP,emp.bike_stecap)
        cv.put(DB_BIKE_FULLCAP,emp.bike_fullcap)

        var flag= db.insert(TABLE_NAME,null,cv)
        if (flag>0)
        {
            return true
        }
        else
        {
            return false
        }

    }

    fun retrivedata(): ArrayList<Users> {
        var db = readableDatabase
        var cursor = db.query(TB_NAME, null, null, null, null, null, null)
        var arr: ArrayList<Users> = ArrayList()
        while (cursor.moveToNext()) {
            var usern = cursor.getString(0)
            var passw = cursor.getString(1)
            var users = Users(usern, passw)
            arr.add(users)
        }
        return arr
    }

    fun bike_retriveall():ArrayList<Bike>
    {
        var db =readableDatabase
        var cursor=db.query(TABLE_NAME,null,null,null,null,null,null)
        var arr:ArrayList<Bike> = ArrayList()
        while (cursor.moveToNext())
        {
            var id=cursor.getInt(0)
            var bikename=cursor.getString(1)
            var bikedesc=cursor.getString(2)
            var bikeprice=cursor.getInt(3)
            var bikestecap=cursor.getInt(4)
            var bikefullcap=cursor.getInt(5)
            var emp=Bike(id,bikename,bikedesc,bikeprice,bikestecap,bikefullcap)
            arr.add(emp)
        }
        return arr
    }

    fun GetAllBike(): ArrayList<Bike> {
        var db = readableDatabase
        var arr = ArrayList<Bike>()
        var cursor = db.query(TABLE_NAME, null, null, null, null, null, null)
        while (cursor.moveToNext()) {
            var id = cursor.getInt(0)
            var bikename = cursor.getString(1)
            var bikedesc = cursor.getString(2)
            var bikeprice = cursor.getInt(3)
            var bikestecap = cursor.getInt(4)
            var bikefullcap = cursor.getInt(5)
            var emp = Bike(id, bikename, bikedesc, bikeprice, bikestecap, bikefullcap)
            arr.add(emp)


        }
        return arr
        db.close()
    }

    fun Delete(id: Int) {
        var db = writableDatabase
        db.delete(TABLE_NAME, "$DB_BIKE_ID=$id", null)
        db.close()
    }

    fun retriveAll(): ArrayList<Bike_updeta> {
        var arr = ArrayList<Bike_updeta>()
        var db = readableDatabase
        var cursor = db.query(TABLE_NAME, null, null, null, null, null, null)
        while (cursor.moveToNext()) {

            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var desc = cursor.getString(2)
            var p = Bike_updeta(id, name, desc)
            arr.add(p)
        }
        return arr

    }

    fun update(p: Bike_updeta) {
        var db = writableDatabase
        var cv = ContentValues()
        cv.put(DB_BIKE_NAME, p.bname)
        cv.put(DB_BIKE_DECS, p.bdesc)
        var flag = db.update(
            TABLE_NAME, cv, "$DB_BIKE_ID=${p.bid}",
            null
        )
        db.close()
    }

    fun bike_opretion(): ArrayList<Bike_opration> {
        var arr = ArrayList<Bike_opration>()
        var db = readableDatabase
        var cursor = db.query(TABLE_NAME, null, null, null, null, null, null)
        while (cursor.moveToNext()) {

            var id = cursor.getInt(0)
            var price = cursor.getInt(3)
            var p = Bike_opration(id, price)
            arr.add(p)
        }
        return arr

    }

}