package com.menesdurak.roomexample.view.dictionary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.menesdurak.roomexample.R
import com.menesdurak.roomexample.databinding.FragmentDictionaryBinding
import com.menesdurak.roomexample.model.Word
import com.menesdurak.roomexample.view.WordApplication

class DictionaryFragment : Fragment() {
    private var _binding: FragmentDictionaryBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: WordViewModel by activityViewModels {
        BusScheduleViewModelFactory(
            (activity?.application as WordApplication).database.getWordDao()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDictionaryBinding.inflate(inflater, container, false)
        val view = binding.root

        val word1 = Word("Red", "Kırmızı")
        val word2 = Word("Blue", "Mavi")

        viewModel.addWord(word1)
        viewModel.addWord(word2)

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