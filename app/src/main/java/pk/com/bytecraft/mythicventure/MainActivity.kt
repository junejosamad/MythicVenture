package pk.com.bytecraft.mythicventure

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi

var characters: String? = ""
var enemy:String? = ""
var unlockLevels:Int = 0
var playerName:String? = ""

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.R)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        if(playerName == ""){
            
        }
        val startGame:Button = findViewById(R.id.startGame)
        val character:Button = findViewById(R.id.characters)
        val inventory:Button = findViewById(R.id.inventory)
        val setting:Button = findViewById(R.id.setting)
        val exitGame:Button = findViewById(R.id.exit)

        exitGame.setOnClickListener(){
            Toast.makeText(this, "Game Exited...", Toast.LENGTH_SHORT).show()
            finish()
        }

        character.setOnClickListener(){

            startActivity(Intent(this, Characters::class.java))

        }

        startGame.setOnClickListener(){
            if(characters == ""){
                startActivity(Intent(this, Characters::class.java))
            } else {
                startActivity(Intent(this, Levels::class.java))
            }
        }
    }
}