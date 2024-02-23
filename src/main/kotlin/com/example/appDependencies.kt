package com.example

import org.koin.core.qualifier.named
import org.koin.dsl.module

val appDependencies = module {
    single(named(HELLO_WORLD_STRING)) { "hello world" }
}

const val HELLO_WORLD_STRING = "hello_world_string"
