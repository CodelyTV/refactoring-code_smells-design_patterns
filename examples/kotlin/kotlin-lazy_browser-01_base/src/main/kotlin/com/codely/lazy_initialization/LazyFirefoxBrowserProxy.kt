package com.codely.lazy_initialization

class LazyFirefoxBrowserProxy : Browser {
    private var browser: FirefoxBrowser? = null

    override fun get(url: String) {
        ensureInitialized()
        browser?.get(url)
    }

    override fun close() {
        if (isInitialized()) {
            browser?.close()
        }
    }

    private fun isInitialized(): Boolean {
        return this.browser !== null
    }

    private fun initialize() {
        browser = FirefoxBrowser()
    }

    private fun ensureInitialized() {
        if (!isInitialized()) {
            initialize()
        }
    }
}
