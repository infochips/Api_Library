package com.example.apilibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.example.apilibrary.api.PostService
import com.example.apilibrary.db.PostDatabase
import com.example.apilibrary.models.CommentListItem
import com.example.apilibrary.models.PostListItem
import kotlinx.coroutines.runBlocking
import retrofit2.http.Url

//import java.lang.reflect.Array.get

class MainActivity : AppCompatActivity() {

//    lateinit var postService: PostService
//    lateinit var postDatabase: PostDatabase
    lateinit var postRepository: PostRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //postRepository.getPosts1(url1 = "xsds")
        val url : Unit
        runBlocking {
             url = postRepository.getPosts1("/posts")
        }

    }
}
