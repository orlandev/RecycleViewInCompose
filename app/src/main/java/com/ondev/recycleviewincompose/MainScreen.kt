package com.ondev.recycleviewincompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.ondev.recycleviewincompose.data.Person

@Composable
fun MainScreen(navController: NavController, persons: List<Person>) {
    Box(
        modifier = Modifier.fillMaxHeight().fillMaxWidth())
    {
        LazyColumn(modifier = Modifier.padding(8.dp).fillMaxWidth()) {
            items(persons) { currentPerson ->
                PersonCard(currentPerson)
            }
        }
    }
}


@Composable
fun PersonCard(personItem: Person) {
    Card(elevation = 1.dp,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.fillMaxWidth().padding(2.dp).clickable { }) {
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
            Column(
                modifier = Modifier.fillMaxHeight().padding(horizontal = 10.dp),
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

