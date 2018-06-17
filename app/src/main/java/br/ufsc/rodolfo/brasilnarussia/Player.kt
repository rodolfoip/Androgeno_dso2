package br.ufsc.rodolfo.brasilnarussia

import android.content.Context
import org.json.JSONException
import org.json.JSONObject


class Player(val name: String,
             val age: String,
             val position: String,
             val team: String) {
    companion object {
        fun getPlayersFromFile(filename: String, context: Context): ArrayList<Player> {

            val playersList = ArrayList<Player>()

            try {
                val jsonString = Player.loadJsonFromAsset("players.json", context)
                val json = JSONObject(jsonString)
                val playersContent = json.getJSONArray("players")

                (0 until playersContent.length()).mapTo(playersList) {
                    Player(playersContent.getJSONObject(it).getString("name"),
                            playersContent.getJSONObject(it).getString("age"),
                            playersContent.getJSONObject(it).getString("position"),
                            playersContent.getJSONObject(it).getString("team"))
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            println(playersList)
            return playersList
        }

        private fun loadJsonFromAsset(filename: String, context: Context): String? {
            var json: String? = null
            try {
                val inputStream = context.assets.open(filename)
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                json = String(buffer, Charsets.UTF_8)
            } catch (ex: java.io.IOException) {
                ex.printStackTrace()
                return null
            }

            return json
        }
    }

    override fun toString(): String {
        return "Player(name='$name', age='$age', position='$position', team='$team')"
    }

}
