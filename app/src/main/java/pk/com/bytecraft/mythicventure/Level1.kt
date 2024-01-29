package pk.com.bytecraft.mythicventure

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentContainerView
import kotlinx.coroutines.delay
import kotlin.concurrent.thread
import kotlin.random.Random

class Level1 : AppCompatActivity() {


    var score:Int = 0


    //val liveScore:TextView = findViewById(R.id.score)
    @SuppressLint("MissingInflatedId","SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level1)

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


        val player:ImageView = findViewById(R.id.player)
        val gameEnemy:ImageView = findViewById(R.id.enemy)
        val liveScore:TextView = findViewById(R.id.score)

        val randomEnemy:Int = Random.nextInt(1,3)


        val playerHealth = 100
        val enemyHealth = 100
        val charName: TextView = findViewById(R.id.charName)
        val enemyName: TextView = findViewById(R.id.enemyName)


        when (characters) {
            "Warrior" -> player.setImageResource(R.drawable.warrior)
            "Mage" -> player.setImageResource(R.drawable.mage)
            "Rogue" -> player.setImageResource(R.drawable.rogue)
        }
        charName.text = "Character: $characters"
        when (randomEnemy) {
            1 -> {
                enemy = "Baby Dragon"
                gameEnemy.setImageResource(R.drawable.bdragon)

            }
            2 -> {
                enemy = "Dragon"
                gameEnemy.setImageResource(R.drawable.dragon)
            }
            3 -> {
                enemy = "Giant Dragon"
                gameEnemy.setImageResource(R.drawable.gdragon)
            }
        }
        enemyName.text = "Enemy: $enemy"

        pAttack(enemyHealth,player,playerHealth,gameEnemy,liveScore)
    }





    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SuspiciousIndentation", "SetTextI18n")
     fun pAttack(enemyHlth:Int, player:ImageView, playerHlth: Int, enemy: ImageView, liveScore:TextView){
        val enemyHealthProgressBar: ProgressBar = findViewById(R.id.enemyHealth)
        player.setOnClickListener{
            var playerAttack:Int = 0
            var eHlth = enemyHlth
            playerAttack = GetAttack().lvl1()
            score+= playerAttack/2
            liveScore.text = "Score: $score"
            eHlth -= playerAttack
            enemyHealthProgressBar.progress = eHlth
            Toast.makeText(this, "Player attacked $playerAttack", Toast.LENGTH_SHORT).show()
            //delay(4000)

            if(eHlth>0)
                eAttack(eHlth,player, playerHlth, enemy,liveScore)
            else {
                Toast.makeText(this, "You win", Toast.LENGTH_SHORT).show()
                val intent:Intent = Intent(this, Levels::class.java)
                intent.putExtra("lvlUnlocked", "lvl2")
                startActivity(intent)
                //Level1a.dragonEnemy()


            }
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun eAttack(eHlth:Int, player: ImageView, playerHlth: Int, enemy:ImageView,liveScore: TextView){

        val playerHealthProgressBar: ProgressBar = findViewById(R.id.playerHealth)
        var hlth = playerHlth
        val eAtk:Int = GetAttack().enemylvl1()
        hlth -= eAtk
        playerHealthProgressBar.progress = hlth
        Toast.makeText(this, "Enemy Attacked $eAtk", Toast.LENGTH_SHORT).show()
        if(hlth>0)
            pAttack(eHlth,player,hlth,enemy,liveScore)
        else
            Toast.makeText(this, "You lost", Toast.LENGTH_SHORT).show()
    }
}

