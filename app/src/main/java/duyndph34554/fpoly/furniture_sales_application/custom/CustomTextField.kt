package duyndph34554.fpoly.furniture_sales_application.custom

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import duyndph34554.fpoly.furniture_sales_application.R

//Custom TextFied
@Composable
fun CustomTextField() {
    var username by remember { mutableStateOf("") }
    TextField(
        value = username,
        onValueChange = {
            username = it
        },
        modifier = Modifier
            .fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            unfocusedIndicatorColor = Color(0xffE0E0E0),
            focusedIndicatorColor = Color(0xffE0E0E0),
            cursorColor = Color.Black
        ),
    )
}


// Pass, RePass Sign
@Composable
fun PasswordTextField() {
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    TextField(
        value = password,
        onValueChange = { password = it },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            unfocusedIndicatorColor = Color(0xffE0E0E0),
            focusedIndicatorColor = Color(0xffE0E0E0),
            cursorColor = Color.Black
        ),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image =
                if (passwordVisible)
                    painterResource(id = R.drawable.hide)
                else
                    painterResource(id = R.drawable.view)
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(painter = image, contentDescription = null, modifier = Modifier.size(20.dp))
            }
        }
    )
}

// chua text va TextField
@Composable
fun InputRow(title: String) {
    Column {
        Text(
            text = title,
            color = colorResource(id = R.color.graySecond),
            fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_light)),
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp
        )
        CustomTextField()
    }
}

@Composable
fun InputRowPass(title: String) {
    Column {
        Text(
            text = title,
            color = colorResource(id = R.color.graySecond),
            fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_light)),
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp
        )
        PasswordTextField()
    }
}