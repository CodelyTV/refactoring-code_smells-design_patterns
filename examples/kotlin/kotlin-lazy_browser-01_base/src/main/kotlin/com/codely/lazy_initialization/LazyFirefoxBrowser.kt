package com.codely.lazy_initialization

import org.openqa.selenium.firefox.FirefoxDriver

class LazyFirefoxBrowser {
    private var firefox: FirefoxDriver? = null

    fun get(url: String) {
        ensureInitialized()
        firefox?.get(url)
    }

    fun close() {
        if (isInitialized()) {
            firefox?.quit()
        }
    }

    private fun isInitialized(): Boolean {
        return this.firefox !== null
    }

    private fun initialize() {
        firefox = FirefoxDriver()
    }

    private fun ensureInitialized() {
        if (!isInitialized()) {
            initialize()
        }
    }
}
