package br.ufsc.rodolfo.brasilnarussia

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.player_item.view.*

class PlayersListAdapter(private val players: List<Player>,
                         private val context: Context) : RecyclerView.Adapter<PlayersListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.player_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return players.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val player = players[position]
        holder.let {
            it.bindView(player)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(player: Player) {
            val nome = itemView.text_nome_jogador
            val posicao = itemView.text_jogador_posicao
            val idade = itemView.text_jogador_idade
            val time = itemView.text_jogador_time

            nome.text = player.name
            posicao.text = player.position
            idade.text = player.age
            time.text = player.team
        }

    }
}