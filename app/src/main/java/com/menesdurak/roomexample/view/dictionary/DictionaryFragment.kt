package com.menesdurak.roomexample.view.dictionary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.menesdurak.roomexample.R
import com.menesdurak.roomexample.adapter.WordAdapter
import com.menesdurak.roomexample.database.WordDatabase
import com.menesdurak.roomexample.databinding.FragmentDictionaryBinding
import com.menesdurak.roomexample.model.Word
import com.menesdurak.roomexample.repository.WordRepository

class DictionaryFragment : Fragment() {
    private var _binding: FragmentDictionaryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDictionaryBinding.inflate(inflater, container, false)
        val view = binding.root

        val wordDao = WordDatabase.getDatabase(requireContext()).getWordDao()
        val repository = WordRepository(wordDao)
        val viewModel: WordViewModel by viewModels<WordViewModel> {
            WordViewModelFactory(repository)
        }

//        val word1 = Word("Red", "Kırmızı")
//        val word2 = Word("Blue", "Mavi")
//        val word3 = Word("Yellow", "Sarı")

//        viewModel.addWord(word1)
//        viewModel.addWord(word2)
//        viewModel.addWord(word3)

//        viewModel.wordlist.observe(viewLifecycleOwner, {
//            for(i in it) {
//                println(i.name)
//            }
//        })

        viewModel.wordlist.observe(viewLifecycleOwner, {
            binding.recyclerView.layoutManager = LinearLayoutManager(context)
            val wordAdapter = WordAdapter(it)
            binding.recyclerView.adapter = wordAdapter
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGoToAdd.setOnClickListener {
            findNavController().navigate(R.id.addWordFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}