package com.codely.browser_pool

import kotlin.system.measureTimeMillis
import kotlin.concurrent.thread

fun main(args: Array<String>) {
    val t1 = thread {
        for (code in 100..102) {
            visitPage("https://http.cat/$code")
        }
    }

    val t2 = thread {
        for (code in 200..204) {
            visitPage("https://http.cat/$code")
        }
    }

    val t3 = thread {
        for (code in 300..305) {
            visitPage("https://http.cat/$code")
        }
    }

    t1.join()
    t2.join()
    t3.join()

    BrowserPool.closeAll()
}

private fun visitPage(url: String) {
    val browser = BrowserPool.getBrowser()
    browser.get(url)
    Thread.sleep(2000)
    BrowserPool.releaseBrowser(browser)
}
