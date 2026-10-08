package com.example.trainingproject

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.net.toUri

object Utils {
    private val PHONE_REGEX = Regex("""^(?:\+7|8)?9\d{9}$""")

    fun openSecondActivity(context: Context, text: String) {
        val intent = Intent(context, SecondActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        intent.putExtra("text", text)

        try {
            context.startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(context, "Нет второго экрана", Toast.LENGTH_SHORT).show()
        }
    }

    fun callFriend(context: Context, tel: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = "tel:$tel".toUri()
        }

        try {
            context.startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(context, "Нет приложения для звонков", Toast.LENGTH_SHORT).show()
        }
    }

    fun shareText(context: Context, text: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, text)

        try{
            context.startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(context, "Нет приложения, чтобы делится", Toast.LENGTH_SHORT).show()
        }
    }

    fun isValidPhone(text: String): Boolean {
        return PHONE_REGEX.matches(text)
    }
}