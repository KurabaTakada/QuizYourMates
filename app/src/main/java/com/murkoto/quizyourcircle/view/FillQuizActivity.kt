package com.murkoto.quizyourcircle.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.murkoto.quizyourcircle.R
import com.murkoto.quizyourcircle.adapter.QuestionAnswerRecyclerViewAdapter
import com.murkoto.quizyourcircle.databinding.ActivityFillQuizBinding
import com.murkoto.quizyourcircle.viewmodel.FillQuizViewModel

class FillQuizActivity : AppCompatActivity() {

    lateinit var binding: ActivityFillQuizBinding
    lateinit var mViewModel: FillQuizViewModel

    companion object {
        const val QUIZ_ID_EXTRA = "qz_d_xtr"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_fill_quiz)
        mViewModel = ViewModelProvider(this).get(FillQuizViewModel::class.java)
        val quizId = intent.getLongExtra(QUIZ_ID_EXTRA, -1)
        mViewModel.getQuizWithQuestions(quizId).observe(this, Observer { questions ->
            binding.rvQuestionsFill.apply {
                layoutManager = LinearLayoutManager(this@FillQuizActivity, LinearLayoutManager.VERTICAL, false)
                adapter = QuestionAnswerRecyclerViewAdapter(questions)
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
            }
        }

        return super.onOptionsItemSelected(item)
    }

}