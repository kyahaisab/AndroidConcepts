package com.example.myfirstapplication.otherTerminology

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapplication.R

// example of how you can use onSaveInstanceState(), onRestoreInstanceState(), and onBackPressed() in an Android activity
/*
-onCreate() is used for initial setup and may handle saved instance state restoration,
while onRestoreInstanceState() is specifically for restoring saved instance state after recreation.
 */
class MainActivity : AppCompatActivity() {

    private var counter = 0

    /*
    The onCreate() method is called when the activity is first created or recreated after a configuration change.
    It's typically used for initializing the activity's UI, setting up event listeners,
    and restoring the activity's state from saved instance state if necessary.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Check if there's saved state and restore the counter
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(KEY_COUNTER, 0)
            updateCounterText()
        }

        // Increase the counter when the button is clicked
        val buttonIncrease:View?=null // random fix, its button
        buttonIncrease?.setOnClickListener {
            counter++
            updateCounterText()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        // Save the current counter value before the activity is temporarily destroyed
        outState.putInt(KEY_COUNTER, counter)
        super.onSaveInstanceState(outState)
    }

    /*
    This callback is called only when there is a saved instance previously saved using onSaveInstanceState().
    Some state is restored in onCreate(). Other state can optionally be restored here, possibly usable after
    onStart() has completed. The savedInstanceState Bundle is same as the one used in onCreate().

    The onRestoreInstanceState() method is called after onStart() during the recreation process of the activity.
    It's specifically designed to restore the activity's state from the saved instance state bundle after
    the activity has been recreated due to a configuration change. Unlike onCreate(), onRestoreInstanceState() is not used
    for initializing the activity's UI or setting up event listeners; it's solely for restoring the saved state.
    This method is used to restore non-UI state, such as variables or data, from the saved instance state bundle.
     */
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Restore the counter value after the activity is recreated
        counter = savedInstanceState.getInt(KEY_COUNTER, 0)
        updateCounterText()
    }

    override fun onBackPressed() {
        if (counter > 0) {
            // If the counter is greater than 0, decrement it and update the UI
            counter--
            updateCounterText()
        } else {
            // If the counter is already 0, proceed with the default back button behavior
            super.onBackPressed()
        }
    }

    private fun updateCounterText() {
        //textViewCounter.text = "Counter: $counter"
    }

    companion object {
        private const val KEY_COUNTER = "counter"
    }
}
// Note there is not any fix place where onRestoreInstanceState, onSavedInstanceState are called
