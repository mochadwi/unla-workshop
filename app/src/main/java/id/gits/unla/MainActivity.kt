package id.gits.unla

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.android.synthetic.main.main_content.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setSupportActionBar(toolbar)

        rvList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MainAdapter(loadData() as ArrayList<News>, this@MainActivity) {
                startActivity(
                    Intent(this@MainActivity, MainDetailActivity::class.java).apply {
                        putExtra("news-key", it)
                        putExtra("string-key", Gson().toJson(it))
//                        flags
                    }
                )
            }
        }
    }

    private fun loadData(): List<News> {
        val list: MutableList<News>? = mutableListOf()

        (0..9).forEachIndexed { i, news ->
            list?.add(
                News(
                    id = i,
                    title = "TITLE $i",
                    description = "DESCRIPTION BLABLA $i"
                )
            )
        }

        return list ?: emptyList()
    }
}
