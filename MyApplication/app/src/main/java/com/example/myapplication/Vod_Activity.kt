package com.example.myapplication

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.content.edit
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.Collections.addAll

var Spis : MutableList<Spisok> = mutableListOf()
private lateinit var deloText: EditText
private lateinit var timeText: EditText
private lateinit var dataText: EditText
private lateinit var dobav : Button
class Vod_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vod)
        getSpisok()
        deloText = findViewById(R.id.DeloText)
        timeText = findViewById((R.id.TimeText))
        dataText = findViewById(R.id.DataText)
        dobav = findViewById(R.id.button3)
        dobav.setOnClickListener{
            addSpisok(deloText.text.toString(), timeText.text.toString(), dataText.text.toString())
        }
    }
    private fun getSpisok(){
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
    private fun addSpisok(delo:String,time:String,data:String){
        val Temp = Spisok(delo,time,data)
        Spis.add(Temp)
        val preferences = getSharedPreferences("pref", MODE_PRIVATE)
        preferences.edit{
            this.putString("json",Gson().toJson(Spis).toString())
        }
    }
}