package com.example.myfirstapplication.learnFragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapplication.R
import com.example.myfirstapplication.databinding.ActivityLerarnFragmentsBinding
import com.example.myfirstapplication.utils.click

class LearnFragmentsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLerarnFragmentsBinding

    /*
    Link: https://rohitksingh.medium.com/difference-between-add-and-replace-in-fragmenttransaction-in-android-87289b00824f
    add: simply add one fragment over top of other
    replace: replace all fragment and place the new one
    addToBackstack: Its a stack, it give activity like action of going back to previous fragment.
                    If not used activity hosting fragment will go back
    Also covered Animations in fragments while adding,replace
    Also implemented single task launch mode
     */
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLerarnFragmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fragmentOne.click {
            val existingFragment = supportFragmentManager.findFragmentByTag("FIRST_FRAGMENT_TAG")
            // Managing single task launch mode
            if (existingFragment != null) {
                supportFragmentManager.popBackStack("FIRST_FRAGMENT_TAG", 0)
            } else {
                val fragment = FirstFragment()
                supportFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in_bottom,
                        R.anim.slide_out_top,
                        R.anim.slide_in_top,
                        R.anim.slide_out_bottom
                    )
                    .add(R.id.fragment_container, fragment, "FIRST_FRAGMENT_TAG")
                    .addToBackStack("FIRST_FRAGMENT_TAG")
                    .commit()
            }
        }
        // Example of replacing a fragment on button click
        binding.fragmentTwo.setOnClickListener {
            val newFragment = SecondFragment()
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.anim.slide_in_bottom,
                    R.anim.slide_out_top,
                    R.anim.slide_in_top,
                    R.anim.slide_out_bottom
                )
                .add(R.id.fragment_container, newFragment, "SECOND_FRAGMENT_TAG")
                .addToBackStack("SECOND_FRAGMENT_BACKSTACK")
                .commit()
        }

        binding.fragmentThree.setOnClickListener {
            val newFragment = ThirdFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, newFragment, "THIRD_FRAGMENT_TAG")
                .addToBackStack("THIRD_FRAGMENT_BACKSTACK")
                .commit()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}