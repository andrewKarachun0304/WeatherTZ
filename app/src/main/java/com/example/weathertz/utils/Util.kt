package com.example.weathertz.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


fun launchIO(task: suspend () -> Unit) {
    CoroutineScope(Dispatchers.IO).launch {
        task()
    }
}

fun launchUI(task: suspend () -> Unit) {
    CoroutineScope(Dispatchers.Main).launch {
        task()
    }
}

suspend fun <R> launchForResult(task: suspend () -> R): R? {
    return withContext(CoroutineScope(Dispatchers.IO).coroutineContext){
        task()
    }
}