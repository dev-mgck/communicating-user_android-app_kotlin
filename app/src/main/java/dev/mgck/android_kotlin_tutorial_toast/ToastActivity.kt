package dev.mgck.android_kotlin_tutorial_toast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.*
import kotlin.properties.Delegates

class ToastActivity : AppCompatActivity() {

    // Lateint variables
    private lateinit var toast : Toast
    private lateinit var btn_showDefaultToast: Button
    private lateinit var btn_showCustomToast: Button
    private lateinit var rbShortToast: RadioButton
    private var toastDuration by Delegates.notNull<Int>()
    private lateinit var toastLength: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)

        // Mostrar seta de retorno para tela anterior
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Atribuir variáveis aos elementos Views do arquivo .xml
        rbShortToast = findViewById(R.id.rb_shortToast)
        btn_showDefaultToast = findViewById(R.id.btn_showDefaultToast)
        btn_showCustomToast = findViewById(R.id.btn_showCustomToast)

        // Onclick Listeners
        btn_showDefaultToast.setOnClickListener{ showDefaultToast() }
        btn_showCustomToast.setOnClickListener{ showCustomToast() }
    }

    private fun showDefaultToast() {
        checkToast()
        val msg = "Default Toast do tipo: "
        // Criar e exibir Toast Message
        toast = Toast.makeText(this,"$msg$toastLength", toastDuration)
        toast.show()
    }

    private fun showCustomToast() {
        checkToast()
        val msg = "Custom Toast do tipo: "
        val inflater = layoutInflater
        val container: ViewGroup? = findViewById(R.id.custom_toast_container)
        val layout: ViewGroup = inflater.inflate(R.layout.custom_toast, container) as ViewGroup
        val text: TextView = layout.findViewById(R.id.text)
        text.text = "$msg$toastLength"
        with (Toast(applicationContext)) {
            setGravity(Gravity.CENTER_VERTICAL, 0, 0)
            duration = toastDuration
            view = layout
            show()
        }
    }

    private fun checkToast() {
        toastDuration = if (rbShortToast.isChecked) {
            Toast.LENGTH_SHORT
        } else {
            Toast.LENGTH_LONG
        }
        toastLength = if (rbShortToast.isChecked) { "LENGTH SHORT" } else { "LENGTH LONG" }
    }
}