package kr.co.ky.kozoltime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kr.co.ky.kozoltime.databinding.ActivityOfficeBinding
import navigation.communityFragment
import navigation.DetailViewFragment

class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

          office_btn.setOnClickListener{
                val intent = Intent(this, Office::class.java)
                startActivity(intent)
            }
        }

}
