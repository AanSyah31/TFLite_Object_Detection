package org.tensorflow.lite.examples.detection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import com.jaredrummler.materialspinner.MaterialSpinner
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var camidArray = ArrayList<String>()
        for (i in 0..5) {
            camidArray.add(i.toString())
        }
        val spinner = findViewById<MaterialSpinner>(R.id.spinner)
        var camid = "0"

        spinner.setItems(camidArray)

        spinner.setOnItemSelectedListener { view, position, id, item ->
            camid = item.toString()
        }
        val next = findViewById<MaterialButton>(R.id.next)
        next.setOnClickListener {
            val intent = Intent(this, DetectorActivity::class.java)
            intent.putExtra("cameraid", camid)
            startActivity(intent)
        }
    }
}