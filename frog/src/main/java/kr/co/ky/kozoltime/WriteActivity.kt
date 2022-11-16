package kr.co.ky.kozoltime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_write.*

class WriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        write_spinner.adapter = ArrayAdapter.createFromResource(this,R.array.itemList,android.R.layout.simple_spinner_item)
    }
}