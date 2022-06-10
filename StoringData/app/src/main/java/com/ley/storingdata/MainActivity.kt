package com.ley.storingdata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ley.storingdata.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //sharedPreerences initilize
        sharedPreferences = this.getSharedPreferences("com.ley.storingdata", Context.MODE_PRIVATE)

        val ageFromPreferences = sharedPreferences.getInt("Age",0)

        if(ageFromPreferences == 0){
            printAge.text = "Your Age: "
        }
        else{
            printAge.text = "Your Age: $ageFromPreferences"
        }
    }

    fun save (view: View){

        //SharedPreferences

        val myAge = ageText.text.toString().toIntOrNull()

        if(myAge != null){
            printAge.text = "Your Age: " + myAge
            sharedPreferences.edit().putInt("Age",myAge).apply()
        }
    }

    fun delete (view:View){
        if(!sharedPreferences.equals(null)){
            sharedPreferences.edit().remove("Age").apply()
            printAge.text = "Your Age: "
        }

    }
}