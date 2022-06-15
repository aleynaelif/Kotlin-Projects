package com.ley.favalbums

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.ley.favalbums.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding : ActivityMainBinding
    private lateinit var albumList : ArrayList<Album>
    private lateinit var albumAdapter: AlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        albumList = ArrayList<Album>()

        albumAdapter= AlbumAdapter(albumList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = albumAdapter

        try{

            val database = this.openOrCreateDatabase("Albums", MODE_PRIVATE,null)

            val cursor = database.rawQuery("SELECT *FROM albums",null)
            val albumnameIx = cursor.getColumnIndex("albumname")
            val idIx =  cursor.getColumnIndex("id")

            while(cursor.moveToNext()){
                val name =  cursor.getString(albumnameIx)
                val id = cursor.getInt(idIx)
                val album = Album(name,id)

                albumList.add(album)

            }
            albumAdapter.notifyDataSetChanged()
            cursor.close()
        }
        catch (e: Exception){
            e.printStackTrace()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //inflater
        val menuInflater= menuInflater
        menuInflater.inflate(R.menu.album_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.add_album_item){
            val intent = Intent (this@MainActivity,DetailsActivity::class.java)
            intent.putExtra("info","new")
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

}