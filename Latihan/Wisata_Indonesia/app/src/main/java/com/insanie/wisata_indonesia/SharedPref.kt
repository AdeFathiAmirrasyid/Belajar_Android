package com.insanie.wisata_indonesia

import android.content.Context
import android.content.SharedPreferences

class SharedPref (context: Context) {

    private val read : SharedPreferences = context.getSharedPreferences(BuildConfig.APPLICATION_ID,Context.MODE_PRIVATE)
    private val write : SharedPreferences.Editor = read.edit()

    // source code untuk menulis data ke sharedPreferences
    fun setDataShared(key : String,value : Any?){
        when(value){
            is Boolean   -> write.putBoolean(key, value)
            is Float     -> write.putFloat(key, value)
            is Int       -> write.putInt(key, value)
            is Long      -> write.putLong(key, value)
            is String    -> write.putString(key, value)
        }
        write.commit()
    }

    // source code untuk membaca tipe data tertentu
    fun getBolean(key: String,default : Boolean = false) = read.getBoolean(key,default)
    fun getFloat(key: String,default: Float = 0f) = read.getFloat(key,default)
    fun getInt(key: String,default: Int = 0) = read.getInt(key,default)
    fun getLong(key: String,default: Long = 0) = read.getLong(key,default)
    fun getString(key: String,default: String? = null) = read.getString( key,default)


    // source code untuk setting apa saja yang menggunakan sharedPreferences
    companion object{
        const val GRID_LAYOUT   = "grid_layout"
        const val DESC          = "descriptions"
        const val APP_NAME      = "app_name"
        const val COLOMN        = "colomn"
    }

    var gridLayout : Boolean
        set(value) = setDataShared(GRID_LAYOUT,value)
        get() = getBolean(GRID_LAYOUT)

    var descriptions : Boolean
        set(value) = setDataShared(DESC,value)
        get() = getBolean(GRID_LAYOUT)
    var appName : String?
        set(value) = setDataShared(APP_NAME,value)
        get() = getString(APP_NAME)
    var getColomn : Int
        set(value) = setDataShared(COLOMN,value)
        get() = getInt(COLOMN)

}