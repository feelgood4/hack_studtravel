package com.github.studtravel.di

import com.github.studtravel.data.repository.DormitoryRepository
import com.github.studtravel.data.service.INetworkService
import com.github.studtravel.datasource.login.LoginDataSource
import com.github.studtravel.datasource.login.LoginRepository
import com.github.studtravel.domain.repository.IDormitoryRepository
import com.github.studtravel.domain.repository.ILoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {
  @Provides
  fun provideDormitoryRepository(networkService: INetworkService): IDormitoryRepository =
    DormitoryRepository(networkService)

  @Provides
  fun provideLogin(loginDataSource: LoginDataSource): ILoginRepository =
    LoginRepository(loginDataSource)
}
