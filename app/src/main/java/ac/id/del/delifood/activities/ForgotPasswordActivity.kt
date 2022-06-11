package ac.id.del.delifood.activities

import ac.id.del.delifood.R
import ac.id.del.delifood.utils.InterButton
import ac.id.del.delifood.utils.InterEditText
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        setupActionBar()
    }

    private fun setupActionBar() {
        val toolbarRegisterActivity: Toolbar = findViewById(R.id.toolbar_forgot_password_activity)
        val btnSubmit: InterButton = findViewById(R.id.button_forgot_password)

        setSupportActionBar(toolbarRegisterActivity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24)
        }

        toolbarRegisterActivity.setNavigationOnClickListener { onBackPressed() }

        btnSubmit.setOnClickListener {
            val etEmail: InterEditText = findViewById(R.id.et_email_forgot_password)
            val email: String = etEmail.text.toString().trim { it <= ' '}

            if (email.isEmpty()) {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_email), false)
            } else {
                showProgresssDialog()
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        hideProgresssDialog()
                        if (task.isSuccessful) {
                            // Show the toast message and finish the forgot password activity to go back to the
                            Toast.makeText(
                                this@ForgotPasswordActivity,
                                resources.getString(R.string.email_sent_success),
                                Toast.LENGTH_LONG
                            ).show()
                            finish()
                        } else {
                            showErrorSnackBar(task.exception!!.message.toString(), true)
                        }
                    }
            }

        }
    }

}