package data

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import kr.co.ky.firestoreKey.FirestoreKey
import kr.co.ky.nicknamePackage.NickDataClass
import kr.co.ky.nicknamePackage.NicknameViewModel
import kotlinx.coroutines.*

class NickFirebase {

    fun sendNickFirebase(nickCallback: NickCallback) {
        val fbAuth = FirestoreKey.auth
        val database = Firebase.firestore
        val email = fbAuth.currentUser?.email
        val mutableData = MutableLiveData<NickDataClass>()

                    val firebaseCollection = database.collection("nickname")
                    if (email != null) {
                        firebaseCollection.document(email).addSnapshotListener { snapshot, e ->
                            if (e != null) {
                                Log.w("닉네임 파이어 베이스", "Listen failed", e)
                            }
                            if (snapshot != null && snapshot.exists()) {
                                runBlocking {
                                    async {
                                        val item =
                                            NickDataClass(nickname = snapshot["nickname"] as? String)
                                        mutableData.value = item
                                    }.await()
                                }
                                nickCallback.setNickTextView(mutableData)

                            }
                        }
                    } else {
                        Log.w("이메일 없음", "email null")
                    }
            }
        }

