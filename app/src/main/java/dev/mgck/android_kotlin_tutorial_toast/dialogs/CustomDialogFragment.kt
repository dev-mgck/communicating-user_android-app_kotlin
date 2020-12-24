package dev.mgck.android_kotlin_tutorial_toast.dialogs

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import dev.mgck.android_kotlin_tutorial_toast.R

class CustomDialogFragment :  DialogFragment() {

    @SuppressLint("InflateParams")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(activity!!)

        // Create the custom layout using the LayoutInflater class
        val inflater = activity!!.layoutInflater
        val v = inflater.inflate(R.layout.custom_dialog_layout, null)

        // Build the dialog
        builder.setTitle("Digite seus dados:")
            .setPositiveButton("OK") { dialog, which ->
                Toast.makeText(activity, "Thanks!", Toast.LENGTH_SHORT).show() }
            .setNegativeButton("Cancel") { dialog, which ->
                getDialog()?.cancel() }
            .setView(v)
        return builder.create()
    }
}