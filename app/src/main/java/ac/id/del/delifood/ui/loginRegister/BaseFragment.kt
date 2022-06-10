package ac.id.del.delifood.ui.loginRegister

import ac.id.del.delifood.R
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

open class BaseFragment : AppCompatActivity() {
    private lateinit var mProgressDialog: Dialog

    fun showErrorSnackBar(message: String, errorMessage: Boolean) {
        val snackBar =
            Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG)
        val snackBarView = snackBar.view

        if (errorMessage) {
            snackBarView.setBackgroundColor(
                ContextCompat.getColor(
                    this@BaseFragment,
                    R.color.colorSnackBarError
                )
            )
        } else {
            snackBarView.setBackgroundColor(
                ContextCompat.getColor(
                    this@BaseFragment,
                    R.color.colorSnackBarSuccess
                )
            )
        }
        snackBar.show()
    }

    fun showProgresssDialog() {
        mProgressDialog =  Dialog(this)
        /* Set thr screen content from layout resorce
        * The resource will be inflated, adding all top level view to the screen */
        mProgressDialog.setContentView(R.layout.dialog_progress)

        mProgressDialog.setCancelable(false)
        mProgressDialog.setCanceledOnTouchOutside(false)

        // Start the dialog and display it on screen
        mProgressDialog.show()
    }

    fun hideProgresssDialog() {
        mProgressDialog.dismiss()
    }
}