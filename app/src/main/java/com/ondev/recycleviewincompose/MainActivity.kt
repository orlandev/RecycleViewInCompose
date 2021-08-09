package com.ondev.recycleviewincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.ondev.recycleviewincompose.data.DataProvider
import com.ondev.recycleviewincompose.data.Person
import com.ondev.recycleviewincompose.ui.theme.RecycleViewInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecycleViewInComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxHeight().fillMaxHeight()) {
                    App()
                }
            }
        }
    }
}

val persons = DataProvider().provide(100)

@Composable
fun App() {
    Box(
        modifier = Modifier.fillMaxHeight().fillMaxWidth())
    {
        PersonList()
    }
}


@Composable
fun PersonList() {
    LazyColumn(modifier = Modifier.padding(8.dp).fillMaxWidth()) {
        items(persons) { currentPerson ->
            PersonCard(currentPerson)
        }
    }
}

@Composable
fun PersonCard(personItem: Person) {
    Card(elevation = 2.dp,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.fillMaxWidth().padding(2.dp)) {
        Row(modifier = Modifier.fillMaxWidth().height(80.dp).padding(8.dp)) {
            Image(
                painter = rememberImagePainter(
                    data = personItem.getAvatarUrl(),
                    builder = {
                        transformations(CircleCropTransformation())
                        crossfade(true)
                        placeholder(R.drawable.jcompose_icon)
                    }
                ),
                contentDescription = null,
                modifier = Modifier.size(60.dp)
                    .border(2.dp, Color.Gray, CircleShape)
            )
            Column(Modifier.fillMaxHeight().padding(horizontal = 10.dp),
                verticalArrangement = Arrangement.Center
            )
            {
                Text(
                    text = personItem.name
                )
                Text(
                    text = personItem.workplace
                )
            }
        }
    }
}