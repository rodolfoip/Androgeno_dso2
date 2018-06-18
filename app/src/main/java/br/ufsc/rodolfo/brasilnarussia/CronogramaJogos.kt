package br.ufsc.rodolfo.brasilnarussia

import android.content.Context
import org.json.JSONException
import org.json.JSONObject

class CronogramaJogos(val data: String,
                      val horario: String,
                      val local: String,
                      val lat: String,
                      val lng: String) {
    companion object {
        fun getCronogramaFromFile(filename: String, context: Context): ArrayList<CronogramaJogos> {

            val jogosList = ArrayList<CronogramaJogos>()

            try {
                val jsonString = loadJsonFromAsset("jogos.json", context)
                val json = JSONObject(jsonString)
                val cronogramaContent = json.getJSONArray("jogos")

                (0 until cronogramaContent.length()).mapTo(jogosList) {
                    CronogramaJogos(cronogramaContent.getJSONObject(it).getString("data"),
                            cronogramaContent.getJSONObject(it).getString("horario"),
                            cronogramaContent.getJSONObject(it).getString("local"),
                            cronogramaContent.getJSONObject(it).getString("lat"),
                            cronogramaContent.getJSONObject(it).getString("lng"))
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return jogosList
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
}