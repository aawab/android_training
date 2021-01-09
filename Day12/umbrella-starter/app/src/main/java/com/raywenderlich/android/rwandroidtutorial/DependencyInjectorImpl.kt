package com.raywenderlich.android.rwandroidtutorial

class DependencyInjectorImpl : DependencyInjector {
    override fun weatherRepository(): WeatherRepository{
        return WeatherRepositoryImpl()
    }
}