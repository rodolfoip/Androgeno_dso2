package br.ufsc.rodolfo.brasilnarussia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list_players.*

class ListPlayersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_players)

        val players = Player.getPlayersFromFile("players.json", this)
        val recyclerView = recycler_view_jogadores

        recyclerView.adapter = PlayersListAdapter(players, this)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
    }
}
