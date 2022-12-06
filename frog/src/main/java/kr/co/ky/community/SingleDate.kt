package kr.co.ky.community

import java.text.SimpleDateFormat
import java.util.*

object SingleDate {

    operator fun invoke(): Any {
        return SimpleDateFormat("yyyymmdd_HHmmss").format(Date())
    }
}