package com.acante.kotlinsecretproject.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.acante.kotlinsecretproject.R
import com.acante.kotlinsecretproject.ui.login.LoginFragment
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
        initViews()
    }
    private fun initViews(){
        activity!!.setTitle(R.string.register_fragment_title)
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
            .setCustomAnimations(R.anim.enter_from_left,R.anim.exit_to_right)
            .replace(
                R.id.container_view,
                LoginFragment()
            )
            .commit()
    }
}