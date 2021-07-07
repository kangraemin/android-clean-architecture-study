package com.example.datalayer.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

class NetworkUtil(private val context: Context) {

    enum class NetworkStatus {
        WIFI,
        DATA,
        NOT_CONNECTED
    }

    private fun getConnectivityStatus(): NetworkStatus {
        var result =
            NetworkStatus.NOT_CONNECTED
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkCapabilities =
                connectivityManager.activeNetwork ?: return NetworkStatus.NOT_CONNECTED
            val actNw =
                connectivityManager.getNetworkCapabilities(networkCapabilities)
                    ?: return NetworkStatus.NOT_CONNECTED
            result = when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> NetworkStatus.WIFI
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> NetworkStatus.DATA
                else -> NetworkStatus.NOT_CONNECTED
            }
        } else {
            connectivityManager.run {
                connectivityManager.activeNetworkInfo?.run {
                    result = when (type) {
                        ConnectivityManager.TYPE_WIFI -> NetworkStatus.WIFI
                        ConnectivityManager.TYPE_MOBILE -> NetworkStatus.DATA
                        else -> NetworkStatus.NOT_CONNECTED
                    }
                }
            }
        }
        return result
    }

    fun isNetworkConnected(): Boolean {
        return getConnectivityStatus() != NetworkStatus.NOT_CONNECTED
    }
}