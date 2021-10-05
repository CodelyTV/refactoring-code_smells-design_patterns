package com.codely.browser_pool

import kotlin.system.measureTimeMillis
import kotlin.concurrent.thread

fun main(args: Array<String>) {
    val t1 = thread {
        visitPage("https://http.cat/100")
    }

    t1.join()

    val t2 = thread {
        visitPage("https://http.cat/200")
    }

    val t3 = thread {
        visitPage("https://http.cat/201")
    }

    t2.join()
    t3.join()

    val t4 = thread {
        visitPage("https://http.cat/300")
    }

    val t5 = thread {
        visitPage("https://http.cat/301")
    }

    t4.join()
    t5.join()
}

private fun visitPage(url: String) {
    val browser = getBrowser()
    browser.get(url)
    Thread.sleep(2000)
    browser.close()
}

private fun getBrowser(): Browser {
    var browser: Browser
    val elapsed = measureTimeMillis {
        browser = Browser()
    }
    println("Elapsed time $elapsed")

    return browser
}
