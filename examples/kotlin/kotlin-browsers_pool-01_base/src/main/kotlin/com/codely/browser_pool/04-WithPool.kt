package com.codely.browser_pool

import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    val t1 = thread {
        val browser = getBrowser()
        browser.get("https://http.cat/100")
        BrowserPool.releaseBrowser(browser)
    }

    t1.join()

    Thread.sleep(10000)

    val t2 = thread {
        val browser = getBrowser()
        browser.get("https://http.cat/200")
        BrowserPool.releaseBrowser(browser)
    }

    val t3 = thread {
        val browser = getBrowser()
        browser.get("https://http.cat/201")
        BrowserPool.releaseBrowser(browser)
    }

    t2.join()
    t3.join()

    Thread.sleep(10000)

    val t4 = thread {
        val browser = getBrowser()
        browser.get("https://http.cat/300")
        BrowserPool.releaseBrowser(browser)
    }

    val t5 = thread {
        val browser = getBrowser()
        browser.get("https://http.cat/301")
        BrowserPool.releaseBrowser(browser)
    }

    t4.join()
    t5.join()

    Thread.sleep(10000)

    BrowserPool.closeAll()
}

private fun getBrowser(): Browser {
    var browser: Browser
    val elapsed = measureTimeMillis {
        browser = BrowserPool.getBrowser()
    }
    println("Elapsed time $elapsed")

    return browser
}
