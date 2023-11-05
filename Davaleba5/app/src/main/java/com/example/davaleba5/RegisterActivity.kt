package com.example.davaleba5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.davaleba5.databinding.RegisterBinding
import com.google.firebase.auth.FirebaseAuth


class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: RegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnNext.setOnClickListener{

            val email = binding.etGmail.text.toString().replace(" ","")
            val password = binding.etPassword.text.toString().replace(" ","")

            if (email.isEmpty()){
                Toast.makeText(this, "შეიყვანეთ მეილი", Toast.LENGTH_SHORT).show()
                binding.etGmail.error = "Email ის ველი ცარიელია"
            }
            if (password.isEmpty()){
                Toast.makeText(this, "შეიყვანეთ პაროლი", Toast.LENGTH_SHORT).show()
                binding.etPassword.error = "Password ის ველი ცარიელია"
            }
            if (email.isNotEmpty() && password.isNotEmpty()){
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    if(it.isSuccessful){
                        val intent = Intent(this, RegisterActivity2::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, "დაფიქსირდა შეცდომა", Toast.LENGTH_SHORT).show()
                    }
                }
            }




        }

        binding.returnImage.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }


    }
}

