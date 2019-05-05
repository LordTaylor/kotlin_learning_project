package com.acante.kotlinsecretproject.ui.register

import com.acante.kotlinsecretproject.ui.base.BaseCotract

interface RegisterContract: BaseCotract{
    interface View :BaseCotract.View{

    }
    interface Presenter : BaseCotract.Presenter<View>{
        fun userRegister()
    }
}