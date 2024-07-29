package com.example.androidprac.presentation.screens.onboarding

import androidx.lifecycle.ViewModel
import com.example.androidprac.core.data.repositories.HelloRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    val helloRepo: HelloRepo
) : ViewModel() {

    var counter = MutableStateFlow(0)
        private set

    fun getHelloString(): String {
        return helloRepo.sayHello()
    }

    fun incrementCounter() {
        counter.value++
    }
}