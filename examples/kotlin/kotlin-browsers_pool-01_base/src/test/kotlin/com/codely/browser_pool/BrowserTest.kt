package com.codely.browser_pool

open class BrowserTest {
    fun navigateTo(url: String) {
        val browser = Browser()
        browser.get(url)
        Thread.sleep(1000)
        browser.close()
    }
}