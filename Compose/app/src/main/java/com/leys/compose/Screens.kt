package com.leys.compose

sealed class Screens(val screen: String){
    //we should initialize the screens using sealed class
    data object Home: Screens("home")
    data object Profile: Screens("profile")
    data object Settings: Screens("settings")
    data object Notification: Screens("notification")
    data object Post: Screens("post")
}