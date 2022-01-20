package com.chloedewyes.check_bang.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.chloedewyes.check_bang.R
import com.chloedewyes.check_bang.adapter.BookAdapter
import com.chloedewyes.check_bang.databinding.FragmentBookStoreBinding
import com.chloedewyes.check_bang.viewmodels.BookViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BookStoreFragment : Fragment() {

    private var _binding: FragmentBookStoreBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BookViewModel by viewModels()
    lateinit var bookAdapter: BookAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookStoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bookAdapter = BookAdapter()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.rvBookStore.adapter = bookAdapter

        bookAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("bookItem", it)
            }

            findNavController().navigate(
                R.id.action_bookstoreFragment_to_bookViewFragment,
                bundle
            )
        }

        var job: Job? = null
        binding.etSearch.addTextChangedListener { editable ->
            job?.cancel()
            job = MainScope().launch {
                delay(500L)
                editable?.let {
                    if (editable.toString().isNotEmpty()) {
                        viewModel.searchBook(editable.toString())
                    }
                }
            }
        }
    }
}