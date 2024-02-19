package pk.com.bytecraft.mythicventure

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView

@Suppress("DEPRECATION")
class WinMessage(private val lvl:Short, private val status:Char, private val score:Int) : Fragment() {

    @SuppressLint("SetTextI18n", "MissingInflatedId", "UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.win__message, container, false)
        val close:ImageButton = view.findViewById(R.id.fragmentClose)

        close.setOnClickListener {
            val intent = Intent(requireContext(), Levels::class.java)
            if(status == '1')
                intent.putExtra("lvlUnlocked", "lvl2")
            startActivity(intent)
        }

        val scoreView = view.findViewById<TextView>(R.id.fragmentscoreview)
        val levelView:TextView = view.findViewById(R.id.lvl)
        levelView.text = "Level $lvl"
        scoreView.text = "Your Score: $score"
        val winStatus: TextView = view.findViewById(R.id.fragmentGameStatus2)
        winStatus.text = "You ${if (status == '1') "won" else "loss"} the Game"

        setRoundedCorners(view)
        // Inflate the layout for this fragment
        return view
    }

    private fun setRoundedCorners(view: View) {
        val radius = resources.getDimension(R.dimen.corner_radius) // Adjust the radius as needed
        val shape = GradientDrawable()
        shape.cornerRadius = radius
        shape.setColor(resources.getColor(androidx.cardview.R.color.cardview_shadow_start_color)) // Set the background color

        view.background = shape
    }




}