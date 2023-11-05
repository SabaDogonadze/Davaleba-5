package com.example.davaleba5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.davaleba5.databinding.ActivityMainBinding
import com.example.davaleba5.databinding.LoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: LoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.returnImage.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnLogIn1.setOnClickListener{

            val email = binding.etGmail1.text.toString()
            val password = binding.etPassword1.text.toString()

            if (email.isEmpty()){
               // Toast.makeText(this, "შეიყვანეთ მეილი", Toast.LENGTH_SHORT).show()
                binding.etGmail1.error = "Email ის ველი ცარიელია"
            }
            if (password.isEmpty()){
              //  Toast.makeText(this, "შეიყვანეთ პაროლი", Toast.LENGTH_SHORT).show()
                binding.etPassword1.error = "Password ის ველი ცარიელია"
            }
            if (email.isNotEmpty() && password.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if(it.isSuccessful){
                        val intent = Intent(this, LastActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, "დაფიქსირდა შეცდომა", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }





    }
}