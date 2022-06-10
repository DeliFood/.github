package ac.id.del.delifood.activities

import ac.id.del.delifood.R
import ac.id.del.delifood.firestore.FirestoreClass
import ac.id.del.delifood.models.User
import ac.id.del.delifood.utils.InterButton
import ac.id.del.delifood.utils.InterEditText
import ac.id.del.delifood.utils.InterTextViewBold
import ac.id.del.delifood.utils.InterTextViewRegular
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.WindowInsets
import android.view.WindowManager
import android.view.View
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : BaseActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else{
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        // Click event assigned to Forgot Password text
        val forgotPassword = findViewById<InterTextViewRegular>(R.id.forgot_password)
        val btnLogin = findViewById<InterButton>(R.id.button_login)
        val textRegister = findViewById<InterTextViewBold>(R.id.txt_register)

        forgotPassword.setOnClickListener(this)
        btnLogin.setOnClickListener(this)
        textRegister.setOnClickListener(this)
    }

    fun userLoggedSuccess(user: User) {
        hideProgresssDialog()

        Log.i("First Name", user.firstName)
        Log.i("Last Name", user.lastName)
        Log.i("Email", user.email)

        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        finish()
    }

    override fun onClick(view: View?) {
        if (view != null) {
            when (view.id) {
                R.id.forgot_password -> {
                    val  intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
                    startActivity(intent)
                }

                R.id.button_login -> {
                    // Start
                    loginRegisteredUser()
                    // END
                }

                R.id.txt_register -> {
                    // Launch the register screen when the user click on the text
                    val  intent = Intent(this@LoginActivity, RegisterActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    private fun validateLoginDetails(): Boolean {

        val etEmail: InterEditText = findViewById(R.id.et_email)
        val etPassword: InterEditText = findViewById(R.id.et_password)

        return when {
            TextUtils.isEmpty(etEmail.text.toString().trim { it <= ' '}) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_email), true)
                false
            }
            TextUtils.isEmpty(etPassword.text.toString().trim { it <= ' '}) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_password), true)
                false
            }
            else -> {
                true
            }
        }
    }

    private  fun loginRegisteredUser() {
        if (validateLoginDetails()) {

            // Show the progress dialog
            showProgresssDialog()

            val etEmail: InterEditText = findViewById(R.id.et_email)
            val etPassword: InterEditText = findViewById(R.id.et_password)
            // Get th text from editText and trim the space

            val email = etEmail.text.toString().trim { it <= ' '}
            val password = etPassword.text.toString().trim { it <= ' '}

            //Log in using FirebaseAuth
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->

                    // Hide the progress dialog
//                    hideProgresssDialog()

                    if (task.isSuccessful) {
//                        showErrorSnackBar(resources.getString(R.string.login_successfull), false)
                        val  intent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(intent)

                        FirestoreClass().getUserDetails(this@LoginActivity)
                    } else {
                        hideProgresssDialog()
                        showErrorSnackBar(task.exception!!.message.toString(), false)
                    }
                }
        }
    }
}