package kr.co.ky.kozoltime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kr.co.ky.kozoltime.databinding.ActivityOfficeBinding
import navigation.communityFragment
import navigation.DetailViewFragment
import navigation.FindJobFragment
import navigation.JobEpilogueFragment

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener
{

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
                commitFragment(jobEpilogueFragment)
                return true
            }
            R.id.community -> {
                var communityFragment = communityFragment()
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

        }
    private fun initFragment(){

    }
    private fun commitFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, fragment)
            .commit()
    }
}
