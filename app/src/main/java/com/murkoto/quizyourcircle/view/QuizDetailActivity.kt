package com.murkoto.quizyourcircle.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.murkoto.quizyourcircle.R
import com.murkoto.quizyourcircle.viewmodel.QuizDetailViewModel

class QuizDetailActivity : AppCompatActivity() {

    private lateinit var mViewModel: QuizDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_detail)
        mViewModel = ViewModelProvider(this).get(QuizDetailViewModel::class.java)
        intent.getLongExtra("hai", -1).let {id ->
            mViewModel.getQuiestions(id).observe(this, Observer {
                Toast.makeText(this, "dapat", Toast.LENGTH_SHORT).show()
            })
        }
    }
}