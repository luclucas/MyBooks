package com.lulu.mybooks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.lulu.mybooks.databinding.LivroRecyclerCardBinding
import com.lulu.mybooks.db.Livro

class RecyclerViewAdapter (private val livroList: List<Livro>, private val clickListener:(Livro)->Unit): RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: LivroRecyclerCardBinding = DataBindingUtil.inflate(layoutInflater, R.layout.livro_recycler_card, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return livroList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(livroList[position], clickListener)
    }
}

class MyViewHolder(val binding: LivroRecyclerCardBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(livro: Livro, clickListener: (Livro) -> Unit){
        binding.tituloTextView.text = livro.titulo
        binding.autorTextView.text = livro.autor

        binding.itemLivroLayout.setOnClickListener{
            clickListener(livro)
        }
    }
}
