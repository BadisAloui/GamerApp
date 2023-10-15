package tn.esprit.gamerapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class SignUp : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)
        nameEditText = findViewById(R.id.et_name)
        emailEditText = findViewById(R.id.et_email)
        passwordEditText = findViewById(R.id.et_password)
        confirmPasswordEditText = findViewById(R.id.et_confirmPassword)
    }

    // Click action for the "Privacy Policy" TextView
    fun onPrivacyPolicyClick(view: View) {
        Snackbar.make(view, "Privacy Policy - Coming soon", Snackbar.LENGTH_SHORT).show()
    }

    // Click action for the "Submit" Button
    fun onSubmtiClick(view: View) {
        val name = nameEditText.text.toString()
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
        val confirmPassword = confirmPasswordEditText.text.toString()

        // Check if all fields are valid (implement your validation logic)
        if (isValidData(name, email, password, confirmPassword)) {
            // Data is valid, navigate to LoginActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } else {
            // Show a Snackbar with an error message
            Snackbar.make(view, "Invalid data. Please check your input.", Snackbar.LENGTH_SHORT).show()
        }
    }

    // Implement your data validation logic here
    private fun isValidData(
        name: String,
        email: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        // Check if email is in the correct format
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        val isEmailValid = email.matches(emailPattern.toRegex())

        // Check if password length is greater than or equal to 6 characters
        val isPasswordValid = password.length >= 6

        // Check if confirmPassword matches the password
        val isConfirmPasswordValid = confirmPassword == password

        // Check if name contains only letters
        val isNameValid = name.matches(Regex("^[a-zA-Z]+\$"))

        // Return true if all conditions are met
        return isEmailValid && isPasswordValid && isConfirmPasswordValid && isNameValid
    }
}