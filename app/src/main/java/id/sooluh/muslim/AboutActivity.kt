package id.sooluh.muslim

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val website = "https://suluh.my.id"
        val git = "sooluh"
        val username = "suluh_s"

        val topAppBar: MaterialToolbar = findViewById(R.id.top_app_bar)
        val imgAvatar = findViewById<ImageView>(R.id.img_author_avatar)
        val tvName = findViewById<TextView>(R.id.tv_author_name)
        val tvEmail = findViewById<TextView>(R.id.tv_author_email)
        val tvBio = findViewById<TextView>(R.id.tv_author_bio)
        val btnWebsite = findViewById<Button>(R.id.www_btn)
        val btnGithub = findViewById<Button>(R.id.github_btn)
        val btnGitlab = findViewById<Button>(R.id.gitlab_btn)
        val btnInstagram = findViewById<Button>(R.id.instagram_btn)
        val btnTwitter = findViewById<Button>(R.id.x_btn)

        topAppBar.setNavigationOnClickListener { finish() }
        imgAvatar.setImageResource(R.drawable.author_avatar)
        tvName.text = getString(R.string.author_name)
        tvEmail.text = getString(R.string.author_email)
        tvBio.text = getString(R.string.author_bio)

        btnWebsite.setOnClickListener {
            val uri = Uri.parse(website)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        btnGithub.setOnClickListener {
            val uri = Uri.parse("https://github.com/$git")
            val intent = Intent(Intent.ACTION_VIEW, uri)

            intent.setPackage("com.github.android")

            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                val browserIntent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(browserIntent)
            }
        }

        btnGitlab.setOnClickListener {
            val uri = Uri.parse("https://gitlab.com/$git")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        btnInstagram.setOnClickListener {
            val uri = Uri.parse("http://instagram.com/_u/$username")
            val intent = Intent(Intent.ACTION_VIEW, uri)

            intent.setPackage("com.instagram.android")

            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                val browserIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("http://instagram.com/$username")
                )

                startActivity(browserIntent)
            }
        }

        btnTwitter.setOnClickListener {
            val uri = Uri.parse("http://twitter.com/$username")
            val intent = Intent(Intent.ACTION_VIEW, uri)

            intent.setPackage("com.twitter.android")

            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                val browserIntent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(browserIntent)
            }
        }
    }
}
