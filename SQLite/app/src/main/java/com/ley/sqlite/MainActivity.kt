package com.ley.sqlite

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        try{
            //namei büyük harfle yaz
            val myDatabase = this.openOrCreateDatabase("Musicians", Context.MODE_PRIVATE,null)

            //verilere id verirken id INTEGER PRIMARY KEY kullanılır
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS musicians (id INTEGER PRIMARY KEY,name VARCHAR, age INT)")

            //stringler tek ' ile yazılır

            myDatabase.execSQL("INSERT INTO musicians (name,age) VALUES ('James',50)")
            myDatabase.execSQL("INSERT INTO musicians (name,age) VALUES ('Lars',60)")
            myDatabase.execSQL("INSERT INTO musicians (name,age) VALUES ('Kirk',45)")

            //verileri çekmek
            var cursor = myDatabase.rawQuery("SELECT * FROM musicians WHERE id = 3",null)

            //sonu syle biten isimleri bastırır
            cursor = myDatabase.rawQuery("SELECT * FROM musicians WHERE name LIKE '%s'",null)

            //K ile başlayan isimleri bastır
            cursor = myDatabase.rawQuery("SELECT * FROM musicians WHERE name LIKE 'K%'",null)

            cursor = myDatabase.rawQuery("SELECT * FROM musicians",null)

            //verileri güncelleme
            myDatabase.execSQL("UPDATE musicians SET age =61 WHERE name = 'Lars'")
            myDatabase.execSQL("UPDATE musicians SET name = 'Kirk Hammet' WHERE id= 3")

            //verileri silme
            myDatabase.execSQL("DELETE FROM musicians WHERE name = 'Lars'")


            val nameIx = cursor.getColumnIndex("name")
            val ageIx = cursor.getColumnIndex("age")
            val idIx = cursor.getColumnIndex("id")

            while(cursor.moveToNext()){
                println("Name: " + cursor.getString(nameIx))
                println("Age: " + cursor.getInt(ageIx))
                println("Id: " + cursor.getInt(idIx))
            }

            cursor.close()

        }catch (e:Exception){
            e.printStackTrace()
        }
    }


}