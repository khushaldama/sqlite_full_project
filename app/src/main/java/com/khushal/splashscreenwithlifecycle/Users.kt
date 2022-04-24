package com.khushal.splashscreenwithlifecycle

data class Users(var d_username: String, var d_password: String) {
    var Uname: String=""
    var Upassword: String=""
    constructor(Uname: String,Upassword: String,d_username: String,d_password: String)
            :this(d_username,d_password){
                this.Uname=Uname
                this.Upassword=Upassword
    }
}