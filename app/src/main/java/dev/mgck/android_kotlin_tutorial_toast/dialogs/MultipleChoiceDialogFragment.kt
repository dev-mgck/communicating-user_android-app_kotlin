package dev.mgck.android_kotlin_tutorial_toast.dialogs

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import dev.mgck.android_kotlin_tutorial_toast.R

class MultipleChoiceDialogFragment : DialogFragment()  {

    override fun onCreateDialog(savedInstanceState: Bundle?): AlertDialog {

        val checkeds = booleanArrayOf(false, true, false, true, false, false)

        return AlertDialog.Builder(activity!!)
            .setTitle("Escolha uma ou mais linguagens")
            .setMultiChoiceItems(R.array.linguagens, checkeds) { dialog, which, isChecked ->
                val linguagens = context?.resources?.getStringArray(R.array.linguagens) as Array<String>
                val linguagem : String = linguagens[which]

                if(isChecked) {
                    Toast.makeText(activity, "Linguagem " + linguagem + " marcada."
                        , Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(activity, "Linguagem " + linguagem + " desmarcada."
                        , Toast.LENGTH_SHORT).show()
                }
            }
            .create()
    }
}