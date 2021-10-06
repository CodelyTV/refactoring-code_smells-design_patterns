package com.codely.lazy_initialization

import java.util.LinkedList
import java.util.Queue
import kotlin.collections.HashSet

class BrowserPool {
    companion object {
        private var available: Queue<FirefoxBrowser> = LinkedList()
        private var inUse: MutableSet<FirefoxBrowser> = HashSet()

        @Synchronized fun getBrowser(): FirefoxBrowser {
            if (available.isEmpty()) {
                val browser = FirefoxBrowser()
                available.add(browser)
            }

            val browser = available.remove()
            inUse.add(browser)
            return browser
        }

        @Synchronized fun releaseBrowser(browser: FirefoxBrowser) {
            inUse.remove(browser)
            available.add(browser)
        }

        @Synchronized fun closeAll() {
            inUse.forEach { browser -> browser.close() }
            available.forEach { browser -> browser.close() }
        }
    }
}
