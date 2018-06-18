package br.ufsc.rodolfo.brasilnarussia

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_news_details.*

class NewsDetailsActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    companion object {
        const val EXTRA_TITLE = "title"
        const val EXTRA_URL = "url"

        fun newIntent(context: Context, news: News): Intent {
            val detailIntent = Intent(context, NewsDetailsActivity::class.java)

            detailIntent.putExtra(EXTRA_TITLE, news.title)
            detailIntent.putExtra(EXTRA_URL, news.newsUrl)

            return detailIntent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)

        val title = intent.extras.getString(EXTRA_TITLE)
        val url = intent.extras.getString(EXTRA_URL)

        setTitle(title)
        println( "aqui"+url)
        webView = detail_web_view
        webView.loadUrl(url)
    }
}
