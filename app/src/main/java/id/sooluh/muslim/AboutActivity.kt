package id.sooluh.muslim

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val topAppBar: MaterialToolbar = findViewById(R.id.top_app_bar)
        val imgAvatar = findViewById<ImageView>(R.id.img_author_avatar)
        val tvName = findViewById<TextView>(R.id.tv_author_name)
        val tvEmail = findViewById<TextView>(R.id.tv_author_email)
        val tvBio = findViewById<TextView>(R.id.tv_author_bio)

        topAppBar.setNavigationOnClickListener { finish() }
        imgAvatar.setImageResource(R.drawable.author_avatar)
        tvName.text = getString(R.string.author_name)
        tvEmail.text = getString(R.string.author_email)
        tvBio.text = getString(R.string.author_bio)
    }
}
