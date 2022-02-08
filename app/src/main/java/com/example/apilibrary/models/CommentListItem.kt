package com.example.apilibrary.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
@Entity(tableName = "comments")
data class CommentListItem(

    @PrimaryKey(autoGenerate = true)
    val idd : Int,
    @SerialName("id")
    val id: Int,
    @SerialName("body")
    val body: String,
    @SerialName("email")
    val email: String,
    @SerialName("name")
    val name: String,
    @SerialName("postId")
    val postId: Int

):Parcelable