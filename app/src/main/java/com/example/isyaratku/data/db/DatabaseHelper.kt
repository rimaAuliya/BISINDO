//package com.example.isyaratku.data.db
//
//import android.content.ContentValues
//import android.content.Context
//import android.database.sqlite.SQLiteDatabase
//import android.database.sqlite.SQLiteOpenHelper
//import com.example.isyaratku.R
//import com.example.isyaratku.data.db.QuizContract.QuestionTable.Companion.TABLE_NAME
//
//internal class DatabaseHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
//
//    private lateinit var db : SQLiteDatabase
//    companion object {
//        private const val DATABASE_NAME = "GoQuiz"
//        const val DATABASE_VERSION = 1
//
//        private const val SQL_CREATE_TABLE_NOTE = "CREATE TABLE $TABLE_NAME" +
//                " (${QuizContract.QuestionTable._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
//                " ${QuizContract.QuestionTable.COLUMN_QUESTION} TEXT NOT NULL," +
//                " ${QuizContract.QuestionTable.COLUMN_IMAGE} INTEGER NOT NULL," +
//                " ${QuizContract.QuestionTable.COLUMN_OPTION1} TEXT NOT NULL," +
//                " ${QuizContract.QuestionTable.COLUMN_OPTION2} TEXT NOT NULL," +
//                " ${QuizContract.QuestionTable.COLUMN_OPTION3} TEXT NOT NULL," +
//                " ${QuizContract.QuestionTable.COLUMN_OPTION4} TEXT NOT NULL," +
//                " ${QuizContract.QuestionTable.COLUMN_ANSWER} INTEGER NOT NULL)"
//    }
//
//    override fun onCreate(db: SQLiteDatabase) {
//        this.db = db
//        db.execSQL(SQL_CREATE_TABLE_NOTE)
//        fillQuestionsTable()
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
//        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
//        onCreate(db)
//    }
//
//    private fun addQuestion(questions: Questions) {
////        val cv = ContentValues().apply {
////            put(COLUMN_QUESTION, questions.questions)
////            put(COLUMN_IMAGE, questions.imgQuestions)
////            put(COLUMN_OPTION1, questions.options1)
////            put(COLUMN_OPTION2, questions.options2)
////            put(COLUMN_OPTION3, questions.options3)
////            put(COLUMN_OPTION4, questions.options4)
////            put(COLUMN_ANSWER, questions.answer)
////        }
//        val cv = ContentValues()
//        cv.put(QuizContract.QuestionTable.COLUMN_QUESTION, questions.getQuestions())
//        cv.put(QuizContract.QuestionTable.COLUMN_QUESTION, questions.getImageQuestions())
//        cv.put(QuizContract.QuestionTable.COLUMN_QUESTION, questions.getOptions1())
//        cv.put(QuizContract.QuestionTable.COLUMN_QUESTION, questions.getOptions2())
//        cv.put(QuizContract.QuestionTable.COLUMN_QUESTION, questions.getOptions3())
//        cv.put(QuizContract.QuestionTable.COLUMN_QUESTION, questions.getOptions4())
//        cv.put(QuizContract.QuestionTable.COLUMN_QUESTION, questions.getAnswer())
//
//        db.insert(TABLE_NAME, null, cv)
//    }
//
//    private fun fillQuestionsTable() {
//        val q1 = Questions("Kata apa yang diucapkan pada video?", R.raw.kata_bagaimana, "Apakah", "Apa", "Bagaimana", "Alhamdulillah", 3)
//        addQuestion(q1)
//        val q2 = Questions("Kata apa yang diucapkan pada video?", R.raw.kata_nama_kamu_siapa, "Nama Kamu Siapa", "Bagaimana", "Ayo", "Akan", 1)
//        addQuestion(q2)
//        val q3 = Questions("Huruf Apa yang terdapat pada gambar?", R.raw.alfabet_h, "A", "F", "C", "H", 4)
//        addQuestion(q3)
//        val q4 = Questions("Huruf Apa yang terdapat pada gambar?", R.raw.alfabet_g, "G", "H", "C", "A", 1)
//        addQuestion(q4)
//        val q5 = Questions("Kata apa yang diucapkan pada video?", R.raw.kata_apa_kabar, "Alhamdulillah", "Apa Kabar", "Perkenalkan", "Dimana", 2)
//        addQuestion(q5)
//        val q6 = Questions("Huruf Apa yang terdapat pada gambar?", R.raw.alfabet_z, "A", "Z", "C", "H", 2)
//        addQuestion(q6)
//        val q7 = Questions("Kata apa yang diucapkan pada video?", R.raw.kata_maaf, "Sama-sama", "Apakah", "Bagaimana", "Maaf", 4)
//        addQuestion(q7)
//    }
//
//    fun getAllQuestions(): ArrayList<Questions>{
//        val questionsList = ArrayList<Questions>()
////        val db = this.readableDatabase
//
//        val projection = arrayOf(
//            QuizContract.QuestionTable._ID,
//            QuizContract.QuestionTable.COLUMN_QUESTION,
//            QuizContract.QuestionTable.COLUMN_IMAGE,
//            QuizContract.QuestionTable.COLUMN_OPTION1,
//            QuizContract.QuestionTable.COLUMN_OPTION2,
//            QuizContract.QuestionTable.COLUMN_OPTION3,
//            QuizContract.QuestionTable.COLUMN_OPTION4,
//            QuizContract.QuestionTable.COLUMN_ANSWER,
//        )
//        val cursor = db.query(
//            QuizContract.QuestionTable.TABLE_NAME,
//            projection,
//            null,
//            null,
//            null,
//            null,
//            null
//        )
//
//        if (cursor.moveToFirst()){
//            do {
//                val questions = Questions()
//                questions.setQuestions(cursor.getString(cursor.getColumnIndexOrThrow(QuizContract.QuestionTable.COLUMN_QUESTION)))
//                questions.setImageQuestions(cursor.getInt(cursor.getColumnIndexOrThrow(QuizContract.QuestionTable.COLUMN_IMAGE)))
//                questions.setOptions1(cursor.getString(cursor.getColumnIndexOrThrow(QuizContract.QuestionTable.COLUMN_OPTION1)))
//                questions.setOptions2(cursor.getString(cursor.getColumnIndexOrThrow(QuizContract.QuestionTable.COLUMN_OPTION2)))
//                questions.setOptions3(cursor.getString(cursor.getColumnIndexOrThrow(QuizContract.QuestionTable.COLUMN_OPTION3)))
//                questions.setOptions4(cursor.getString(cursor.getColumnIndexOrThrow(QuizContract.QuestionTable.COLUMN_OPTION4)))
//                questions.setAnswer(cursor.getInt(cursor.getColumnIndexOrThrow(QuizContract.QuestionTable.COLUMN_ANSWER)))
//
////                val questions = cursor.getString(cursor.getColumnIndexOrThrow(QuizContract.QuestionTable.COLUMN_QUESTION))
////                val imageQuestions = cursor.getInt(cursor.getColumnIndexOrThrow(QuizContract.QuestionTable.COLUMN_IMAGE))
////                val options1 = cursor.getString(cursor.getColumnIndexOrThrow(QuizContract.QuestionTable.COLUMN_OPTION1))
////                val options2 = cursor.getString(cursor.getColumnIndexOrThrow(QuizContract.QuestionTable.COLUMN_OPTION2))
////                val options3 = cursor.getString(cursor.getColumnIndexOrThrow(QuizContract.QuestionTable.COLUMN_OPTION3))
////                val options4 = cursor.getString(cursor.getColumnIndexOrThrow(QuizContract.QuestionTable.COLUMN_OPTION4))
////                val answer = cursor.getInt(cursor.getColumnIndexOrThrow(QuizContract.QuestionTable.COLUMN_ANSWER))
//
////                questionsList.add(Questions(questions, imageQuestions, options1, options2, options3, options4, answer))
//            } while (cursor.moveToNext())
//        }
//        cursor.close()
//        return questionsList
//    }
//}