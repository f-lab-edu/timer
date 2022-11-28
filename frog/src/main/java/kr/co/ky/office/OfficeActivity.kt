package kr.co.ky.office

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_office.*
import kr.co.ky.kozoltime.R
import kr.co.ky.kozoltime.WriteActivity

class OfficeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_office)

        fabWrite.setOnClickListener {
            val intent = Intent(this, WriteActivity::class.java)
            startActivity(intent)
        }

        office_rv.adapter = OfficeAdapter()
        office_rv.layoutManager = LinearLayoutManager(this)


    }



}
