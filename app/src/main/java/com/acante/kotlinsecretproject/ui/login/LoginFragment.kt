package com.acante.kotlinsecretproject.ui.login

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.acante.kotlinsecretproject.R
import com.acante.kotlinsecretproject.ui.list.ListFragment
import com.acante.kotlinsecretproject.ui.register.RegisterFragment
import com.acante.kotlinsecretproject.utils.Constance.Companion.PREF_NAME
import com.acante.kotlinsecretproject.utils.Constance.Companion.USER_EMAIL
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.fragment_login.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class LoginFragment : Fragment(), LoginContract.View {
    override fun setEmail(email: String) {
        this.email = email
    }

    private var email: String = ""
    lateinit var rootView: View
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        instance = this

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_login, container, false)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = LoginPresenter(context!!)
        presenter.attache(this)
        initViews()
    }

    private fun initViews() {
        activity!!.setTitle(R.string.login_fragment_title)
        login_textView_register.setOnClickListener {
            showRegisterFragment()
        }
        login_button_login.setOnClickListener {
            var email = login_editText_email.text.toString()
            var pass = login_editText_password.text.toString()
            presenter.login(email, pass)
        }
        login_editText_email.setText(this.email)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onDetach() {
        super.onDetach()

    }

    override fun showListFragment(user: FirebaseUser) {
        val sp = activity!!.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        sp.edit().putString(USER_EMAIL, user.email).commit()

        fragmentManager!!.beginTransaction()
            .setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right)
            .replace(
                R.id.container_view,
                ListFragment()
            )
            .commit()
    }

    override fun showRegisterFragment() {
        fragmentManager!!.beginTransaction()
            .setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right)
            .replace(
                R.id.container_view,
                RegisterFragment()
            )
            .commit()
    }


    companion object {
        val instance: LoginFragment = LoginFragment()
    }
}
