package pk.com.bytecraft.mythicventure

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi

@Suppress("DEPRECATION")
class Levels : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_levels)

        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                )

        val lvl1:TextView = findViewById(R.id.lvl1)
        val lvl2:TextView = findViewById(R.id.lvl2)
        val lvl3:TextView = findViewById(R.id.lvl3)
        val lvl4:TextView = findViewById(R.id.lvl4)
        val close:ImageButton = findViewById(R.id.fragmentClose)
        //var unlockedLvl:Int = 1

        val lvlUnlocked:String? = intent.extras?.getString("lvlUnlocked")
        if(lvlUnlocked == "lvl2") {
            //unlockedLvl = 2
            lvl2.visibility = View.VISIBLE
        }
        if(lvlUnlocked == "lvl3") {
            //unlockedLvl = 3
            lvl3.visibility = View.VISIBLE
        }
        if(lvlUnlocked == "lvl4") {
            //unlockedLvl = 4
            lvl4.visibility = View.VISIBLE
        }


        

        close.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        lvl1.setOnClickListener {
            startActivity(Intent(this, Level1::class.java))
            //overrideActivityTransition(androidx.appcompat.R.anim.abc_fade_in, androidx.appcompat.R.anim.abc_fade_out)
        }

        lvl2.setOnClickListener {
            //startActivity(Intent(this, Level2::class.java))
            Toast.makeText(this,"Development is in pending", Toast.LENGTH_LONG).show()
        }
        lvl3.setOnClickListener {
            //startActivity(Intent(this, Level3::class.java))
        }
        lvl4.setOnClickListener {
            //startActivity(Intent(this, Level4::class.java))
        }

    }
}


