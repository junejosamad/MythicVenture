package pk.com.bytecraft.mythicventure

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi

@Suppress("DEPRECATION")
class Characters : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "UseCompatLoadingForDrawables")
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)

        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                )

        val warrior:ImageView = findViewById(R.id.warrior)
        val mage:ImageView = findViewById(R.id.mage)
        val rogue:ImageView = findViewById(R.id.rogue)
        val close:ImageButton = findViewById(R.id.fragmentClose)
        close.setOnClickListener{
            finish()
        }

        warrior.setOnClickListener{
            characters = "Warrior"
            Toast.makeText(this, "$characters Selected", Toast.LENGTH_SHORT).show()
        }

        mage.setOnClickListener{
            characters = "Mage"
            Toast.makeText(this, "$characters Selected", Toast.LENGTH_SHORT).show()
        }

        rogue.setOnClickListener{
            characters = "Rogue"
            Toast.makeText(this, "$characters Selected", Toast.LENGTH_SHORT).show()
        }



    }
}