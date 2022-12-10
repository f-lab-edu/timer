package kr.co.ky.community


data class CommunityDataClass(val title : String? = null,
                              val context : String? = null,
                              val document: String? = null,
                              val id : String? = null,
                              val uid : String? = null,
                              val spinner : String? = null,
                              val nickname : String? = null,
                              val imageUri : String? = null,
                              val singleDate : String? = null,
                              var likeCount : Long? = 0,
                              val like : MutableMap<String,Boolean>? = HashMap()){
    data class Comment(val uid : String? = null,
                       val id : String? = null,
                       val comment : String? = null,
                       val timestamp : Long? = null)


}