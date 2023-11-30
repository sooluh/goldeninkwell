package id.sooluh.muslim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private var lastClick: Long = 0
    private val clickDelay = 500
    private lateinit var rvScientists: RecyclerView
    private val list = ArrayList<Scientist>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvScientists = findViewById(R.id.rv_scientists)
        rvScientists.setHasFixedSize(true)

        list.addAll(getListScientists())
        showRecyclerList()

        val fab: FloatingActionButton = findViewById(R.id.goto_about_page)

        fab.setOnClickListener {
            val clickTime = System.currentTimeMillis()
            if (clickTime - lastClick > clickDelay) {
                lastClick = clickTime
                startActivity(Intent(this, AboutActivity::class.java))
            }
        }
    }

    private fun getListScientists(): ArrayList<Scientist> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataFullName = resources.getStringArray(R.array.data_full_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listScientist = ArrayList<Scientist>()

        for (i in dataName.indices) {
            val scientist = Scientist(
                dataName[i],
                dataFullName[i],
                dataDescription[i],
                dataPhoto.getResourceId(i, -1)
            )

            listScientist.add(scientist)
        }

        dataPhoto.recycle()

        return listScientist
    }

    private fun showRecyclerList() {
        rvScientists.layoutManager = LinearLayoutManager(this)
        val listScientistAdapter = ListScientistAdapter(list)
        rvScientists.adapter = listScientistAdapter
    }
}