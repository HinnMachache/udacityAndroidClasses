package com.example.colormyviews

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.colormyviews.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> = listOf(
            binding.boxOneView,
            binding.boxTwoText,
            binding.boxThreeView,
            binding.boxFourView,
            binding.boxFiveView,
            binding.redButton,
            binding.buttonGreen,
            binding.buttonBlue
        )

        for (item in clickableViews) {
            item.setOnClickListener {
                makeColored(it)
            }
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun makeColored(view: View) {
        when (view.id) {
            R.id.box_one_view -> view.setBackgroundColor(android.graphics.Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(android.graphics.Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three_view -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_view -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_view -> view.setBackgroundResource(android.R.color.holo_green_light)

            R.id.red_button -> binding.boxThreeView.setBackgroundResource(R.color.my_red_color)
            R.id.button_green -> binding.boxFourView.setBackgroundResource(R.color.my_green_color)
            R.id.button_blue -> binding.boxFiveView.setBackgroundResource(R.color.colorPrimary)


            else -> view.setBackgroundColor(android.graphics.Color.LTGRAY)
        }

    }


}
