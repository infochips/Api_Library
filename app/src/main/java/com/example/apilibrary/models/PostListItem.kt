package com.example.apilibrary.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
@Entity(tableName = "posts")
data class PostListItem(

    @PrimaryKey(autoGenerate = true)
    val postId : Int,
    @SerialName("id")
    val id: Int,
    @SerialName("body")
    val body: String,
    @SerialName("title")
    val title: String,
    @SerialName("userId")
    val userId: Int
): Parcelable
