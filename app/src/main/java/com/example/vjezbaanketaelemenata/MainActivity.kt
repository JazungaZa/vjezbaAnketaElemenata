package com.example.vjezbaanketaelemenata

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var cat : CheckBox
    lateinit var dog : CheckBox
    lateinit var male : RadioButton
    lateinit var female : RadioButton
    lateinit var spinner: Spinner
    lateinit var send : Button
    lateinit var result : TextView
    lateinit var a : String
    lateinit var toggleButton: ToggleButton
    lateinit var img : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        spinner = findViewById(R.id.spinner)
        result = findViewById(R.id.result)
        male = findViewById(R.id.male)
        female = findViewById(R.id.female)
        dog = findViewById(R.id.dog)
        cat = findViewById(R.id.cat)
        send = findViewById(R.id.send)
        toggleButton = findViewById(R.id.toggleButton)
        img = findViewById(R.id.image)
        spinner.onItemSelectedListener = this

        var arrayAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.countries,
            android.R.layout.simple_spinner_item
        )
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = arrayAdapter

        var b:String=result.text.toString()
        var c:String=""
        cat.setOnClickListener {
            if (cat.isChecked && dog.isChecked){
                result.text = a + " cat and dog"
                c=result.text.toString()
            }
            else if (cat.isChecked){
                result.text = a + " cat"
                c=result.text.toString()
            }
            else if (dog.isChecked){
                result.text = a + " dog"
                c=result.text.toString()
            }
            else{
                result.text = a
                c=result.text.toString()
            }
        }
        dog.setOnClickListener {
            if (cat.isChecked && dog.isChecked){
                result.text = a + " dog and cat"
                c=result.text.toString()
            }
            else if (dog.isChecked){
                result.text = a + " dog"
                c=result.text.toString()
            }
            else if(cat.isChecked){
                result.text = a + " cat"
                c=result.text.toString()
            }
            else{
                result.text = a
                c=result.text.toString()
            }
        }

        send.setOnClickListener {
            if(male.isChecked){
                result.text=c + " dad."
            }
            else if(female.isChecked){
                result.text=c + " mom."
            }
        }
        toggleButton.setOnCheckedChangeListener { compoundButton, isChecked ->
            if(isChecked){
                img.visibility = View.INVISIBLE
            }
            else{
                img.visibility = View.VISIBLE
            }
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        result.text = parent!!.getItemAtPosition(position).toString()
        a=result.text.toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
}