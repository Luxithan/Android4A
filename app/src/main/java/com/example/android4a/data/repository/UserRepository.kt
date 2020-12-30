package com.example.android4a.data.repository

import com.example.android4a.data.local.DatabaseDao
import com.example.android4a.data.local.models.UserLocal
import com.example.android4a.data.local.models.toData
import com.example.android4a.data.local.models.toEntity
import com.example.android4a.domain.entity.User

class UserRepository(
    private val databaseDao: DatabaseDao
) {
    //private val currentUser: User
    suspend fun createUser(user: User){
        databaseDao.insert(user.toData())
    }

    fun getUserMail(email: String) : User? {
        val userMail : UserLocal? = databaseDao.findByMail(email)
        return userMail?.toEntity()
    }

    fun getUserMailAndPass(email: String, password: String) : User? {
        val userMailAndPass: UserLocal? = databaseDao.findByMailAndPass(email, password)
        return userMailAndPass?.toEntity()
    }
}