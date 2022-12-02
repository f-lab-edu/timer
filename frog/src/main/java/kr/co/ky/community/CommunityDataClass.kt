package kr.co.ky.community


data class CommunityDataClass(var title : String? = null,
                              var context : String? = null,
                              var id : String? = null,
                              var uid : String? = null,
                              var nickname : String? = null,
                              var imageUri : String? = null,
                              var timestamp : Long? = null,
                              var likeCount : Int = 0,
                              var like : Map<String,Boolean> = HashMap()){
    data class Comment(var uid : String? = null,
                       var id : String? = null,
                       var comment : String? = null,
                       var timestamp : Long? = null)

}