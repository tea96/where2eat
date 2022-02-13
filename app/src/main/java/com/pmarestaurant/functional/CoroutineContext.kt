package com.pmarestaurant.functional

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class CoroutineContext: ICoroutineContextProvider {
    override val main: CoroutineContext by lazy {
        Dispatchers.Main
    }
    override val io: CoroutineContext by lazy {
        Dispatchers.IO
    }
    override val default: CoroutineContext by lazy {
        Dispatchers.Default
    }
}