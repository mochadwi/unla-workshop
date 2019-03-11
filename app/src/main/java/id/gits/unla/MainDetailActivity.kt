package id.gits.unla

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.android.synthetic.main.main_content.*
import java.util.*

class MainDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setSupportActionBar(toolbar)

        rvList.apply {
            layoutManager = LinearLayoutManager(this@MainDetailActivity)
            adapter = MainAdapter(loadData() as ArrayList<News>, this@MainDetailActivity) {
                Toast
                    .makeText(context, "Clicked to detail!", Toast.LENGTH_LONG)
                    .show()
            }
        }

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun loadData(): List<News> {
        val list: MutableList<News>? = mutableListOf()

        for (i in 0 until 10) {
            list?.add(
                News(
                    id = i,
                    title = "TITLE $i",
                    description = "DESCRIPTION BLABLA"
                )
            )
        }

        return list ?: emptyList()
    }
}
