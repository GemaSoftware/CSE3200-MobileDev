package com.agrongemajli.lab4_recycleview.ui.main

import androidx.lifecycle.ViewModel

class TweetViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    val tweets = arrayOf(
        "Just had a great cup of coffee ☕️",
        "I'm loving this weather today ☀️",
        "Can't wait to see my friends tonight 🎉"
    )

    val imageURLs = arrayOf(
        "https://th.bing.com/th/id/OIP.zjyVDbYqJvulp2aNvUL-ggHaE7?pid=ImgDet&rs=1",
        "https://cdn.cnn.com/cnnnext/dam/assets/161230183526-23-weather-in-focus-december-super-tease.jpg",
        "https://th.bing.com/th/id/OIP.Q_RqrJ4AKS5bbJyMN58CzgHaDF?w=302&h=145&c=7&r=0&o=5&dpr=2&pid=1.7"
    )



}