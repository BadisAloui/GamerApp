package tn.esprit.gamerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.textfield.TextInputEditText
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the EditText fields
        emailEditText = findViewById(R.id.textInputEmail)
        passwordEditText = findViewById(R.id.textInputPassword)

        // Add TextWatchers to the EditText fields
        addTextWatchers()
        val forgotPasswordbtn = findViewById<TextView>(R.id.tv_forgotpassword)
        forgotPasswordbtn.setOnClickListener{
            val intent = Intent(this,ForgotPassword::class.java)
            startActivity(intent)
        }

        val facebookButton = findViewById<ImageView>(R.id.iv_facebook)
        val googleButton = findViewById<ImageView>(R.id.iv_google)

        facebookButton.setOnClickListener {
            Snackbar.make(it, "Coming soon - Facebook login", Snackbar.LENGTH_SHORT).show()
        }

        googleButton.setOnClickListener {
            Snackbar.make(it, "Coming soon - Google login", Snackbar.LENGTH_SHORT).show()
        }

        val registerNowButton = findViewById<TextView>(R.id.tv_registernow)
        registerNowButton.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
        val loginButton = findViewById<Button>(R.id.btn_login)
        loginButton.setOnClickListener {
            // Récupérez les valeurs entrées dans les champs email et mot de passe
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Vous pouvez implémenter ici la vérification des données, par exemple
            // en appelant une fonction de validation que vous avez définie.

            if (isValidPassword(password) && isValidEmail(email)) {
                // Si les données sont valides, naviguez vers HomeActivity
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                // Si les données ne sont pas valides, affichez un Snackbar avec un message.
                Snackbar.make(it, "Invalid email or password", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    // Function to add TextWatchers to the EditText fields
    private fun addTextWatchers() {
        emailEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                // Call a validation function for email here
                validateEmail(s.toString())
            }
        })

        passwordEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                // Call a validation function for password here
                validatePassword(s.toString())
            }
        })
    }

    // Validation function for email
    private fun validateEmail(email: String) {
        // You can implement your email validation logic here
        // For example, you can use regular expressions to check if the email is valid
        // If it's not valid, you can set an error message on the emailEditText field
        // Otherwise, clear any error message.
        if (!isValidEmail(email)) {
            emailEditText.error = "Invalid email address"
        } else {
            emailEditText.error = null
        }
    }

    // Validation function for password
    private fun validatePassword(password: String) {
        // You can implement your password validation logic here
        // For example, check if the password meets certain criteria (e.g., minimum length)
        // If it doesn't meet the criteria, set an error message on the passwordEditText field
        // Otherwise, clear any error message.
        if (!isValidPassword(password)) {
            passwordEditText.error = "Invalid password"
        } else {
            passwordEditText.error = null
        }
    }

    // Example email validation using regex
    private fun isValidEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z0-9._-]+"
        return email.matches(emailPattern.toRegex())
    }

    // Example password validation (minimum length of 6 characters)
    private fun isValidPassword(password: String): Boolean {
        return password.length >= 6
    }

    private fun isValidData(email: String, password: String): Boolean {
        // Vous pouvez implémenter ici la logique de validation des données.
        // Par exemple, vérifier que l'email est au bon format et que le mot de passe
        // respecte certaines règles.

        // Pour l'exemple, on suppose que les données sont valides si les champs ne sont pas vides.
        return email.isNotEmpty() && password.isNotEmpty()
    }
}