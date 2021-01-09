package com.raywenderlich.android.rwandroidtutorial

interface BaseView<T> {
    fun setPresenter(presenter: T)
}