package com.codely.browser_pool

import org.openqa.selenium.firefox.FirefoxDriver

class Browser {
    private val firefox = FirefoxDriver()

    fun get(url: String) {
        firefox.get(url)
    }

    fun close() {
        firefox.quit()
    }
}
