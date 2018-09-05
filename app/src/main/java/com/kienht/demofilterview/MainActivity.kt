package com.kienht.demofilterview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kienht.demofilterview.adapter.FilterAdapter
import com.kienht.demofilterview.model.FilterEntity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author kienht
 * @since 29/08/2018
 */

class MainActivity : AppCompatActivity() {

    private lateinit var mFilterAdapter: FilterAdapter

    private val jsonPath = "sampledata/tags.json"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = assets.open(jsonPath).bufferedReader(Charsets.UTF_8).use {
            it.readText()
        }

        val list: List<FilterEntity> = Gson().fromJson(data, object : TypeToken<List<FilterEntity>>() {}.type)

        mFilterAdapter = FilterAdapter(list)

        list_filter.run {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            itemAnimator = null
            setHasFixedSize(true)
            adapter = mFilterAdapter
        }

    }

}
