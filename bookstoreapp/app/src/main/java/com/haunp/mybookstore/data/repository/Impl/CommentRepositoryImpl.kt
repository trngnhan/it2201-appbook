package com.haunp.mybookstore.data.repository.Impl

import com.haunp.mybookstore.data.local.dao.CommentDao
import com.haunp.mybookstore.data.model.entity.RateBook
import com.haunp.mybookstore.data.repository.CommentRepository

class CommentRepositoryImpl(private val commentDao: CommentDao): CommentRepository {
    override suspend fun insertComment(rateBook: RateBook) {
        return commentDao.insertComment(rateBook)
    }

    override suspend fun getCommentsByBookId(bookId: Int): List<RateBook> {
        return commentDao.getCommentsByProductId(bookId)
    }

    override suspend fun updateComment(rateBook: RateBook) {
        return commentDao.updateComment(rateBook)
    }

    override suspend fun deleteComment(rateBook: RateBook) {
        return commentDao.deleteComment(rateBook)
    }
}