package com.github.studtravel.di

import android.content.Context
import com.github.studtravel.data.repository.DormitoryRepository
import com.github.studtravel.data.service.INetworkService
import com.github.studtravel.datasource.local.AppPreferences
import com.github.studtravel.datasource.login.LoginDataSource
import com.github.studtravel.datasource.login.LoginRepository
import com.github.studtravel.domain.repository.IDormitoryRepository
import com.github.studtravel.domain.repository.ILoginRepository
import com.github.studtravel.domain.repository.IPreferencesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {
  @Provides
  fun provideDormitoryRepository(networkService: INetworkService): IDormitoryRepository =
    DormitoryRepository(networkService)

  @Provides
  fun provideLoginRepository(loginDataSource: LoginDataSource): ILoginRepository =
    LoginRepository(loginDataSource)

  @Provides
  fun providePreferencesRepository(@ApplicationContext context: Context): IPreferencesRepository =
    AppPreferences(context)
}
