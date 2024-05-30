package duyndph34554.fpoly.furniture_sales_application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

sealed class Screen(val route: String, val icon: Int, val title: String) {
    object Home : Screen("home", R.drawable.home, "Trang chủ")
    object History : Screen("history", R.drawable.marker, "Lịch sử")
    object Cart : Screen("cart", R.drawable.bell, "Giỏ hàng")
    object Profile : Screen("profile", R.drawable.person, "Hồ sơ")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        }
    }
}