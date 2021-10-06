package com.codely.lazy_initialization

fun main(args: Array<String>) {
    val browser = LazyFirefoxBrowser()
    browser.get("https://http.cat/200")
    browser.close()
}

