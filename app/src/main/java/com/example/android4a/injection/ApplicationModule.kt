package com.example.android4a.injection

import android.content.Context
import androidx.room.Room
import com.example.android4a.data.local.AppDatabase
import com.example.android4a.data.local.DatabaseDao
import com.example.android4a.data.remote.PokeCardApi
import com.example.android4a.data.repository.ApiRepository
import com.example.android4a.data.repository.UserRepository
import com.example.android4a.domain.usecase.ApiUseCase
import com.example.android4a.domain.usecase.CreateUserUseCase
import com.example.android4a.domain.usecase.GetUserUseCase
import com.example.android4a.presentation.main.ApplicationViewModel
import com.example.android4a.presentation.main.MainViewModel
import org.koin.android.experimental.dsl.viewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val presentationModule: Module = module {
    factory { MainViewModel(get(), get()) }
    factory { ApplicationViewModel() }
}

val domainModule: Module = module {
    factory { ApiUseCase(get()) }
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
}

val dataModule: Module = module {
    single { UserRepository(get()) }
    factory { ApiRepository(get(),get()) }
    single{ createDataBase(androidContext())
//    single{createApi(androidContext())}
    }
}

fun createDataBase(context: Context): DatabaseDao {
    val appDatabase: AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()
}

/*fun createApi(context: Context): PokeCardApi {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://www.reddit.com")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val pokeCardApi = retrofit.create(PokeCardApi::class.java)
    return pokeCardApi
}*/