package kr.co.ky.kozoltime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_office.*
import kr.co.ky.kozoltime.databinding.ActivityOfficeBinding

class Office : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_office)

        fabWrite.setOnClickListener {
            val intent = Intent(this, Write::class.java)
            startActivity(intent)
        }
        office_rv.adapter = OfficeAdapter()
        office_rv.layoutManager = LinearLayoutManager(this)
    }



}
