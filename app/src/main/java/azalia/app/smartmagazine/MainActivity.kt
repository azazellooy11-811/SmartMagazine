package azalia.app.smartmagazine

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()

        StrictMode.setThreadPolicy(policy)
        val button = findViewById<Button>(R.id.button2)
        button.setOnClickListener {
            val intent = Intent(this, LinkEnterActivity::class.java)
            startActivity(intent)
        }
    }
}

