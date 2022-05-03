package com.chloedewyes.check_bang.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.chloedewyes.check_bang.R
import com.chloedewyes.check_bang.adapter.BookAdapter
import com.chloedewyes.check_bang.databinding.FragmentBookViewBinding
import com.chloedewyes.check_bang.viewmodels.BookViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookViewFragment : Fragment() {

    private var _binding: FragmentBookViewBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BookViewModel by viewModels()

    val args: BookViewFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        val bookItem = args.bookItem

        Glide.with(this)
            .load(bookItem.image)
            .into(binding.ivBookImage)

        binding.tvTitle.text = bookItem.title
        binding.tvAuthor.text = bookItem.author
        binding.tvPublishedAt.text = bookItem.publisher
        binding.tvPubdate.text = bookItem.pubdate

        binding.fab.setOnClickListener {
            viewModel.saveBookItem(bookItem)
            Snackbar.make(view, "저장되었습니다 :)", Snackbar.LENGTH_SHORT).show()
        }
    }
}