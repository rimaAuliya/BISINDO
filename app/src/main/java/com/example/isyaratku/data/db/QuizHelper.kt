//package com.example.isyaratku.data.db
//
//import android.content.ContentValues
//import android.content.Context
//import android.database.Cursor
//import android.database.sqlite.SQLiteDatabase
//import com.example.isyaratku.data.db.QuizContract.QuestionTable.Companion.TABLE_NAME
//import com.example.isyaratku.data.db.QuizContract.QuestionTable.Companion._ID
//import java.sql.SQLException
//import kotlin.jvm.Throws
//
//class QuizHelper(context: Context) {
//    private var dataBaseHelper: DatabaseHelper = DatabaseHelper(context)
//    private lateinit var database: SQLiteDatabase
//
//    @Throws(SQLException::class)
//    fun open(){
//        database = dataBaseHelper.writableDatabase
//
//    }
//    fun close() {
//        dataBaseHelper.close()
//        if (database.isOpen){
//            database.close()
//        }
//    }
//    fun queryAll(): Cursor {
//        return database.query(
//            DATABASE_TABLE,
//            null,
//            null,
//            null,
//            null,
//            null,
//            "$_ID ASC",
//            null
//        )
//    }
//    fun queryById(id: String): Cursor{
//        return database.query(
//            DATABASE_TABLE,
//            null,
//            "$_ID = ?",
//            arrayOf(id),
//            null,
//            null,
//            null,
//            null
//        )
//    }
//    fun insert(value: ContentValues?): Long{
//        return database.insert(DATABASE_TABLE, null, value)
//    }
//    fun update(id: String, values: ContentValues?): Int {
//        return database.update(DATABASE_TABLE, values, "$_ID = ?", arrayOf(id))
//    }
//    fun deleteById(id: String): Int {
//        return database.delete(DATABASE_TABLE, "$_ID = '$id'", null)
//    }
//
//
//    companion object {
//        private const val DATABASE_TABLE = TABLE_NAME
//        private var INSTANCE: QuizHelper? = null
//        fun getInstance(context: Context): QuizHelper =
//            INSTANCE ?: synchronized(this) {
//                INSTANCE ?: QuizHelper(context).also { INSTANCE = it }
//            }
//    }
//}