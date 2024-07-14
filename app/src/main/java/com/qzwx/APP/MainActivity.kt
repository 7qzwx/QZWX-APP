package com.qzwx.APP

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
                    // 设置导航主机
                    NavHost(navController, startDestination = BottomNavItem.AllApps.route, Modifier.padding(innerPadding)) {
                        composable(BottomNavItem.AllApps.route) { AllAppsScreen() }
                        composable(BottomNavItem.Music.route) { MusicScreen() }
                        composable(BottomNavItem.Profile.route) { ProfileScreen() }
                    }
                }
            }
        }
    }
}

// 页面函数定义
@Composable
fun AllAppsScreen() {
    Text(text = "全部应用页面")
}

@Composable
fun MusicScreen() {
    Text(text = "音乐页面")
}

@Composable
fun ProfileScreen() {
    Text(text = "我的页面")
}

