package br.ufsc.rodolfo.brasilnarussia

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun abrirListaJogadores(view: View?) {
        val intentPlayers = Intent(this, ListPlayersActivity::class.java)
        startActivity(intentPlayers)
    }

    fun abrirListaNoticias(view: View?) {
        val intentNews = Intent(this, NewsActivity::class.java)
        startActivity(intentNews)
    }

    fun abrirMapaLocaisJogoBR(view: View?) {
        val intentMaps = Intent(this, CronogramaActivity::class.java)
        startActivity(intentMaps)
    }


}
