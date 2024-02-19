package pk.com.bytecraft.mythicventure

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import pk.com.bytecraft.mythicventure.databinding.ActivityMainBinding
import kotlin.random.Random

@Suppress("DEPRECATION")
class Level1 : AppCompatActivity() {


    private var score:Int = 0
    private lateinit var player:ImageView
    private lateinit var gameEnemy:ImageView
    private lateinit var liveScore: TextView
    private lateinit var fireBall:ImageView
    private lateinit var fireBall2:ImageView
    private lateinit var attackBtn:ImageButton
    private lateinit var moveRight:ImageButton
    private lateinit var moveUp:ImageButton
    private lateinit var moveLeft: ImageButton
    private var playerHealth = 100
    private var enemyHealth = 100
    private lateinit var playerHealthProgressBar:ProgressBar
    private lateinit var enemyHealthProgressBar: ProgressBar
    private lateinit var relativeLayout: RelativeLayout
    private val handler = Handler()
    private var playerAttack = 0

    private lateinit var fragmentManager:FragmentManager
    private lateinit var binding: ActivityMainBinding


    //val liveScore:TextView = findViewById(R.id.score)
    @SuppressLint("MissingInflatedId","SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_level1)

        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                )

        player = findViewById(R.id.player)
        gameEnemy = findViewById(R.id.enemy)
        liveScore = findViewById(R.id.score)
        relativeLayout = findViewById(R.id.relativeLayout)

        val randomEnemy:Int = Random.nextInt(1,4)
        fireBall = findViewById(R.id.fireball)
        fireBall2 = findViewById(R.id.fireball2)
        attackBtn = findViewById(R.id.attackbtn)
        moveRight = findViewById(R.id.moveright)
        moveLeft = findViewById(R.id.moveleft)
        moveUp = findViewById(R.id.moveup)


        playerHealthProgressBar = findViewById(R.id.playerHealth)
        enemyHealthProgressBar = findViewById(R.id.enemyHealth)


        val charName: TextView = findViewById(R.id.charName)
        val enemyName: TextView = findViewById(R.id.enemyName)
        val playerNameView:TextView = findViewById(R.id.playerName)
        playerNameView.text = playerName

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

        pAttack()
    }





    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SuspiciousIndentation", "SetTextI18n", "ClickableViewAccessibility")
     fun pAttack(){
        attackBtn.setOnClickListener{
            fireBall.visibility = View.VISIBLE
            fireBall.startAnimation(AnimationUtils.loadAnimation(this, R.anim.simple_basic))
            fireBall.visibility = View.INVISIBLE
            playerAttack = GetAttack().lvl1()
            score+= playerAttack/2
            liveScore.text = "Score: $score"
            enemyHealth -= playerAttack
            enemyHealthProgressBar.progress = enemyHealth
            //Toast.makeText(this, "Player attacked $playerAttack", Toast.LENGTH_SHORT).show()
            //delay1(timeMillis = 4000)

            if(enemyHealth>0)
                //if((fireBall.clearAnimation().toString()) != "")
                eAttack()
            else {
                /*Toast.makeText(this, "You win", Toast.LENGTH_SHORT).show()
                val intent:Intent = Intent(this, Levels::class.java)
                intent.putExtra("lvlUnlocked", "lvl2")
                startActivity(intent)*/
                //Level1a.dragonEnemy()
                attackBtn.visibility = View.INVISIBLE
                moveUp.visibility = View.INVISIBLE
                moveRight.visibility = View.INVISIBLE
                moveLeft.visibility = View.INVISIBLE
                winStatus(WinMessage(1, '1', score))
            }
        }

        moveRight.setOnTouchListener { _, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    // Button is pressed, start the continuous action
                    startContinuousRight()
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    // Button is released or canceled, stop the continuous action
                    stopContinuousRight()
                }
            }
            // Return false to allow click events as well
            false
        }

        moveLeft.setOnTouchListener { _, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    // Button is pressed, start the continuous action
                    startContinuousLeft()
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    // Button is released or canceled, stop the continuous action
                    stopContinuousLeft()
                }
            }
            // Return false to allow click events as well
            false
        }
        moveUp.setOnClickListener {
            player.startAnimation(AnimationUtils.loadAnimation(this,R.anim.up))

        }
    }

    //@SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    fun eAttack(){


            val eAtk:Int = GetAttack().enemylvl1()
            playerHealth -= eAtk
            playerHealthProgressBar.progress = playerHealth

            fireBall2.visibility = View.VISIBLE
            fireBall2.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_in_right))
            fireBall2.visibility = View.INVISIBLE

            if(playerHealth>0)
                pAttack()
            else {
                Toast.makeText(this, "You lost", Toast.LENGTH_SHORT).show()

                /*val lostMessage = TextView(this)
                val params = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT)
                params.addRule(RelativeLayout.CENTER_IN_PARENT)
                lostMessage.text = "You lost"
                lostMessage.textSize = 50f
                lostMessage.typeface = Typeface.MONOSPACE
                lostMessage.setTextColor(Color.parseColor("#ffffff"))
                lostMessage.layoutParams = params
                relativeLayout.addView(lostMessage)*/
                moveLeft.visibility = View.INVISIBLE
                moveRight.visibility = View.INVISIBLE
                moveUp.visibility = View.INVISIBLE
                attackBtn.visibility = View.GONE
                winStatus(WinMessage(1,'0', score))

            }

    }

    private fun startContinuousRight() {
        // Your continuous action goes here

        handler.postDelayed(continuousRunnableRight, 70)
    }

    private fun stopContinuousRight() {
        // Stop the continuous action
        handler.removeCallbacks(continuousRunnableRight)
    }

    private val continuousRunnableRight = object : Runnable {
        override fun run() {
            // Your continuous action goes here
            // This will be executed repeatedly until the button is released
            val playerPosition = player.layoutParams as RelativeLayout.LayoutParams
            if(playerPosition.leftMargin <=1500)
            playerPosition.leftMargin += 10
            player.layoutParams = playerPosition

            handler.postDelayed(this, 70) // Adjust the delay as needed
        }
    }


    private fun startContinuousLeft() {
        // Your continuous action goes here

        val playerPosition = player.layoutParams as RelativeLayout.LayoutParams
        if(playerPosition.leftMargin > 0)
            playerPosition.leftMargin -= 10
        player.layoutParams = playerPosition

        handler.postDelayed(continuousRunnableLeft, 70)
    }

    private fun stopContinuousLeft() {
        // Stop the continuous action
        handler.removeCallbacks(continuousRunnableLeft)
    }

    private val continuousRunnableLeft = object : Runnable {
        override fun run() {
            // Your continuous action goes here
            // This will be executed repeatedly until the button is released
            val playerPosition = player.layoutParams as RelativeLayout.LayoutParams
            if (playerPosition.leftMargin > 0)
                playerPosition.leftMargin -= 10
            player.layoutParams = playerPosition

            handler.postDelayed(this, 70) // Adjust the delay as needed
        }
    }

    private fun winStatus(frag:Fragment){

        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.status, frag).commit()
    }

}

