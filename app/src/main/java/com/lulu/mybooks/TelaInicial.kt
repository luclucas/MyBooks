package com.lulu.mybooks

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.lulu.mybooks.databinding.FragmentTelaInicialBinding
import com.lulu.mybooks.db.Livro
import com.lulu.mybooks.db.LivroDatabase
import com.lulu.mybooks.db.LivroRepository


class TelaInicial : Fragment() {

    private lateinit var binding: FragmentTelaInicialBinding
    private lateinit var livrosViewModel: LivroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val context = requireActivity()
        val dao = LivroDatabase.getInstance(context).livrosDao
        val repository = LivroRepository(dao)
        val factory = LivroViewModelFactory(repository)
        livrosViewModel = ViewModelProvider(this, factory)[LivroViewModel::class.java]
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_tela_inicial, container, false)


        binding.floatingActionButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_telaInicial_to_addLivro)
        }
        binding.lifecycleOwner = this

    //   initRecyclerView()

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        initRecyclerView()
    }
    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        displayLivros()

    }

    private fun displayLivros() {

        livrosViewModel.livros.observe(viewLifecycleOwner) {

            Log.i("Lulu", it.toString())
            binding.recyclerView.adapter =
                RecyclerViewAdapter(it) { selectedItem: Livro -> listItemClicked(selectedItem) }

        }
    }

    private fun listItemClicked(livro: Livro) {
        //  livrosViewModel.init
    }
}