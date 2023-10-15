package tn.esprit.gamerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar


class ForgotPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forgotpassword)
        val btn_submit = findViewById<Button>(R.id.btn_submit)
        val et_email = findViewById<EditText>(R.id.et_email)
        btn_submit.setOnClickListener {
            val email = et_email.text.toString()
            if (isValidEmail(email)) {
                // Data is valid, navigate to OTPValidationActivity with code 1234
                val intent = Intent(this, OTPValidationActivity::class.java)
                intent.putExtra("code", "1234")
                startActivity(intent)
            } else {
                // Show a Snackbar with an error message
                Snackbar.make(it, "Invalid email address", Snackbar.LENGTH_SHORT).show()
            }
        }

        val btn_sendsms = findViewById<Button>(R.id.btn_sendsms)
        btn_sendsms.setOnClickListener {
            val email = et_email.text.toString()
            if (isValidEmail(email)) {
                // Data is valid, navigate to OTPValidationActivity with code 6789
                val intent = Intent(this, OTPValidationActivity::class.java)
                intent.putExtra("code", "6789")
                startActivity(intent)
            } else {
                // Show a Snackbar with an error message
                Snackbar.make(it, "Invalid email address", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z0-9._-]+"
        return email.matches(emailPattern.toRegex())
    }
}