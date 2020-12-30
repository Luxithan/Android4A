package com.example.android4a.presentation.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android4a.R
import com.example.android4a.data.local.models.Card
import com.example.android4a.domain.usecase.ApiUseCase
import org.koin.android.ext.android.inject


  class ApplicationActivity : AppCompatActivity() {
    private val applicationViewModel: ApplicationViewModel by inject()
    private val view:ApplicationActivity = this
    lateinit var recyclerView: RecyclerView
    lateinit var mAdapter: ListAdapter
    lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application)
 //       ApplicationViewModel(apiUseCase = ).onStart()
        val apiUseCase: ApiUseCase? =null

        applicationViewModel.onStart(view,apiUseCase)
    }

    fun showList(cardList: List<Card?>?) {
        recyclerView = findViewById<View>(R.id.recycler_view) as RecyclerView
        recyclerView.setHasFixedSize(true)
        // use a linear layout manager
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        // define an adapter
        mAdapter = ListAdapter(cardList)
        recyclerView.adapter = mAdapter
    }

}