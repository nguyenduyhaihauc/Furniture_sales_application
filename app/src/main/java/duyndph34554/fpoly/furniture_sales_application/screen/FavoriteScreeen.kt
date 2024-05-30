package duyndph34554.fpoly.furniture_sales_application.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import duyndph34554.fpoly.furniture_sales_application.custom.CustomButton
import duyndph34554.fpoly.furniture_sales_application.R
import duyndph34554.fpoly.furniture_sales_application.models.Product


@Composable
fun FavoriteScreen(innerPadding: PaddingValues) {
    Column(modifier = Modifier) {
        FavoriteGrid(productArr = productArr)
    }
}

// Item Favorite
@Composable
fun FavoriteItem(icon : Int , name : String , price : Double){
    Row (modifier = Modifier
        .fillMaxWidth()
        .height(110.dp)
        .background(Color.White),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically){
        Image(painter = painterResource(id = icon), contentDescription = null, modifier = Modifier
            .width(110.dp)
            .height(120.dp), contentScale = ContentScale.FillBounds)

        Column (modifier = Modifier
            .width(170.dp)
            .padding(start = 10.dp)
            .fillMaxHeight()) {
            Text(text = name,
                fontSize = 15.sp,
                fontWeight = FontWeight(600),
                color = colorResource(id = R.color.gray
            ), fontFamily = FontFamily(
                Font(R.font.nunitosans_7pt_condensed_light)
            ))
            Spacer(modifier = Modifier.height(3.dp))
            Text(text = "\$ " + price,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_bold)
            ))
        }
        Column (
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally){
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.icon_delete),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.bag),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
            
        }
    }
}


@Composable
fun FavoriteGrid(productArr: List<Product>) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(productArr) { productRow ->
                FavoriteItem(
                    icon = productRow.image,
                    name = productRow.name,
                    price = productRow.price
                )
                Spacer(modifier = Modifier.height(10.dp))
                Divider(color = colorResource(id = R.color.graySecond), thickness = 1.dp)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, end = 10.dp, bottom = 15.dp),
            contentAlignment = Alignment.BottomEnd) {
            CustomButton(
                title = "Add all to my cart", modifier = Modifier
                    .padding(7.dp)
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF242424))
                    .clickable(onClick = {}), textStyle = TextStyle(
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_light)),
                    fontWeight = FontWeight(600),
                    fontSize = 17.sp
                )
            )
        }
    }
}