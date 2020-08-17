package com.murkoto.quizyourcircle.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.murkoto.quizyourcircle.R
import com.murkoto.quizyourcircle.databinding.ActivityQuizDetailBinding
import com.murkoto.quizyourcircle.viewmodel.QuizDetailViewModel

class QuizDetailActivity : AppCompatActivity() {

    private lateinit var mViewModel: QuizDetailViewModel
    private lateinit var binding: ActivityQuizDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_quiz_detail)
        mViewModel = ViewModelProvider(this).get(QuizDetailViewModel::class.java)
        intent.getStringExtra("hiu")?.let {title ->
            supportActionBar?.title = title
        }
        val quizId = intent.getLongExtra("hai", -1)
        mViewModel.getSubmissions(quizId).observe(this, Observer { submissions ->
            binding.isEmpty = submissions.isEmpty()
        })
        binding.btnTakeQuiz.setOnClickListener {
            val intent = Intent(this, FillQuizActivity::class.java)
            intent.putExtra(FillQuizActivity.QUIZ_ID_EXTRA, quizId)
            startActivity(intent)
        }
    }
}