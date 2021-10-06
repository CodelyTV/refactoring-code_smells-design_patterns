package com.codely.lazy_initialization

interface Browser {
    fun get(url: String)
    fun close()
}