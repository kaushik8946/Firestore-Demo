package com.kaushik.firestoredemo

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

fun saveEmployeeData(db: FirebaseFirestore, employee: Employee) {
    val docRef = db.collection("employees").document()
    val employeeId = docRef.id
    employee.id = employeeId
    db.collection("employees").document(employeeId)
        .set(employee)
        .addOnCompleteListener {
            // This will execute when the operation is successful
            Log.d("Firestore", "Data uploaded successfully")
        }
        .addOnFailureListener { err ->
            // This will execute when there is an error
            Log.e("Firestore", "Error: ${err.message}")
        }
}

fun getAllEmployees(db: FirebaseFirestore) {
    val db = FirebaseFirestore.getInstance()
    val collectionRef = db.collection("employees")

}