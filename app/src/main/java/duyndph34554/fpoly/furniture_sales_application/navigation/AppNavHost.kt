package duyndph34554.fpoly.furniture_sales_application.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import duyndph34554.fpoly.furniture_sales_application.profile.AddPaymentScreen
import duyndph34554.fpoly.furniture_sales_application.cart.AddShipmentScreen
import duyndph34554.fpoly.furniture_sales_application.profile.AddressScreen
import duyndph34554.fpoly.furniture_sales_application.product.DetailsProduct
import duyndph34554.fpoly.furniture_sales_application.cart.FinalScreen
import duyndph34554.fpoly.furniture_sales_application.screen.LoginScreen
import duyndph34554.fpoly.furniture_sales_application.profile.MyReViewTopBar
import duyndph34554.fpoly.furniture_sales_application.profile.OrderScreenRun
import duyndph34554.fpoly.furniture_sales_application.profile.ReView
import duyndph34554.fpoly.furniture_sales_application.screen.RegisterScreen
import duyndph34554.fpoly.furniture_sales_application.cart.SelectPaymentScreen
import duyndph34554.fpoly.furniture_sales_application.cart.SmallTopAppBarPayment
import duyndph34554.fpoly.furniture_sales_application.cart.SmallTopAppCart

import duyndph34554.fpoly.furniture_sales_application.profile.settingScreens
import duyndph34554.fpoly.furniture_sales_application.screen.WelComeScreen


enum class ROUTE_NAME {
    welcome,
    login,
    home,
    signup,
    detail,
    cart,
    checkout,
    success,
    order,
    addShipment,
    addPayment,
    paymentMethod,
    setting,
    selectShipment,
    myReview,
    rating
}

// Quan ly chuyen man
@Composable
fun AppNavHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = "welcome") {
        composable(ROUTE_NAME.welcome.name) { WelComeScreen(navController) }
        composable(ROUTE_NAME.login.name) { LoginScreen(navController) }
        composable(ROUTE_NAME.home.name) { FurnitureApp(navController) }
        composable(ROUTE_NAME.signup.name) { RegisterScreen(navController) }
        composable(ROUTE_NAME.detail.name) { DetailsProduct(navController) }
        composable(ROUTE_NAME.cart.name) { SmallTopAppCart(navController) }
        composable(ROUTE_NAME.checkout.name) { SmallTopAppBarPayment(navController) }
        composable(ROUTE_NAME.success.name) { FinalScreen(navController) }
        composable(ROUTE_NAME.order.name) { OrderScreenRun(navController) }
        composable(ROUTE_NAME.addShipment.name) { AddShipmentScreen(navController) }
        composable(ROUTE_NAME.addPayment.name) { AddPaymentScreen(navController) }
        composable(ROUTE_NAME.paymentMethod.name) { SelectPaymentScreen(navController) }
        composable(ROUTE_NAME.setting.name) { settingScreens(navController) }
        composable(ROUTE_NAME.selectShipment.name) { AddressScreen(navController) }
        composable(ROUTE_NAME.myReview.name) { MyReViewTopBar(navController) }
        composable(ROUTE_NAME.rating.name) { ReView(navController) }
    }
}