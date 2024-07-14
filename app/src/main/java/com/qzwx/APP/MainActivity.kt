package com.qzwx.APP

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.qzwx.APP.ui.* // 导入所有 ui 包中的文件
import com.qzwx.APP.ui.theme.QZWXTheme

// 主活动类
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QZWXTheme {
                // 记住导航控制器
                val navController = rememberNavController()
                Scaffold(
                    // 设置底部导航栏
                    bottomBar = { BottomNavigationBar(navController) }
                ) { innerPadding ->
  // ---------------------------------设置导航主机，新页面需要导航栏需要在此注册！！------------------------------------------------
                    NavHost(navController, startDestination = BottomNavItem.AllApps.route, Modifier.padding(innerPadding)) {
                        composable(BottomNavItem.AllApps.route) { All_apps(navController = navController) }
                        composable(BottomNavItem.Music.route) { Music(navController=navController) }
                        composable(BottomNavItem.Profile.route) { ProfileScreen() }
                    }
                }
            }
        }
    }
}
