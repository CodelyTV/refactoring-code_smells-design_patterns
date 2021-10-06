package com.codely.lazy_initialization

import org.openqa.selenium.firefox.FirefoxDriver

class FirefoxBrowser : Browser {
    private val firefox = FirefoxDriver()

    override fun get(url: String) {
        firefox.get(url)
    }

    override fun close() {
        firefox.quit()
    }
}
