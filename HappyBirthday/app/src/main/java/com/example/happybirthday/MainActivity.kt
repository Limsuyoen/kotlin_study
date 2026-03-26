package com.example.happybirthday

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greetingcard.R
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //composable환경이라서 뭐든 넣을 수 있음!
            HappyBirthdayTheme(dynamicColor = false) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(message = stringResource(R.string.happy_birthday_bumgyu),
                                  from = stringResource(R.string.signature_text)
                    )
                   //GreetingText(message = "Happy Birthday SuBin!", from = "From CUTEST LITTLE SISTER")
                }
            }
        }
    }
}


//여러 인수를 어노테이션에 전달가능
//@annotation: kotlin complier에게 알리는 기능
@Preview( //이 함수를 미리보기에 보여줘, 단독으로 쓸 수 없음
    showBackground = true)
@Composable // 이 함수는 UI를 그리는(구성) 함수임
fun BirthdayCardPreview() {
    HappyBirthdayTheme(dynamicColor = false) {
       // GreetingText(message = "Happy Birthday SuBin!", from = "From CUTEST LITTLE SISTER")
        GreetingImage(
            message = "Happy Birthday Bumgyu!",
            from = "From Suyeon")
    }
}
@Composable
fun GreetingText(message: String, from:String, modifier: Modifier = Modifier
    .fillMaxSize()
    .padding(8.dp)){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 26.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }
}
@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    //프로젝트의 R클래스에서 생성된 리소스 ID로 리소스에 액세스 가능
    //R클래스는 android에서 자동으로 생성 되는 클래스로, 프로젝트에 있는 모든 리소스의 ID를 포함한다.
    val image = painterResource(R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
            //talkback은 스크린리더 -> 음성피드백으로 사용자는 화면을 보지 않고 기기 사용 가능
            //이미지는 장식 목적인데 설명이 추가되면 talkback과 쓰기 어려워짐
            //talkback이 image 컴포저블을 건너뛰도록 할 수 있다.

        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}