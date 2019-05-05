package com.acante.kotlinsecretproject.ui.login

import com.acante.kotlinsecretproject.ui.base.BaseCotract

interface LoginContract : BaseCotract {

    interface View : BaseCotract.View{

    }
    interface Presenter : BaseCotract.Presenter<View>{
            fun login()
    }
}