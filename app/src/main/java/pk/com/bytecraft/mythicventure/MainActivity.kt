package pk.com.bytecraft.mythicventure

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi

var characters: String? = ""
var enemy:String? = ""
//var unlockLevels:Int = 0
var playerName:String? = "Samad"

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.R)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                )

        /*if(playerName != ""){
           // val playerNameView:TextView = findViewById(R.id.playerName)
          //  playerNameView.setText(playerName)
        }*/
        val startGame:Button = findViewById(R.id.startGame)
        val character:Button = findViewById(R.id.characters)
       // val inventory:Button = findViewById(R.id.inventory)
        //val setting:Button = findViewById(R.id.setting)
        val exitGame:Button = findViewById(R.id.exit)

        exitGame.setOnClickListener{
            Toast.makeText(this, "Game Exited...", Toast.LENGTH_SHORT).show()
            finishAffinity()
        }

        character.setOnClickListener{

            startActivity(Intent(this, Characters::class.java))

        }

        startGame.setOnClickListener{
            if(characters == ""){
                startActivity(Intent(this, Characters::class.java))
            } else {
                startActivity(Intent(this, Levels::class.java))
            }
        }
    }
}