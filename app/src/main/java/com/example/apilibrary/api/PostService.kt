package com.example.apilibrary.api

import com.example.apilibrary.models.CommentListItem
import com.example.apilibrary.models.PostListItem
import retrofit2.http.GET
import retrofit2.http.Url

interface PostService {

//    companion object {
//        fun getData() {
            @GET
            suspend fun getPosts(@Url url: String): List<PostListItem>

            //https://jsonplaceholder.typicode.com/posts/1/comments
            @GET
            suspend fun getComments(@Url url: String): List<CommentListItem>
//        }
//    }
}