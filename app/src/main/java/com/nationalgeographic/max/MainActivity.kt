package com.nationalgeographic.max

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.ComponentActivity
import org.json.JSONObject

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

        val scroll = ScrollView(this)

        val feed = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(16, 0, 16, 30)
        }

        loadPosts(feed)

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

    private fun loadPosts(feed: LinearLayout) {
        try {
            val jsonText = assets
                .open("posts.json")
                .bufferedReader()
                .use { it.readText() }

            val root = JSONObject(jsonText)
            val posts = root.getJSONArray("posts")

            for (i in 0 until posts.length()) {
                val post = posts.getJSONObject(i)

                addPost(
                    feed = feed,
                    date = post.optString("date"),
                    title = post.optString("title"),
                    text = post.optString("text")
                )
            }

        } catch (e: Exception) {
            addError(feed, "Не удалось загрузить публикации")
        }
    }

    private fun addPost(
        feed: LinearLayout,
        date: String,
        title: String,
        text: String
    ) {
        val post = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(card)
            setPadding(16, 16, 16, 16)
        }

        val image = ImageView(this).apply {
            setImageResource(R.drawable.post_placeholder)
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
            this.text = date
            textSize = 12f
            setTextColor(yellow)
            typeface = Typeface.DEFAULT_BOLD
            setPadding(0, 16, 0, 8)
        }

        post.addView(dateView)

        val titleView = TextView(this).apply {
            this.text = title
            textSize = 22f
            setTextColor(white)
            typeface = Typeface.DEFAULT_BOLD
            setPadding(0, 0, 0, 10)
        }

        post.addView(titleView)

        val textView = TextView(this).apply {
            this.text = text
            textSize = 15f
            setTextColor(gray)
            setLineSpacing(0f, 1.15f)
        }

        post.addView(textView)

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

    private fun addError(
        feed: LinearLayout,
        message: String
    ) {
        val error = TextView(this).apply {
            text = message
            textSize = 16f
            setTextColor(Color.RED)
            gravity = Gravity.CENTER
            setPadding(20, 50, 20, 50)
        }

        feed.addView(error)
    }
}
