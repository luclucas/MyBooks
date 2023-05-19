package com.lulu.mybooks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.lulu.mybooks.databinding.FragmentAddLivroBinding
import com.lulu.mybooks.db.Livro
import com.lulu.mybooks.db.LivroDatabase
import com.lulu.mybooks.db.LivroRepository

class AddLivro : Fragment() {
    private lateinit var binding: FragmentAddLivroBinding
    private lateinit var livroViewModel: LivroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_livro, container, false)
        val context = requireActivity()
        val dao = LivroDatabase.getInstance(context).livrosDao
        val repository = LivroRepository(dao)
        val factory = LivroViewModelFactory(repository)
        livroViewModel = ViewModelProvider(this, factory)[LivroViewModel::class.java]
        binding.myViewModel = livroViewModel
        binding.lifecycleOwner = this


//        binding.BotaoSalvar.setOnClickListener {
//            val titulo = binding.editTextTitulo.text.toString()
//
//            val livro = Livro()
//            livroViewModel.insert()
//        }
        return binding.root
    }

}
