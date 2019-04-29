package com.acante.kotlinsecretproject.ui.detail

import com.acante.kotlinsecretproject.ui.base.BaseCotract

interface DetailContract:BaseCotract {
    interface View:BaseCotract.View

    interface Presenter:BaseCotract.Presenter<View>
}