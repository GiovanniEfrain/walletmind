package com.itigevc.walletmind.basic

interface ViewContract {
    fun setLoaderVisibility(flag: Boolean)
    fun setEmptyViewVisibility(flag: Boolean,message:String? = null)
}