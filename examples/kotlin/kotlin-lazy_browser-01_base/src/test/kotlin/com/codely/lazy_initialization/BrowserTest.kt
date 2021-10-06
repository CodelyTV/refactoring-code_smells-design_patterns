package com.codely.lazy_initialization

open class BrowserTest {
    fun navigateTo(url: String) {
        val browser = BrowserPool.getBrowser()
        browser.get(url)
        Thread.sleep(1000)
        BrowserPool.releaseBrowser(browser)
    }
}