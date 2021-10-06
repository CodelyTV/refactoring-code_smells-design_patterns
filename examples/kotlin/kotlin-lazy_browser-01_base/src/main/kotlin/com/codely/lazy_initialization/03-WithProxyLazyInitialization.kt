package com.codely.lazy_initialization

fun main(args: Array<String>) {
    client(FirefoxBrowser())
    //client(LazyFirefoxBrowserProxy())
}

fun client(browser: Browser) {
    //browser.get("https://http.cat/200")
    browser.close()
}

