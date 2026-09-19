package com.nationalgeographic.max

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private val yellow = Color.rgb(255, 204, 0)
    private val white = Color.WHITE
    private val gray = Color.rgb(160, 160, 160)
    private val background = Color.rgb(5, 5, 5)
    private val card = Color.rgb(17, 17, 17)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(background)
            setPadding(24, 20, 24, 24)
        }

        val header = TextView(this).apply {
            text = "NATIONAL GEOGRAPHIC"
            textSize = 22f
            setTextColor(white)
            typeface = Typeface.DEFAULT_BOLD
            letterSpacing = 0.08f
            gravity = Gravity.CENTER
            setPadding(0, 10, 0, 24)
        }

        root.addView(
            header,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )

        val postCard = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(card)
            setPadding(18, 18, 18, 18)
        }

        val image = ImageView(this).apply {
            setBackgroundColor(Color.rgb(35, 35, 35))
            scaleType = ImageView.ScaleType.CENTER_CROP
            contentDescription = "Изображение публикации"
        }

        postCard.addView(
            image,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                210
            )
        )

        val date = TextView(this).apply {
            text = "19 СЕНТЯБРЯ 2026"
            textSize = 12f
            setTextColor(yellow)
            typeface = Typeface.DEFAULT_BOLD
            setPadding(0, 18, 0, 8)
        }

        postCard.addView(date)

        val title = TextView(this).apply {
            text = "Места, которые хочется увидеть своими глазами"
            textSize = 23f
            setTextColor(white)
            typeface = Typeface.DEFAULT_BOLD
            setPadding(0, 0, 0, 12)
        }

        postCard.addView(title)

        val description = TextView(this).apply {
            text = "Открываем удивительные места нашей планеты, необычные природные явления и истории, которыми хочется поделиться."
            textSize = 16f
            setTextColor(gray)
            setLineSpacing(0f, 1.15f)
            setPadding(0, 0, 0, 18)
        }

        postCard.addView(description)

        val maxButton = Button(this).apply {
            text = "ОТКРЫТЬ В MAX"
            textSize = 14f
            setTextColor(Color.BLACK)
            setBackgroundColor(yellow)
            typeface = Typeface.DEFAULT_BOLD
        }

        postCard.addView(
            maxButton,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                52
            )
        )

        root.addView(
            postCard,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )

        val source = TextView(this).apply {
            text = "NATIONAL GEOGRAPHIC • MAX"
            textSize = 11f
            setTextColor(Color.DKGRAY)
            gravity = Gravity.CENTER
            setPadding(0, 20, 0, 0)
        }

        root.addView(source)

        setContentView(root)
    }
}
