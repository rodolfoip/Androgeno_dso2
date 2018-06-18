package br.ufsc.rodolfo.brasilnarussia

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.AdapterView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_list_item.view.*

class NewsListAdapter(private val context: Context,
                      private val newsList: ArrayList<News>) : RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.news_list_item, parent, false)

        return ViewHolder(view, context)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = newsList[position]

        holder.let {
            it.bindView(news)
        }

        holder.setOnCustomItemClickListener(object : CustomItemClickListener {
            override fun onCustomItemClickListener(view: View, pos: Int) {
                val newsDetailsActivity = NewsDetailsActivity.newIntent(context,newsList[pos])
                context.startActivity(newsDetailsActivity)
            }

        })

    }

    class ViewHolder(itemView: View, context: Context) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var customItemClickListener: CustomItemClickListener? = null

        init {
            itemView.setOnClickListener(this)
        }


        fun setOnCustomItemClickListener(itemClickListener: CustomItemClickListener) {
            this.customItemClickListener = itemClickListener
        }


        override fun onClick(v: View?) {
            this.customItemClickListener!!.onCustomItemClickListener(v!!, adapterPosition)
        }

        val con = context

        fun bindView(news: News) {
            val titulo = itemView.news_list_titulo
            val descricao = itemView.news_list_description
            val imagem = itemView.news_list_image

            titulo.text = news.title
            descricao.text = news.description
            Picasso.with(con).load(news.imageUrl).placeholder(R.mipmap.ic_launcher_round).into(imagem)
        }
    }
}