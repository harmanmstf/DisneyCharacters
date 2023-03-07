package com.example.disneycharacters.ui.characterdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.disneycharacters.data.entities.Character
import com.example.disneycharacters.databinding.FragmentCharacterDetailBinding
import com.example.disneycharacters.utils.Resource
import com.example.disneycharacters.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailFragment : Fragment() {

    private var binding: FragmentCharacterDetailBinding by autoCleared()
    private val viewModel: CharacterDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentCharacterDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getInt("id")?.let { viewModel.start(it) }
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.character.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    bindCharacter(it.data!!)
                    binding.progressBar.visibility = View.GONE
                    binding.characterCl.visibility = View.VISIBLE
                }

                Resource.Status.ERROR ->
                    Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.characterCl.visibility = View.GONE
                }
            }
        })
    }

    private fun bindCharacter(character: Character) {
        binding.name.text = character.name
//        binding.tvfilms.text = character.films
//        binding.tvShortFilms.text = character.shortFilms
//        binding.tvTvShows.text = character.tvShows
//        binding.tvVideoGames.text = character.videoGames
        Glide.with(binding.root)
            .load(character.imageUrl)
            .transform(CircleCrop())
            .into(binding.image)
    }
}
