package id.gits.unla

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.android.synthetic.main.maindetail_content.*

class MainDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.maindetail_activity)
        setSupportActionBar(toolbar)

        savedInstanceState?.let {
            Toast
                .makeText(this@MainDetailActivity, "savedinstance not null", Toast.LENGTH_SHORT)
                .show()
        }

        intent.apply {
            val item = Gson().fromJson(getStringExtra("string-key"), News::class.java)

            if (item != null) {
                tvTitle.text = item.title
                tvDescription.text = item.description
                Toast
                    .makeText(this@MainDetailActivity, "${item.id}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}
