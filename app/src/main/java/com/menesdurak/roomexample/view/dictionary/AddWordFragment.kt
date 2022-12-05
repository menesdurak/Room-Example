package com.menesdurak.roomexample.view.dictionary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.menesdurak.roomexample.R
import com.menesdurak.roomexample.database.WordDatabase
import com.menesdurak.roomexample.databinding.FragmentAddWordBinding
import com.menesdurak.roomexample.databinding.FragmentDictionaryBinding
import com.menesdurak.roomexample.model.Word
import com.menesdurak.roomexample.repository.WordRepository

class AddWordFragment : Fragment() {

    private var _binding: FragmentAddWordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddWordBinding.inflate(inflater, container, false)
        val view = binding.root

        val wordDao = WordDatabase.getDatabase(requireContext()).getWordDao()
        val repository = WordRepository(wordDao)
        val viewModel: WordViewModel by viewModels<WordViewModel> {
            WordViewModelFactory(repository)
        }

        binding.btnAdd.setOnClickListener {
            val name = binding.etAddName.text.toString()
            val meaning = binding.etAddMeaning.text.toString()
            val word = Word(name, meaning)
            viewModel.addWord(word)
            findNavController().navigate(R.id.dictionaryFragment)
        }

        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}