package kr.co.ky.community

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object SingleDate {

    @SuppressLint("SimpleDateFormat")
    operator fun invoke(): String {
        return SimpleDateFormat("yyyy.MM.dd_HH:mm:ss").format(Date())
    }
}