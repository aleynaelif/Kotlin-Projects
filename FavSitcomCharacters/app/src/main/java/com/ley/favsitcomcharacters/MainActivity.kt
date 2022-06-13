package com.ley.favsitcomcharacters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ley.favsitcomcharacters.databinding.ActivityDetailsBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailsBinding
    private lateinit var sitcomList : ArrayList<Sitcom>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        //Initilize
        sitcomList = ArrayList<Sitcom>()

        //Data
        val cam = Sitcom("Cameron Tucker","Modern Family",R.drawable.cam)
        val jake = Sitcom("Jake Peralta","Brooklyn 99",R.drawable.jake)
        val phoebe = Sitcom("Phoebe Buffay","Friends",R.drawable.phobe)
        val sheldon = Sitcom("Sheldon Cooper","Big Bang Theory",R.drawable.sheldon)

        //Adding
        sitcomList.add(cam);
        sitcomList.add(jake)
        sitcomList.add(phoebe)
        sitcomList.add(sheldon)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val sitcomAdapter = SitcomAdapter (sitcomList)
        binding.recyclerView= sitcomAdapter

    }
}