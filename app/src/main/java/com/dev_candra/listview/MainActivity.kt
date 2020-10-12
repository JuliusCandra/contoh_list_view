package com.dev_candra.listview

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    // membuat sebuah isi adapter sederhana
//    private var dataName1 = arrayOf("Candra Julius Sinaga","bandal","ganteng","Jelek")

    private lateinit var dataName : Array<String>
    private lateinit var dataDeskripsi : Array<String>
    private lateinit var imgPhoto : TypedArray
    private lateinit var customAdapter: CustomAdapter
    private var heroes = arrayListOf<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // digunakan untuk membuat adapter sederhana
//        val adapter = ArrayAdapter<String>(this@MainActivity,android.R.layout.simple_list_item_1,android.R.id.text1,dataName1)
        val list : ListView = findViewById(R.id.lv_list)
        customAdapter = CustomAdapter(this)
        list.adapter = customAdapter
        list.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this,heroes[position].name,Toast.LENGTH_SHORT).show()
        }
        prepare()
        addItem()
        actionBar()
    }

    // function ini dunakan untuk menginiasi setiap data
    private fun prepare(){
        dataName = resources.getStringArray(R.array.data_name)
        dataDeskripsi = resources.getStringArray(R.array.data_description)
        imgPhoto = resources.obtainTypedArray(R.array.data_photo)
    }

    // function ini digunakan untuk memasukkan data data ke arraylist supaya dapat diproses oleh adapter
    private fun addItem(){
        /*
        Membuat perulangan dengan menggunakan model untuk setter setiap data
        lalu heroes.add(hero) untuk memasukkan ke arraylist, lalu memanggil setter yang berada
        di adapter dan memasukkan arraylist heroes sebagai argumen
         */
        for (position in dataName.indices){
            val hero = Hero(
                imgPhoto.getResourceId(position,-1),
                dataName[position],
                dataDeskripsi[position]
            )
            // bari kode ini digunakan untuk memasukkan data ke arraylist
            heroes.add(hero)
        }

        customAdapter.hereos1 = heroes
    }

    private fun actionBar(){
        if (supportActionBar != null){
            supportActionBar!!.title = "Candra Julius Sinaga"
            supportActionBar!!.subtitle = "List View"
        }
    }

    /*
    Unit Testing
    Log.e -> untuk log error
    Log.d -> untuk log warning
    log.i -> untuk log information
    log.d -> untuk log debug
    log.v -> untuk log verbose
     */
}