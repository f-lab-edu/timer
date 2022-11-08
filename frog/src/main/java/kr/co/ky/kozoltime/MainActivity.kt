package kr.co.ky.kozoltime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import navigation.CommunityFragment
import navigation.DetailViewFragment

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {


    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.action_home -> {
                var detailViewFragment = DetailViewFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_content, detailViewFragment).commit()
                return true
            }
            R.id.job_epilogue -> {
                var communityFragment = CommunityFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_content, communityFragment).commit()
                return true
            }
            R.id.community -> {

                return true
            }
            R.id.find_job -> {
                var alarmFragment = CommunityFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_content, alarmFragment).commit()
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

}
