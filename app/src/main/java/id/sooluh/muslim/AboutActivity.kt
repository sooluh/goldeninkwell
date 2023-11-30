package id.sooluh.muslim

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val topAppBar: MaterialToolbar = findViewById(R.id.top_app_bar)
        topAppBar.setNavigationOnClickListener { finish() }
    }

    @Suppress("DEPRECATION")
    fun onBackPressed(view: View) {
        onBackPressed()
    }
}
