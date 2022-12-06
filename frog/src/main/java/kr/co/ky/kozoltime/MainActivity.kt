package kr.co.ky.kozoltime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import navigation.CommunityFragment
import navigation.DetailViewFragment
import navigation.FindJobFragment
import navigation.JobEpilogueFragment
import android.Manifest
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

        val jobEpilogueFragment = JobEpilogueFragment()
        override fun onNavigationItemSelected(p0: MenuItem): Boolean {

            when (p0.itemId) {
                R.id.action_home -> {
                    var detailViewFragment = DetailViewFragment()
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
            setContentView(R.layout.activity_main)
            bottom_navigation.setOnNavigationItemSelectedListener(this)

            supportFragmentManager.beginTransaction().replace(R.id.frame,jobEpilogueFragment).commit()

        }


}
