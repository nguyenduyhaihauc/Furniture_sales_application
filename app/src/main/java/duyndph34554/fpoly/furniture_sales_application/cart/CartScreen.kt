package duyndph34554.fpoly.furniture_sales_application.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import duyndph34554.fpoly.furniture_sales_application.R
import duyndph34554.fpoly.furniture_sales_application.models.Product
import duyndph34554.fpoly.furniture_sales_application.screen.productArr


// Cart Item
@Composable
fun CartItem(icon : Int , name : String , price : Double, quantity: Int){

    Row (modifier = Modifier
        .fillMaxWidth()
        .height(110.dp)
        .background(Color.White),
        horizontalArrangement = Arrangement.SpaceBetween
    ){

        Image(painter = painterResource(id = icon), contentDescription = null, modifier = Modifier
            .width(110.dp)
            .height(120.dp), contentScale = ContentScale.FillBounds)

        Column (modifier = Modifier
            .width(170.dp)
            .padding(start = 10.dp)
            .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween) {
            Column {
                Text(text = name, fontSize = 15.sp, fontWeight = FontWeight(600), color = colorResource(
                    id = R.color.gray
                ), fontFamily = FontFamily(
                    Font(R.font.nunitosans_7pt_condensed_light)
                ))
                Spacer(modifier = Modifier.height(3.dp))
//                Gia san pham
                Text(text = "\$ "+price, fontSize = 16.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily(
                    Font(R.font.nunitosans_7pt_condensed_bold)
                ))
            }

//            Tang giam so luong san pham trong gio hàng
            Row(
                modifier = Modifier.width(113.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                var quantity by remember {
                    mutableStateOf(quantity)
                }
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(color = Color("#E0E0E0".toColorInt())),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(onClick = { if (quantity > 1) quantity-- }) {
                        Icon(painter = painterResource(id = R.drawable.apart),
                            contentDescription = null,
                            modifier = Modifier.size(13.dp)
                        )
                    }
                }
                Text(
                    text = "$quantity",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    fontFamily = FontFamily(
                        Font(R.font.nunitosans_7pt_condensed_bold)
                    )
                )
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(color = Color("#E0E0E0".toColorInt())),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(onClick = { quantity++ }) {
                        Icon(painter = painterResource(id = R.drawable.add),
                            contentDescription = null,
                            modifier = Modifier.size(13.dp)
                        )
                    }
                }
            }

        }


        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Top
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.icon_delete),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            }
        }

    }
}

//   CartScreen

@Composable
fun CartScreen(innerPadding: PaddingValues, navHostController: NavController) {

    var comment by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = 10.dp,
                innerPadding.calculateTopPadding(),
                end = 10.dp
            ),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
//        List danh sach san pham trong gio hang
        CartGrid(productArr = productArr)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
//            Phan Comment
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp),
                contentAlignment = Alignment.TopEnd
            ) {

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextField(
                        placeholder = {
                            Text(
                                text = "Enter your promo code",
                                color = Color("#999999".toColorInt()),
                                fontSize = 16.sp,
                                fontFamily = FontFamily(
                                    Font(R.font.nunitosans_7pt_condensed_light)
                                ),
                                fontWeight = FontWeight(600)
                            )
                        },
                        modifier = Modifier
                            .weight(0.85f),
                        value = comment,
                        onValueChange = {comment = it},
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color(0xffE0E0E0),
                            unfocusedIndicatorColor = Color(0xffE0E0E0),
                            cursorColor = Color.Black
                        ),
                    )

                    Box(
                        modifier = Modifier
                            .size(45.dp)
                            .border(2.dp, Color.Black, RoundedCornerShape(10.dp)),
                        contentAlignment = Alignment.Center,

                    ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(painter = painterResource(id = R.drawable.arrownext),
                                contentDescription = null,
                                modifier = Modifier.size(22.dp)
                            )
                        }
                    }
                }
            }

//           Phan tong tien
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Total:",
                    fontSize = 23.sp,
                    fontWeight = FontWeight(700),
                    color = Color("#808080".toColorInt()),
                    fontFamily = FontFamily(
                        Font(R.font.nunitosans_7pt_condensed_bold)
                    )
                )
                Text(
                    text = "\$ 95.00",
                    fontSize = 23.sp,
                    fontWeight = FontWeight(700),
                    color = Color("#000000".toColorInt()),
                    fontFamily = FontFamily(
                        Font(R.font.nunitosans_7pt_condensed_bold)
                    )
                )
            }

//            Nut CheckBox

            Box(
                modifier = Modifier
                    .padding(7.dp)
                    .fillMaxWidth()
                    .height(60.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF242424))
                    .clickable(onClick = {
                        navHostController.navigate("checkout")
                    })
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Check Box",
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_light)),
                        fontWeight = FontWeight(600),
                        fontSize = 17.sp
                    )
                }
            }
        }
    }
}

//Duyet list de hien thij danh sach san pham gio hang len LazyColumn

@Composable
fun CartGrid(productArr: List<Product>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(productArr) { productRow ->
            CartItem(icon = productRow.image, name = productRow.name, price = productRow.price, quantity = productRow.quantity)
            Spacer(modifier = Modifier.height(10.dp))
            Divider(color = colorResource(id = R.color.graySecond), thickness = 1.dp)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

// Man tong quan ly CartScreen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallTopAppCart(navHostController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black,
                ),
                title = {
                    Text(
                        "My Cart",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        fontFamily = FontFamily(
                            Font(R.font.merriweather_regular)
                        )
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navHostController.navigateUp()
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrowback),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                actions = {
                    IconButton(
                        modifier = Modifier.size(24.dp),
                        onClick = { /* do something */ }) {
                    }
                },
            )
        },

        ) { innerPadding ->
        CartScreen(innerPadding = innerPadding , navHostController = navHostController)
    }
}