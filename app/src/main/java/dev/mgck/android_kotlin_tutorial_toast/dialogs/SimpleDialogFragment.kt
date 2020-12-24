package dev.mgck.android_kotlin_tutorial_toast.dialogs

import android.app.Activity
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import dev.mgck.android_kotlin_tutorial_toast.R

class SimpleDialogFragment : DialogFragment() {

    private var mHost: SimpleDialogListener? = null

    interface SimpleDialogListener {
        fun onPositiveResult(dlg: DialogFragment)
        fun onNegativeResult(dlg: DialogFragment)
        fun onNeutralResult(dlg: DialogFragment)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): AlertDialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Dialog Simples")
            builder.setMessage("Desenvolvimento Android é difícil?")
            builder.setPositiveButton("SIM"
            ) { dialog, which -> showToast("Você apertou o botão: SIM")
                mHost!!.onPositiveResult(this@SimpleDialogFragment)}
            builder.setNegativeButton("NÃO"
            ) { dialog, which -> showToast("Você apertou o botão: NÃO")
                mHost!!.onNegativeResult(this@SimpleDialogFragment)}
            builder.setNeutralButton("TALVEZ"
            ) { dialog, which -> showToast("Você apertou o botão: TALVEZ")
                mHost!!.onNeutralResult(this@SimpleDialogFragment)}
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        showToast("Você cancelou o Dialog")
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        mHost = activity as SimpleDialogListener
    }

    private fun showToast(msg : String) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
    }
}