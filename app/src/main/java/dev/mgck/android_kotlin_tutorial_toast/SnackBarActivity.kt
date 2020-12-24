package dev.mgck.android_kotlin_tutorial_toast

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class SnackBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snack_bar)

        // Mostrar seta de retorno para tela anterior
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // Define action by button onclick listeners
        findViewById<View>(R.id.btnShowSnackbar).setOnClickListener { showSnackBar() }
        findViewById<View>(R.id.btnShowActionSnackbar).setOnClickListener { showActionSnackBar() }
    }

    private fun showSnackBar() {
        Snackbar.make(findViewById(R.id.myCoordinatorLayout), "THIS IS A TEST",
            Snackbar.LENGTH_LONG).show()
    }

    private fun showActionSnackBar() {
        val actionSnackbar = Snackbar.make(findViewById(R.id.myCoordinatorLayout)
            , "THIS IS A TEST", Snackbar.LENGTH_LONG)
        actionSnackbar.setAction("teste") {
            Toast.makeText(this, "Action SnackBar Clicked!",
                Toast.LENGTH_LONG).show() }
        actionSnackbar.setActionTextColor(Color.RED)
        actionSnackbar.show()
    }
}