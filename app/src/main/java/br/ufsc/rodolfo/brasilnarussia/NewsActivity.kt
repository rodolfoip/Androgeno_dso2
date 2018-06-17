package br.ufsc.rodolfo.brasilnarussia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val newsList = News.getNewsFromFile("news.json", this)
        val recyclerViewNews = recycler_news

        recyclerViewNews.adapter = NewsListAdapter(this, newsList)
        recyclerViewNews!!.layoutManager = LinearLayoutManager(this)
    }
}