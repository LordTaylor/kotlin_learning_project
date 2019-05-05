package com.acante.kotlinsecretproject.ui.register

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.acante.kotlinsecretproject.R
import com.acante.kotlinsecretproject.ui.list.ListFragment
import com.acante.kotlinsecretproject.ui.login.LoginFragment
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment(), RegisterContract.View {
    lateinit var presenter: RegisterPresenter
    lateinit var rootView: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_register, container, false)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = RegisterPresenter(context!!)
        presenter.attache(this)
        register_textView_login.setOnClickListener {
            showLoginFragment()
        }
        register_button_register.setOnClickListener {
            var email = register_editText_email.text.toString()
            var pass = register_edittext_password.text.toString()
            var pass2 =register_edittext_confirm_password.text.toString()
            if (presenter.validateCredentials(email, pass, pass2)) {
                presenter.userRegister(email,pass2)
            }
        }
    }

    override fun showListFragment() {

    }

    override fun showLoginFragment() {
        fragmentManager!!.beginTransaction()
            .replace(
                R.id.container_view,
                LoginFragment()
            )
            .commit()
    }
}