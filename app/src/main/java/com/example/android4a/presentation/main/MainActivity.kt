package com.example.android4a.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Observer
import com.example.android4a.Constants
import com.example.android4a.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity() {
    val mainViewModel: MainViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.loginLiveData.observe(this, Observer {
            when (it) {
                is LoginSuccess -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle(Constants.SUCCESS_MSG)
                        .setMessage(Constants.VALID_ACCOUNT)
                        .setPositiveButton(Constants.ITS_OK) { dialog, which ->
                            dialog.dismiss()
                            val myIntent = Intent(this@MainActivity, ApplicationActivity::class.java)
                            startActivity(myIntent)
                        }
                        .show()
                }
                LoginError ->
                    MaterialAlertDialogBuilder(this)
                        .setTitle(Constants.ERROR_MSG)
                        .setMessage(Constants.INVALID_ACCOUNT)
                        .setPositiveButton(Constants.ITS_OK) { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                PassError ->
                    MaterialAlertDialogBuilder(this)
                        .setTitle(Constants.ERROR_MSG)
                        .setMessage(Constants.INVALID_PASS)
                        .setPositiveButton(Constants.ITS_OK) { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                LoginCreate ->
                    MaterialAlertDialogBuilder(this)
                        .setTitle(Constants.SUCCESS_MSG)
                        .setMessage(Constants.ACCOUNT_CREATE)
                        .setPositiveButton(Constants.ITS_OK) { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                LoginExist ->
                    MaterialAlertDialogBuilder(this)
                        .setTitle(Constants.ERROR_MSG)
                        .setMessage(Constants.LOGIN_TAKEN)
                        .setPositiveButton(Constants.ITS_OK) { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
            }
        })

        login_button.isEnabled = false
        create_account_button.isEnabled = false
        login_edit.doAfterTextChanged{
            login_button.isEnabled =
                !(login_edit.text.toString() == "" || password_edit.text.toString() == "")
            create_account_button.isEnabled =
                !(login_edit.text.toString() == "" || password_edit.text.toString() == "")
        }
        password_edit.doAfterTextChanged{
            login_button.isEnabled =
                !(login_edit.text.toString() == "" || password_edit.text.toString() == "")
            create_account_button.isEnabled =
                !(login_edit.text.toString() == "" || password_edit.text.toString() == "")
        }

        login_button.setOnClickListener(){
            mainViewModel.onClickedLogin(
                login_edit.text.toString().trim(),
                password_edit.text.toString()
            )
        }

        create_account_button.setOnClickListener(){
            mainViewModel.onClickedCreate(
                login_edit.text.toString().trim(),
                password_edit.text.toString()
            )
        }

    }
}