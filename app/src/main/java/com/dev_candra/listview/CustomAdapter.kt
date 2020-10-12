package com.dev_candra.listview

import android.content.Context
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text
import java.security.spec.RSAOtherPrimeInfo

// Base aapter digunakan untuk membuat adapter yang lebih kompleks dan custom adapter
class CustomAdapter internal constructor(private val context: Context): BaseAdapter(){
    // baris kdoe ini digunakan untuk menampung data yang dikirim dari activity dan digunakan
    // sebagai sumber data yang dimasukkan kedalam viewHolder
    internal var hereos1 = arrayListOf<Hero>()

    // Untuk memanggil layout item xml yang sudah dibuat dan melakukan proses manipulasi setiap
    // komponennya seperti textview dan imageview melalui kelas viewholder
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_item_one,parent,false)
        }
        val viewOne = ViewHolder(view as View)
        val hero = getItem(position) as Hero
        viewOne.bind(hero)
        return view
    }

    // baris kode ini digunakan untuk mengetahui berapa banyak item yang akan ditampilkan
    override fun getCount(): Int = hereos1.size

    override fun getItem(position: Int): Any = hereos1[position]

    override fun getItemId(position: Int): Long = position.toLong()

    class ViewHolder internal constructor(view : View){

        private val teksName : TextView = view.findViewById(R.id.textNama)
        private val teksDeskripsi : TextView = view.findViewById(R.id.teksDeskripsi)
        private val imgPhoto : ImageView = view.findViewById(R.id.imgPhoto)

        internal fun bind(hero : Hero){
            teksName.text = hero.name
            teksDeskripsi.text = hero.description
            imgPhoto.setImageResource(hero.photo)
        }

    }

}