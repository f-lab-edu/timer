package kr.co.ky.kozoltime

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_job_epilogue.*

class JobEpilogue:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_job_epilogue)

        office_btn.setOnClickListener{
            val intent = Intent(this, Office::class.java)
            startActivity(intent)
        }
    }
}