package com.example.mymovies.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun String.getFullImageUrl() = "https://image.tmdb.org/t/p/w500$this"

fun <T> CoroutineScope.launchSuspendFun(
    blockToRun: suspend CoroutineScope.() -> T,
    onLoading: ((Boolean) -> Unit)? = null,
    onSuccess: ((T) -> Unit)? = null,
    onError: ((Throwable) -> Unit)? = null,
) {
    launch {
        onLoading?.invoke(true)
        try {
            val result = blockToRun()
            onLoading?.invoke(false)
            onSuccess?.invoke(result)
        } catch (ex: Exception) {
            onLoading?.invoke(false)
            onError?.invoke(Throwable())
        }
    }
}