package com.example.isyaratku.data.model

import com.example.isyaratku.R

object Constant {

    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"


    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val ques1 = Question(1, "Kata apa yang diucapkan pada gambar berikut?", R.raw.kata_bagaimana, "Bagaimana", "Darimana", "Apa", "Siapa", 1)
        questionsList.add(ques1)

        val ques2 = Question(2, "Kata apa yang diucapkan pada gambar berikut?", R.raw.kata_alhamdulillah, "Bagaimana", "Kenapa", "Darimana", "Alhamdulillah", 4)
        questionsList.add(ques2)

        val ques3 = Question(3, "Kata apa yang diucapkan pada gambar berikut?", R.raw.kata_perkenalkan, "Siapa", "Perkenalkan", "Terima Kasih", "Aku", 2)
        questionsList.add(ques3)

        val ques4 = Question(4, "Kata apa yang diucapkan pada gambar berikut?", R.raw.kata_terima_kasih, "Terima Kasih", "Siapa", "Sama-sama", "Bagaimana", 1)
        questionsList.add(ques4)

        val ques5 = Question(5, "Kata apa yang diucapkan pada gambar berikut?", R.raw.kata_nama_kamu_siapa, "Aku", "Siapa", "Nama Kamu Siapa", "Perkenalkan", 3)
        questionsList.add(ques5)

        val ques6 = Question(6, "Kata apa yang diucapkan pada gambar berikut?", R.raw.kata_terima_kasih, "Terima Kasih", "Siapa", "Sama-sama", "Bagaimana", 1)
        questionsList.add(ques6)

        val ques7 = Question(7, "Kata apa yang diucapkan pada gambar berikut?", R.raw.kata_sama_sama, "Siapa", "Bagaimana", "Sama-sama", "Alhamdulillah", 3)
        questionsList.add(ques7)

        return questionsList
    }
}