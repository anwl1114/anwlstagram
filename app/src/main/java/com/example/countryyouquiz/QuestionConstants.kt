package com.example.countryyouquiz

import android.content.Context

//class QuestionConstants (private val context: MainActivity, private val dataList: ArrayList<Question>)

object constants {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(1, "What country does this flag belong to?", R.drawable.argentina, "Argentina",
            "Australia", "Armenia", "Austria", 1 )
        questionsList.add(que1)

        val que2 = Question(
            2,
            "What country does this flag belong to?",
            R.drawable.australia,
            "Australia",
            "Tuvalu",
            "India",
            "Hungary",
            1
        )
        questionsList.add(que2)

        val que3 = Question(
            3, "What country does this flag belong to?", R.drawable.ecuador, "New zealand", "Iran",
            "Kuwait", "Ecuador", 4
        )
        questionsList.add(que3)

        val que4 = Question(
            4, "What country does this flag belong to?", R.drawable.belgium, "palestine", "Jordan",
            "Belgium", "Sudan", 3
        )
        questionsList.add(que4)

        val que5 = Question(
            5, "What country does this flag belong to?", R.drawable.india, "Ireland", "India",
            "Germany", "Dehmark", 2
        )
        questionsList.add(que5)

        val que6 = Question(
            6, "What country does this flag belong to?", R.drawable.indonesia, "Greece", "Georgia",
            "indonesia", "None of these", 3
        )
        questionsList.add(que6)

        val que7 = Question(
            7, "What country does this flag belong to?", R.drawable.kenya, "Japan", "Kenya",
            "Fiji", "Gabon", 2
        )
        questionsList.add(que7)

        val que8 = Question(
            8, "What country does this flag belong to?", R.drawable.angola, "Nigeria", "China",
            "France", "Angola", 4
        )
        questionsList.add(que8)

        val que9 = Question(
            9,
            "What country does this flag belong to?",
            R.drawable.somalia,
            "somalia",
            "the United Arab Emirates",
            "Switzerland",
            "Chile",
            1
        )
        questionsList.add(que9)

        val que10 = Question(
            10,
            "What country does this flag belong to?",
            R.drawable.nigeria,
            "Dominican Republic.",
            "Jeju",
            "Nigeria",
            "Taiwan",
            3
        )
        questionsList.add(que10)
        return questionsList

    }
}