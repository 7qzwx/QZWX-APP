package com.qzwx.APP.ui

import androidx.annotation.DrawableRes
import com.qzwx.APP.R

// 定义底部导航栏的项
enum class BottomNavItem(val label: String, @DrawableRes val icon: Int, val route: String) {
    AllApps("全部应用", R.drawable.svg_all, "all_apps"),
    Music("音乐", R.drawable.svg_music, "music"),
    Profile("我的", R.drawable.svg_my, "profile")
}
