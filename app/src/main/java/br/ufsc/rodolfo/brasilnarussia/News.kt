package br.ufsc.rodolfo.brasilnarussia

import android.content.Context
import org.json.JSONException
import org.json.JSONObject

class News(
        val title: String,
        val description: String,
        val imageUrl: String,
        val newsUrl: String) {
    companion object {
        fun getNewsFromFile(filename: String, context: Context): ArrayList<News> {

            val newsList = ArrayList<News>()

            try {
                val jsonString = loadJsonFromAsset("news.json", context)
                val json = JSONObject(jsonString)
                val newsContent = json.getJSONArray("news")

                (0 until newsContent.length()).mapTo(newsList) {
                    News(newsContent.getJSONObject(it).getString("title"),
                            newsContent.getJSONObject(it).getString("description"),
                            newsContent.getJSONObject(it).getString("imageUrl"),
                            newsContent.getJSONObject(it).getString("newsUrl"))
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return newsList
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