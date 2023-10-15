package tn.esprit.gamerapp

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        val imageView=findViewById<ImageView>(R.id.imageView)
        val translateYAnimation = ObjectAnimator.ofFloat(imageView, "translationY", 0f, -100f)
        translateYAnimation.repeatCount = ObjectAnimator.INFINITE
        translateYAnimation.repeatMode = ObjectAnimator.REVERSE
        translateYAnimation.duration = 2000 // Animation duration in milliseconds

        // Start the animation
        translateYAnimation.start()

        val btn_back = findViewById<Button>(R.id.btn_back)
        btn_back.setOnClickListener{
            finish()
        }

    }
}