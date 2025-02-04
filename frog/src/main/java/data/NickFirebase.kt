package data

import android.util.Log
import androidx.lifecycle.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kr.co.ky.firestoreKey.FirestoreKey
import kotlinx.coroutines.*
import kr.co.ky.nicknamePackage.NickDataClass

class NickFirebase {

    fun sendNickFirebase(nickCallback: NickCallback) {
        val fbAuth = FirestoreKey.auth
        val database = Firebase.firestore
        val email = fbAuth.currentUser?.email

                    val firebaseCollection = database.collection("nickname")
                    if (email != null) {
                        firebaseCollection.document(email).addSnapshotListener { snapshot, e ->
                            if (e != null) {
                                Log.w("닉네임 파이어 베이스", "Listen failed", e)
                            }
                            if (snapshot != null && snapshot.exists()) {
                                        val item =
                                            NickDataClass(nickname = snapshot["nickname"] as? String)
                                        nickCallback.setNickTextView(item)
                            }
                        }
                    } else {
                        Log.w("이메일 없음", "email null")
                    }
            }
        }

