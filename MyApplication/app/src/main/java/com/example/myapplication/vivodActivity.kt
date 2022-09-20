package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class vivodActivity : AppCompatActivity() {
    val Spis : MutableList<Spisok> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vivod)
        getSpisok()
        Spis.forEach{
            Log.d("bb",it.toString())
        }

    }
    private fun getSpisok()
    {
        val preferences = getSharedPreferences("pref", MODE_PRIVATE)
        var json:String = ""
        if (!preferences.contains("json"))
        {
            return
        }
        else{
            json = preferences.getString("json","NOT_JSON").toString()
        }
        val spisokList = Gson().fromJson<List<Spisok>>(json, object  : TypeToken<List<Spisok>>(){}.type)
        Spis.addAll(spisokList)
    }
}
