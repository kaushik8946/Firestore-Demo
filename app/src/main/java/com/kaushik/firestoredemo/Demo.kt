package com.kaushik.firestoredemo

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

object Demo {
    @JvmStatic
    fun main(args: Array<String>) {
        val db = FirebaseFirestore.getInstance()
        val emp = Employee(
            "c3",
            "kaushik",
            "coder",
            Address(
                "kompally",
                "hyderabad"
            )
        )
        db.collection("employees").document(emp.id)
            .set(emp)
            .addOnCompleteListener {
                // This will execute when the operation is successful
                Log.d("Firestore", "Data uploaded successfully")
            }
            .addOnFailureListener { err ->
                // This will execute when there is an error
                Log.e("Firestore", "Error: ${err.message}")
            }
    }
}