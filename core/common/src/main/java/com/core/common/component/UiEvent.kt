package com.core.common.component

sealed class UiEvent<T>(var data:T?=null) {
    class Loading<T>:UiEvent<T>()
    class Success<T>(data: T?):UiEvent<T>(data = data)
    class Error<T>():UiEvent<T>()
}