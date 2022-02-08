package com.example.apilibrary.db

import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.apilibrary.models.CommentListItem
import com.example.apilibrary.models.PostListItem

@Dao
interface PostDao {

    @Insert
    //suspend fun addtPost(posts: PostListItem?)
   suspend fun addtPost(posts: List<PostListItem>)

    @Query("SELECT * FROM posts")
    //suspend fun getPosts() : PostListItem
   suspend fun getPosts() : List<PostListItem>


    @Insert
    //suspend fun addtPost(posts: PostListItem?)
    suspend fun addtComment(comments: List<CommentListItem>)

    @Query("SELECT * FROM comments")
    //suspend fun getPosts() : PostListItem
    suspend fun getComments() : List<CommentListItem>
}