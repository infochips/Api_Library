package com.example.apilibrary

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.apilibrary.api.PostService
import com.example.apilibrary.db.PostDatabase
import com.example.apilibrary.models.CommentListItem
import com.example.apilibrary.models.PostListItem

class PostRepository(private val postService: PostService,
                     private val postDatabase: PostDatabase,
                     private val applicationContext: Context
) {

    val postsLiveData = MutableLiveData<List<PostListItem>>()   // publically not access
    val postsLiveData1 = MutableLiveData<List<CommentListItem>>()   // publically not access

    //val posts : LiveData<PostListItem>
    val posts: MutableLiveData<List<PostListItem>>
     get() = postsLiveData

    //get() = postsLiveData

    val posts1: MutableLiveData<List<CommentListItem>>
    get() = postsLiveData1

    suspend fun getPosts1(url1: String) {
        // postService.getPosts(url1)

        val result = postService.getPosts(url1)

        if (result != null) {
            for (postlistitem1 in result) {
                postDatabase.postDao().addtPost(result)  // save data in room database
                // Log.e("postDatabase", result.toString())

                postsLiveData.postValue(result)
            }
        }

        //  }
        //else{

        // for Offline support. get data from room database & display on UI
        val posts = postDatabase.postDao().getPosts()
        postsLiveData.postValue(posts)

    }


    suspend fun getPosts2(url2 : String) {

        val commentResult = postService.getComments(url2)

        if (commentResult != null) {
            for (postlistitem2 in commentResult) {
                postDatabase.postDao().addtComment(commentResult)  // save data in room database
                // Log.e("postDatabase", result.toString())

                postsLiveData1.postValue(commentResult)
            }
        } else {

            // for Offline support. get data from room database & display on UI
            val posts1 = postDatabase.postDao().getComments()
            postsLiveData1.postValue(posts1)

        }
    }


}