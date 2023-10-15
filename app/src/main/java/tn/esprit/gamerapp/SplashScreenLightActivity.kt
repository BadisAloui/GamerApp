package tn.esprit.gamerapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashScreenLightActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen_light_activity)

        val imageView=findViewById<ImageView>(R.id.ic_ssl)
        imageView.alpha = 0f
        imageView.animate().setDuration(2000).alpha(1f).withEndAction{
            val i = Intent(this,MainActivity :: class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
        }
    }
}