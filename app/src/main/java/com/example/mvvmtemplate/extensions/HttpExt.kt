package com.example.mvvmtemplate.extensions

/*
fun Throwable.parseException(): ErrorModel? {
    return when (this) {
        is HttpException -> {
            return try {
                response()?.errorBody()?.string()?.let {
                    Gson().fromJson(it, ErrorModel::class.java)
                }
            } catch (e: Exception) {
                null
            }
        }
        else -> null
    }
}

// todo. backend ile konusalim
fun Throwable.parseLoginException(): LoginInfo? {
    return when (this) {
        is HttpException -> {
            return try {
                response()?.errorBody()?.string()?.let {
                    Gson().fromJson(it, LoginInfo::class.java)
                }
            } catch (e: Exception) {
                null
            }
        }
        else -> null
    }
}*/
