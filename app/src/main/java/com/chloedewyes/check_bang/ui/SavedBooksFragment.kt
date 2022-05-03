package com.chloedewyes.check_bang.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.chloedewyes.check_bang.adapter.BookAdapter
import com.chloedewyes.check_bang.databinding.FragmentSavedBooksBinding
import com.chloedewyes.check_bang.viewmodels.BookViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedBooksFragment : Fragment() {

    private var _binding: FragmentSavedBooksBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BookViewModel by viewModels()
    lateinit var bookAdapter: BookAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSavedBooksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bookAdapter = BookAdapter()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.rvSavedBooks.adapter = bookAdapter

        viewModel.getSavedBookItem().observe(viewLifecycleOwner, {
            bookAdapter.submitList(it)
        })

        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val bookItem = bookAdapter.currentList[position]
                viewModel.deleteBookItem(bookItem)
                Snackbar.make(view, "삭제했습니다 :)", Snackbar.LENGTH_LONG).apply {
                    setAction("취소") {
                        viewModel.saveBookItem(bookItem)
                    }
                    show()

                }
            }
        }

        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(binding.rvSavedBooks)
        }
    }




}