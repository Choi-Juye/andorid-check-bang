package com.chloedewyes.check_bang

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.chloedewyes.check_bang.databinding.FragmentBookStoreBinding
import com.chloedewyes.check_bang.viewmodels.BookViewModel

class BookstoreFragment : Fragment() {

    private val viewModel: BookViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentBookStoreBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_book_store, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.searchBook("test")

    }
}