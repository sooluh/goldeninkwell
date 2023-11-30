package id.sooluh.muslim

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.appbar.MaterialToolbar

class DetailActivity : AppCompatActivity() {
    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataScientist = intent.getParcelableExtra<Scientist>("key_scientist")!!
        val topAppBar: MaterialToolbar = findViewById(R.id.top_app_bar)
        val imgPhoto = findViewById<ImageView>(R.id.img_item_photo)
        val tvName = findViewById<TextView>(R.id.tv_item_name)
        val tvDescription = findViewById<TextView>(R.id.tv_item_description)

        topAppBar.setNavigationOnClickListener { finish() }
        topAppBar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white))
        topAppBar.title = dataScientist.name
        imgPhoto.setImageResource(dataScientist.photo)
        tvName.text = dataScientist.fullName
        tvDescription.text = dataScientist.description

        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.favorite -> {
                    Toast.makeText(this, "Fitur ini masih dalam tahap pengembangan!", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.share -> {
                    val dataScientist = intent.getParcelableExtra<Scientist>("key_scientist")!!
                    val shareText = """
                        Nama: ${dataScientist.name}
                        Nama Lengkap: ${dataScientist.fullName}

                        Deskripsi:
                        ${dataScientist.description}
                    """
                    val shareIntent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(Intent.EXTRA_TEXT, shareText.trimIndent())
                    }

                    if (shareIntent.resolveActivity(packageManager) != null) {
                        startActivity(shareIntent)
                    } else {
                        Toast.makeText(this, "Tidak bisa membagikan konten", Toast.LENGTH_SHORT).show()
                    }

                    true
                }
                else -> false
            }
        }
    }
}
