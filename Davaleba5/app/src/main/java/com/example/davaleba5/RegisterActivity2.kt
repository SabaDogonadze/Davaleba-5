package com.example.davaleba5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.davaleba5.databinding.Register2Binding

class RegisterActivity2 : AppCompatActivity() {
    private lateinit var binding: Register2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Register2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.returnImage.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

            binding.btnSingup.setOnClickListener {
                 val name = binding.etUsername.text.toString().replace(" ","")
                if (name.isEmpty()) {
                    Toast.makeText(this, "შეიყვანეთ სახელი", Toast.LENGTH_SHORT).show()
                    binding.etUsername.error = "Username ის ველი ცარიელია"
                }
                if (name.isNotEmpty()) {
                    val intent = Intent(this, LastActivity::class.java)
                    startActivity(intent)
                }

                }
            }
        }


