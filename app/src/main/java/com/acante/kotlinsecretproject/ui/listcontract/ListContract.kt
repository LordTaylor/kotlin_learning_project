package com.acante.kotlinsecretproject.ui.listcontract

import com.acante.kotlinsecretproject.ui.base.BaseCotract

interface ListContract{
    interface presenter:BaseCotract.Presenter<View>{
        fun loadData()

    }
    interface View : BaseCotract.View
}