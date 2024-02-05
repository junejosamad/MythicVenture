package pk.com.bytecraft.mythicventure

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.transition.Visibility

class Levels : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_levels)

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

        val lvl1:TextView = findViewById(R.id.lvl1)
        val lvl2:TextView = findViewById(R.id.lvl2)
        val lvl3:TextView = findViewById(R.id.lvl3)
        val lvl4:TextView = findViewById(R.id.lvl4)
        val close:ImageButton = findViewById(R.id.close)
        //var unlockedLvl:Int = 1

        val lvlUnlocked:String? = intent.extras?.getString("lvlUnlocked")
        if(lvlUnlocked == "lvl2") {
            //unlockedLvl = 2
            lvl2.visibility = View.VISIBLE
        }
//        if(lvlUnlocked == "lvl3") {
//            //unlockedLvl = 3
//            lvl3.visibility = View.VISIBLE
//        }
//        if(lvlUnlocked == "lvl4") {
//            //unlockedLvl = 4
//            lvl4.visibility = View.VISIBLE
//        }


        

        close.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        lvl1.setOnClickListener {
            val intent: Intent = Intent(this, Level1::class.java)
            startActivity(intent)
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


