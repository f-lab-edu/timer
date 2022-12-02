package kr.co.ky.community


data class CommunityDataClass(val title : String? = null,
                              val context : String? = null,
                              val id : String? = null,
                              val uid : String? = null,
                              val nickname : String? = null,
                              val imageUri : String? = null,
                              val timestamp : Long? = null,
                              val likeCount : Int = 0,
                              val like : Map<String,Boolean> = HashMap()){
    data class Comment(val uid : String? = null,
                       val id : String? = null,
                       val comment : String? = null,
                       val timestamp : Long? = null)


}