package dev.mgck.android_kotlin_tutorial_toast

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import dev.mgck.android_kotlin_tutorial_toast.dialogs.CustomDialogFragment
import dev.mgck.android_kotlin_tutorial_toast.dialogs.MultipleChoiceDialogFragment
import dev.mgck.android_kotlin_tutorial_toast.dialogs.SimpleDialogFragment
import dev.mgck.android_kotlin_tutorial_toast.dialogs.SingleChoiceDialogFragment
import java.util.*

class DialogActivity : AppCompatActivity(), SimpleDialogFragment.SimpleDialogListener {

    private val TAG = "AUC_DLG_ACTIVITY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        // Mostrar seta de retorno para tela anterior
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun showSimpleDialog(view: View) {
        val simpleDialog = SimpleDialogFragment()
        simpleDialog.show(supportFragmentManager, "simple dialog")
    }

    fun showSingleChoiceDialog(view: View) {
        val simpleChoiceDialog = SingleChoiceDialogFragment()
        simpleChoiceDialog.show(supportFragmentManager, "simple choice dialog")
    }

    fun showCustomDialog(view: View) {
        val customDialog = CustomDialogFragment()
        customDialog.show(supportFragmentManager, "custom dialog")
    }

    fun displayDataPicker(view: View) {
        // Get a calendar instance
        val cal = Calendar.getInstance()

        // Create a DatePickerDialog
        val datePicker = DatePickerDialog(this,
            { view, year, monthOfYear, dayOfMonth ->
                Toast.makeText(this,
                    String.format("Date Chosen -- day: %d, month: %d, year: %d",
                    dayOfMonth, monthOfYear, year),
                    Toast.LENGTH_SHORT).show() },
            cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))

        // Set the title and show the dialog
        datePicker.setTitle("Choose a Date")
        datePicker.show()
    }

    fun showMultipleChoiceDialog(view: View) {
        val multipleChoiceDialog = MultipleChoiceDialogFragment()
        multipleChoiceDialog.show(supportFragmentManager, "multiple choice dialog")
    }

    override fun onPositiveResult(dlg: DialogFragment) {
        Log.i(TAG, "Dialog Positive Result")
    }

    override fun onNegativeResult(dlg: DialogFragment) {
        Log.i(TAG, "Dialog Negative Result")
    }

    override fun onNeutralResult(dlg: DialogFragment) {
        Log.i(TAG, "Dialog Neutral Result")
    }

}