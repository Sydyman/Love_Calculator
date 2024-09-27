package com.ex.love_calculator.ui.fragments


import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ex.love_calculator.R
import com.ex.love_calculator.data.HistoryDao
import com.ex.love_calculator.data.HistoryEntity
import com.ex.love_calculator.data.LoveDao
import com.ex.love_calculator.databinding.FragmentHistoryBinding
import com.ex.love_calculator.models.LoveModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HistoryFragment : Fragment() {
    @Inject
    lateinit var historyDao: HistoryDao
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var adapter: HistoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = HistoryAdapter { historyEntity ->
            showDeleteDialog(historyEntity)
        }

        binding.rvHistory.apply {
            adapter = adapter
            layoutManager = LinearLayoutManager(context)
        }

        lifecycleScope.launch {
            val historyList = historyDao.getAllHistory()
            adapter.submitList(historyList)
        }

        binding.backResultImg.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun showDeleteDialog(historyEntity: HistoryEntity) {
        val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.delete_dialog, null)

        dialogView.findViewById<TextView>(R.id.dialog_title).text = "Delete Item"
        dialogView.findViewById<TextView>(R.id.dialog_message).text =
            "Are you sure, you want to delete this item?"

        val builder = AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .setPositiveButton("Yes") { dialog, _ ->
                lifecycleScope.launch {
                    historyDao.delete(historyEntity)
                }
                dialog.dismiss()
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }
            .create()

        builder.show()
    }
}