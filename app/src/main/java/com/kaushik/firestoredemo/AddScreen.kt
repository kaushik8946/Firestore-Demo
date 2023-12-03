package com.kaushik.firestoredemo

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun AddScreen(db: FirebaseFirestore) {
    val context = LocalContext.current
    var name by remember { mutableStateOf("") }
    var job by remember { mutableStateOf("") }
    var street by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        OutlinedTextField(
            value = name, onValueChange = { name = it },
            label = { Text(text = "enter name") }
        )
        OutlinedTextField(
            value = job, onValueChange = { job = it },
            label = { Text(text = "enter job") }
        )
        OutlinedTextField(
            value = street, onValueChange = { street = it },
            label = { Text(text = "enter street") }
        )
        OutlinedTextField(
            value = city, onValueChange = { city = it },
            label = { Text(text = "enter city") }
        )
        Button(
            onClick = {
                if ("" in listOf(name.trim(), job.trim(), street.trim(), city.trim())) {
                    Toast.makeText(context, "some details are empty", Toast.LENGTH_SHORT).show()
                } else {
                    saveEmployeeData(
                        db, Employee(
                            name = name, job = job, address = Address(
                                street, city
                            )
                        )
                    )
                    name = ""
                    job = ""
                    street = ""
                    city = ""
                }
            }
        ) {
            Text(text = "Submit")
        }
    }
}