package com.haunp.mybookstore.data.repository

import com.haunp.mybookstore.data.model.entity.RateBook

interface CommentRepository {
    suspend fun insertComment(rateBook: RateBook)
    suspend fun getCommentsByBookId(bookId: Int): List<RateBook>
    suspend fun updateComment(rateBook: RateBook)
    suspend fun deleteComment(rateBook: RateBook)

}