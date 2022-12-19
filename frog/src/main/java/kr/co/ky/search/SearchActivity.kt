package kr.co.ky.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import data.FirebaseData
import kr.co.ky.community.CommunityAdapter
import kr.co.ky.community.CommunityDataClass
import kr.co.ky.kozoltime.R
import kr.co.ky.kozoltime.databinding.ActivitySearchBinding
import kr.co.ky.like.Like

class SearchActivity : AppCompatActivity() {

    private val firebaseData = FirebaseData()
    private val firestore = FirebaseFirestore.getInstance()
    private lateinit var binding: ActivitySearchBinding
    lateinit var spinnerForSearch: String
    private var searchList: MutableList<CommunityDataClass> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.spinnerForSearch.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.searchList,
            android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        binding.spinnerForSearch.prompt = getString(R.string.job_select)

        binding.spinnerForSearch.setOnItemSelectedListener(object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> {
                        spinnerForSearch = getString(R.string.communityKey)
                    }
                    1 -> {
                        spinnerForSearch = getString(R.string.kozoltimeKey)
                    }
                    2 -> {
                        spinnerForSearch = getString(R.string.findJobKey)
                    }

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                spinnerForSearch = getString(R.string.ssul)
            }
        })
        binding.searchButton.setOnClickListener {
            firestore.collection(spinnerForSearch)
                .whereLessThanOrEqualTo("context",binding.searchEdit.text.toString())
                .get()
                .addOnCompleteListener {
                    searchList.clear()
                    if (it.isSuccessful) {
                        for (snapshot in it.result.documents ) {
                            val search = snapshot.toObject(CommunityDataClass::class.java)
                            searchList.add(search!!)
                        }
                    }
                }
                        val like = Like()
                        binding.searchRecyclerview.adapter =
                            CommunityAdapter(searchList, spinnerForSearch, like)
                        binding.searchRecyclerview.layoutManager = LinearLayoutManager(this)
                        (binding.searchRecyclerview.adapter as CommunityAdapter).notifyDataSetChanged()


                    }
                }
            fun failToSearch(){
                Toast.makeText(this,"검색어가 없습니다.",Toast.LENGTH_LONG).show()
            }
        }


