package kr.co.ky.kozoltime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import kr.co.ky.detail.DetailPage
import kr.co.ky.kozoltime.databinding.ActivityMainBinding
import kr.co.ky.nicknamePackage.NicknameViewModel
import navigation.CommunityFragment
import navigation.MyPage
import navigation.FindJobFragment
import navigation.JobEpilogueFragment

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
        private lateinit var binding: ActivityMainBinding
        val jobEpilogueFragment = JobEpilogueFragment()
        private lateinit var viewModel: NicknameViewModel
        override fun onNavigationItemSelected(p0: MenuItem): Boolean {

            when (p0.itemId) {
                R.id.action_home -> {
                    val detailViewFragment = MyPage()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, detailViewFragment).commit()
                    return true
                }
                R.id.job_epilogue -> {
                    val jobEpilogueFragment = JobEpilogueFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, jobEpilogueFragment).commit()
                    return true
                }
                R.id.community -> {
                    val communityFragment = CommunityFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, communityFragment).commit()
                    return true
                }
                R.id.find_job -> {
                    val findJobFragment = FindJobFragment()
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

            val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()

            fragmentTransaction.replace(R.id.frame, jobEpilogueFragment).commit()

        }
}
