package com.murkoto.quizyourcircle.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.murkoto.quizyourcircle.R
import com.murkoto.quizyourcircle.adapter.QuizRecyclerViewAdapter
import com.murkoto.quizyourcircle.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mViewModel: MainViewModel
    private val mAdapter = QuizRecyclerViewAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setupRecyclerView()
        observeQuiz()
        fabAdd.setOnClickListener {
            val intent = Intent(this@MainActivity, CreateQuizActivity::class.java)
            startActivity(intent)
        }
    }

    private fun observeQuiz() {
        mViewModel.getQuizes().observe(this, Observer { quizes ->
            mAdapter.updateList(quizes)
        })
    }

    private fun setupRecyclerView() {
        rvQuizes.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = mAdapter
        }
    }

}