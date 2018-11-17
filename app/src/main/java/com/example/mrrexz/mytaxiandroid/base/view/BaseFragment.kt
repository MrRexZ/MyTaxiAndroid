package com.example.mrrexz.mytaxiandroid.base.view

import android.content.Context
import android.support.v4.app.Fragment

abstract class BaseFragment : Fragment(), BaseFragmentView {

    override fun getNullableContext(): Context? {
        return super.getContext()
    }
}