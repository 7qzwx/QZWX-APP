package com.qzwx.APP.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.AllApps,
        BottomNavItem.Music,
        BottomNavItem.Profile
    )

    NavigationBar(
        contentColor = Color.Black,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp) // 设置导航栏高度
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painterResource(id = item.icon),
                        contentDescription = item.label,
                        modifier = Modifier.size(24.dp) // 调整图标大小
                    )
                },
                selected = currentRoute == item.route,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black, // 选中状态下图标颜色
                    unselectedIconColor = Color.Gray, // 未选中状态下图标颜色
                    selectedTextColor = Color.Black, // 选中状态下文本颜色
                    unselectedTextColor = Color.Gray, // 未选中状态下文本颜色
                    indicatorColor = Color.Transparent // 选中项指示器背景色
                ),
                alwaysShowLabel = false, // 隐藏标签
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { startDestination ->
                            popUpTo(startDestination) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                modifier = Modifier.align(Alignment.Bottom) // 图标位于底部中心
                    .padding(bottom = 4.dp) // 调整距离底部的距离
            )
        }
    }
}
