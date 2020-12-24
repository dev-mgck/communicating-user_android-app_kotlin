package dev.mgck.android_kotlin_tutorial_toast.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import dev.mgck.android_kotlin_tutorial_toast.R

class SingleChoiceDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)

        // NOTE: setMessage doesn't work here because the list takes up the content
        // area. Use the setTitle method to set a descriptive prompt
        builder.setTitle("Qual é a sua cor favorita?")
        builder.setItems(R.array.cores) { dialog, which ->
            val cores = context?.resources?.getStringArray(R.array.cores) as Array<*>
            val cor = cores[which]
            Toast.makeText(activity,
                String.format("Cor selecionada: %s",cor),
                Toast.LENGTH_SHORT).show()
        }
        return builder.create()
    }
}