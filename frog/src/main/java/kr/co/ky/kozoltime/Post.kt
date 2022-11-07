package kr.co.ky.kozoltime

data class Post( val context:String?,val id: String?, val title:String?){
    constructor(): this("개구리","개구리","개구리")
}