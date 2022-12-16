package kr.co.ky.search

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import data.DataListener
import data.FirebaseData
import kr.co.ky.community.CommunityAdapter
import kr.co.ky.community.CommunityDataClass
import kr.co.ky.kozoltime.R
import kr.co.ky.kozoltime.databinding.ActivitySearchBinding
import kr.co.ky.kozoltime.databinding.OfficeCardviewBinding
import kr.co.ky.like.Like

class SearchActivity : AppCompatActivity() {

    private val firebaseData = FirebaseData()
    private val firestore = FirebaseFirestore.getInstance()
    private lateinit var binding: ActivitySearchBinding
    lateinit var searchSpinner: String
    private var searchList: MutableList<CommunityDataClass> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchSpinner.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.searchList,
            android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.searchSpinner.adapter = adapter
        }
        binding.searchSpinner.prompt = getString(R.string.job_select)

        binding.searchSpinner.setOnItemSelectedListener(object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> {
                        searchSpinner = getString(R.string.communityKey)
                    }
                    1 -> {
                        searchSpinner = getString(R.string.kozoltimeKey)
                    }
                    2 -> {
                        searchSpinner = getString(R.string.findJobKey)
                    }

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                searchSpinner = getString(R.string.ssul)
            }
        })
        binding.searchButton.setOnClickListener {
            firestore.collection(searchSpinner)
                .get()
                .addOnCompleteListener {
                    searchList.clear()
                    if (it.isSuccessful) {
                        for (snapshot in it.result!!.documents) {
                            if (snapshot.getString("context")!!
                                    .contains(binding.searchEdit.text.toString(), false)
                            ) {
                                val search = snapshot.toObject(CommunityDataClass::class.java)
                                searchList.add(search!!)
                            }
                        }
                        val like = Like()
                        binding.searchRecyclerview.adapter =
                            CommunityAdapter(searchList, searchSpinner, like)
                        binding.searchRecyclerview.layoutManager = LinearLayoutManager(this)
                        (binding.searchRecyclerview.adapter as CommunityAdapter).notifyDataSetChanged()


                    }
                }
        }
    }
}
