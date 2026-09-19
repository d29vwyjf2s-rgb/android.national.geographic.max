package com.nationalgeographic.max

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
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
        }

        val header = TextView(this).apply {
            text = "NATIONAL GEOGRAPHIC"
            textSize = 21f
            setTextColor(white)
            typeface = Typeface.DEFAULT_BOLD
            letterSpacing = 0.08f
            gravity = Gravity.CENTER
            setPadding(16, 25, 16, 20)
        }

        root.addView(header)

        val scroll = ScrollView(this).apply {
            isFillViewport = true
        }

        val feed = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(16, 0, 16, 30)
        }

        addPost(
            feed,
            "19 СЕНТЯБРЯ 2026",
            "Места, которые хочется увидеть своими глазами",
            "Открываем удивительные места нашей планеты, необычные природные явления и истории, которыми хочется поделиться."
        )

        addPost(
            feed,
            "18 СЕНТЯБРЯ 2026",
            "Там, где природа показывает свою силу",
            "Горы, океаны, леса и другие удивительные уголки Земли."
        )

        addPost(
            feed,
            "17 СЕНТЯБРЯ 2026",
            "Дикая природа крупным планом",
            "Невероятные животные и редкие моменты из жизни нашей планеты."
        )

        scroll.addView(feed)

        root.addView(
            scroll,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )

        setContentView(root)
    }

    private fun addPost(
        feed: LinearLayout,
        date: String,
        titleText: String,
        descriptionText: String
    ) {
        val post = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(card)
            setPadding(16, 16, 16, 16)
        }

        val image = ImageView(this).apply {
            setBackgroundResource(com.nationalgeographic.max.R.drawable.post_placeholder)
            scaleType = ImageView.ScaleType.CENTER_CROP
            contentDescription = "Фото публикации"
        }

        post.addView(
            image,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                210
            )
        )

        val dateView = TextView(this).apply {
            text = date
            textSize = 12f
            setTextColor(yellow)
            typeface = Typeface.DEFAULT_BOLD
            setPadding(0, 16, 0, 8)
        }

        post.addView(dateView)

        val title = TextView(this).apply {
            text = titleText
            textSize = 22f
            setTextColor(white)
            typeface = Typeface.DEFAULT_BOLD
            setPadding(0, 0, 0, 10)
        }

        post.addView(title)

        val description = TextView(this).apply {
            text = descriptionText
            textSize = 15f
            setTextColor(gray)
            setLineSpacing(0f, 1.15f)
        }

        post.addView(description)

        val maxButton = Button(this).apply {
            text = "ОТКРЫТЬ В MAX"
            textSize = 13f
            setTextColor(Color.BLACK)
            setBackgroundColor(yellow)
            typeface = Typeface.DEFAULT_BOLD
        }

        post.addView(
            maxButton,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                50
            ).apply {
                topMargin = 16
            }
        )

        feed.addView(
            post,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                bottomMargin = 18
            }
        )
    }
}
