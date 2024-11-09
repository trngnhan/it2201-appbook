package com.haunp.mybookstore

import com.haunp.mybookstore.databinding.ActivityMainBinding
import com.tta.fitnessapplication.view.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getDataBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }
}