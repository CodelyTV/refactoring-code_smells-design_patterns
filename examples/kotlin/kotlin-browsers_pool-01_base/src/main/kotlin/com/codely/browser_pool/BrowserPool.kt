package com.codely.browser_pool

import java.util.LinkedList
import java.util.Queue
import kotlin.collections.HashSet

class BrowserPool {
    companion object {
        private var available: Queue<Browser> = LinkedList()
        private var inUse: MutableSet<Browser> = HashSet()

        @Synchronized fun getBrowser(): Browser {
            if (available.isEmpty()) {
                val browser = Browser()
                available.add(browser)
            }

            val browser = available.remove()
            inUse.add(browser)
            return browser
        }

        @Synchronized fun releaseBrowser(browser: Browser) {
            inUse.remove(browser)
            available.add(browser)
        }

        @Synchronized fun closeAll() {
            inUse.forEach { browser -> browser.close() }
            available.forEach { browser -> browser.close() }
        }
    }
}
