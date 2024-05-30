package duyndph34554.fpoly.furniture_sales_application.screen

import android.text.Layout
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import duyndph34554.fpoly.furniture_sales_application.R
import duyndph34554.fpoly.furniture_sales_application.Screen
import duyndph34554.fpoly.furniture_sales_application.models.Product

@Composable
fun GreetingPreview() {
    SmallTopAppBarExample()
}
val productArr = listOf(
    Product(R.drawable.image1, "Black Simple Lamp", 12.00),
    Product(R.drawable.image2, "Black Simple Lamp", 12.00),
    Product(R.drawable.image3, "Black Simple Lamp", 12.00),
    Product(R.drawable.image1, "Black Simple Lamp", 12.00),
    Product(R.drawable.image1, "Black Simple Lamp", 12.00),
    Product(R.drawable.image2, "Black Simple Lamp", 12.00),
    Product(R.drawable.image3, "Black Simple Lamp", 12.00),
    Product(R.drawable.image1, "Black Simple Lamp", 12.00),
)
@Composable
fun NavigationGraph(navController: NavHostController, innerPadding: PaddingValues) {

}

public class Category(val icon: Int, val name: String)

@Composable
fun HomeScreen(innerPadding: PaddingValues = PaddingValues(), navController: NavController) {
    val categoryArr = listOf(
        Category(R.drawable.icon_star, "Popular"),
        Category(R.drawable.chair, "Chair"),
        Category(R.drawable.table, "Table"),
        Category(R.drawable.sofa, "Armchair"),
        Category(R.drawable.bed, "Bed"),
        Category(R.drawable.cart, "Chair"),
        Category(R.drawable.cart, "Chair"),
        Category(R.drawable.cart, "Chair")
    )
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.padding(
            top = 10.dp,
            end = 15.dp,
            start = 15.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(scrollState)
        ) {
            categoryArr.forEach { category ->
                CategoryItem(icon = category.icon, name = category.name)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(productArr.chunked(2)) { productRow ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    for (product in productRow) {
                        ProductItem(
                            image = product.image,
                            name = product.name,
                            price = product.price,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}

//Item danh muc
@Composable
fun CategoryItem(icon: Int, name: String) {
    Column(
        modifier = Modifier.padding(end = 25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .size(44.dp)
                .shadow(elevation = 2.dp, RoundedCornerShape(14.dp))
                .background(color = Color("#F5F5F5".toColorInt())),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(22.dp)
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = name,
            color = Color("#999999".toColorInt()),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(
                Font(R.font.nunitosans_7pt_condensed_light)
            )
        )
    }
}

//Item Product
@Composable
fun ProductItem(image: Int, name: String, price: Double , navController: NavController) {
    Column(
        modifier = Modifier
            .width(165.dp)
            .height(253.dp)
            .clickable { navController.navigate("detail") },
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = image),
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 10.dp, end = 15.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.End
            ) {
                Row(
                    modifier = Modifier
                        .size(30.dp)
                        .shadow(elevation = 2.dp, RoundedCornerShape(6.dp))
                        .background(color = Color.Gray.copy(alpha = 0.4f))
                        .alpha(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(painter = painterResource(id = R.drawable.shopping_bag),
                            contentDescription = "shopping bag",
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }
        }
        Text(
            text = name,
            fontSize = 14.sp,
            color = Color("#606060".toColorInt()),
            fontWeight = FontWeight(500),
            fontFamily = FontFamily(
                Font(R.font.nunitosans_7pt_condensed_light)
            )
        )
        Text(
            text = "\$ " + price,
            fontSize = 14.sp,
            color = Color("#303030".toColorInt()),
            fontWeight = FontWeight(700),
            fontFamily = FontFamily(
                Font(R.font.nunitosans_7pt_condensed_light)
            )
        )
    }
}

// Quản lý chính màn hình HomeScreen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallTopAppBarExample() {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.white),
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Gray,
                                fontSize = 18.sp,
                                fontWeight = FontWeight(400),
                                fontFamily = FontFamily(Font(R.font.gelasio_bold))
                            )
                        ) {
                            append("Make home\n")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = Color.Black,
                                fontSize = 18.sp,
                                fontWeight = FontWeight(700),
                                fontFamily = FontFamily(Font(R.font.gelasio_bold))
                            )
                        ) {
                            append("BEAUTIFUL")
                        }
                    }, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.cart),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
            )
        },
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { innerPadding ->
        NavigationGraph(navController = navController, innerPadding)
    }
}

//BottomNavigationBar
@Composable
private fun BottomNavigationBar(navController: NavHostController) {

    // Tạo list dựa vào các object đã khai báo ở main
    val items = listOf(
        Screen.Home,
        Screen.History,
        Screen.Cart,
        Screen.Profile
    )

    NavigationBar(
        containerColor = Color("#ffffff".toColorInt())
    ) {
        // trả về thông tin của màn hình hiện tại( đường dẫn ,trạng thái màn hình,Trạng thái vòng đời của màn hình,..)
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        val currentRoute = navBackStackEntry?.destination?.route
        // kiểm tra xem các mục trong điều hướng có trùng với đường dẫn màn hình đc lưu trong biến currentRoute hay ko

        items.forEach { screen ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painterResource(id = screen.icon),
                        contentDescription = screen.title,
                        modifier = Modifier.size(24.dp)
                    )
                },

                selected = currentRoute == screen.route, // nếu danh mục được chọn, trả về currentRoute= link đường dẫn đến danh mục được chọn
                onClick = {
                    navController.navigate(screen.route) {
                        // Điều hướng đến một màn hình duy nhất, không tạo thêm bản sao
                        launchSingleTop = true
                        // Khôi phục trạng thái đã lưu
                        restoreState = true
                        // Xóa tất cả các trang trước trang đích để tránh chồng chất trang
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorResource(id = android.R.color.holo_orange_dark),
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = colorResource(id = android.R.color.holo_orange_dark),
                    unselectedTextColor = Color.Gray,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}