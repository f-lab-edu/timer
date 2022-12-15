package kr.co.ky.kozoltime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import kr.co.ky.kozoltime.databinding.ActivityMainBinding
import navigation.CommunityFragment
import navigation.MyPage
import navigation.FindJobFragment
import navigation.JobEpilogueFragment

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
        private lateinit var binding: ActivityMainBinding
        val jobEpilogueFragment = JobEpilogueFragment()
        override fun onNavigationItemSelected(p0: MenuItem): Boolean {

            when (p0.itemId) {
                R.id.action_home -> {
                    var detailViewFragment = MyPage()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, detailViewFragment).commit()
                    return true
                }
                R.id.job_epilogue -> {
                    var jobEpilogueFragment = JobEpilogueFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, jobEpilogueFragment).commit()
                    return true
                }
                R.id.community -> {
                    var communityFragment = CommunityFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, communityFragment).commit()
                    return true
                }
                R.id.find_job -> {
                    var findJobFragment = FindJobFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, findJobFragment).commit()
                    return true
                }

            }
            return false
        }


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            val view = binding.root
            setContentView(view)
            binding.bottomNavigation.setOnItemSelectedListener(this)

            supportFragmentManager.beginTransaction().replace(R.id.frame,jobEpilogueFragment).commit()

        }


}
