package com.ley.favsitcomcharacters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ley.favsitcomcharacters.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = intent
        val selectedSitcom =  intent.getSerializableExtra("sitcom") as Sitcom

        binding.nameText.text =selectedSitcom.name
        binding.sitcomText.text =selectedSitcom.sitcom
        binding.imageView.setImageResource(selectedSitcom.image)

    }
}