package com.murkoto.quizyourcircle.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.murkoto.quizyourcircle.R
import com.murkoto.quizyourcircle.adapter.QuestionFormRecyclerViewAdapter
import com.murkoto.quizyourcircle.databinding.ActivityCreateQuizBinding
import com.murkoto.quizyourcircle.viewmodel.CreateQuizViewModel
import kotlinx.android.synthetic.main.activity_create_quiz.*

class CreateQuizActivity : AppCompatActivity() {

    private lateinit var mAdapter: QuestionFormRecyclerViewAdapter
    private lateinit var mViewModel: CreateQuizViewModel

    private lateinit var binding: ActivityCreateQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@CreateQuizActivity, R.layout.activity_create_quiz)
        mViewModel = ViewModelProvider(this).get(CreateQuizViewModel::class.java)
        binding.mViewModel = mViewModel
        mAdapter = QuestionFormRecyclerViewAdapter(mViewModel.quiz.questions, this@CreateQuizActivity)
        rvQuestions.apply {
            layoutManager = LinearLayoutManager(this@CreateQuizActivity, LinearLayoutManager.VERTICAL, false)
            adapter = mAdapter
        }
        btnAddQuestion.setOnClickListener {
            mAdapter.addQuestion()
        }
        mViewModel.submissionStatusLiveData.observe(this, Observer {success ->
            if (success) {
                finish()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_submit_quiz, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.submitQuiz -> {
                mViewModel.submitQuiz()
            }
        }

        return super.onOptionsItemSelected(item)
    }

}
