package com.khushal.splashscreenwithlifecycle

data class Bike(
    var bike_name: String,
    var bike_desc: String,
    var bike_price: Int,
    var bike_stecap: Int,
    var bike_fullcap: Int
) {
    var id = 0

    constructor(
        id: Int,
        bike_name: String,
        bike_desc: String,
        bike_price: Int,
        bike_stecap: Int,
        bike_fullcap: Int
    ) : this(bike_name, bike_desc, bike_price, bike_stecap, bike_fullcap) {
        this.id = id
    }
}

data class Bike_updeta(var bid: Int, var bname: String, var bdesc: String)
data class Bike_opration(var opid: Int, var opprice: Int)