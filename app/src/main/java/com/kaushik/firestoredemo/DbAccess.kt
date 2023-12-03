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
    val docRef = db.collection("employees")
    docRef
        .get()
        .addOnSuccessListener { documents ->
            for (document in documents) {
                if (document != null) {
                    val emp = document.toObject(Employee::class.java)
                    Log.d("Firestore", emp.toString())
                }
            }
        }
        .addOnFailureListener { err ->
            Log.e("Firestore", "Error: ${err.message}")
        }
}