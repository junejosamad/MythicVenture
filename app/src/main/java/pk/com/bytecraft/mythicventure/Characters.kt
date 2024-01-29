package pk.com.bytecraft.mythicventure

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
class Characters : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "UseCompatLoadingForDrawables")
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)

        // For devices running on Android 11 (API level 30) and above
        val windowInsetsController = window.insetsController

        windowInsetsController?.let {
            it.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
            it.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }

        // For devices running on versions lower than Android 11
        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                    View.SYSTEM_UI_FLAG_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            )

        val warrior:ImageView = findViewById(R.id.warrior)
        val mage:ImageView = findViewById(R.id.mage)
        val rogue:ImageView = findViewById(R.id.rogue)
        val close:ImageButton = findViewById(R.id.close)
        close.setOnClickListener{
            finish()
        }

        warrior.setOnClickListener(){
            characters = "Warrior"
            Toast.makeText(this, "$characters Selected", Toast.LENGTH_SHORT).show()
        }

        mage.setOnClickListener(){
            characters = "Mage"
            Toast.makeText(this, "$characters Selected", Toast.LENGTH_SHORT).show()
        }

        rogue.setOnClickListener(){
            characters = "Rogue"
            Toast.makeText(this, "$characters Selected", Toast.LENGTH_SHORT).show()
        }



    }
}