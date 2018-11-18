package com.example.mrrexz.mytaxiandroid.di.module

import dagger.Module

@Module(includes = [NetworkModule::class, ContextModule::class, RepositoryModule::class])
class AppModule {

}