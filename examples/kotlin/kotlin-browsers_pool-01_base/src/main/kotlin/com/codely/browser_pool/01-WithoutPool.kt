package com.codely.browser_pool

import kotlin.system.measureTimeMillis
import org.openqa.selenium.firefox.FirefoxDriver

fun main(args: Array<String>) {
    val browserA = getBrowser()
    val browserB = getBrowser()
    browserA.get("https://http.cat/404")
    browserB.get("https://http.cat/418")

    Thread.sleep(5000)

    browserA.close()
    browserB.close()
}

private fun getBrowser(): Browser {
    var browser: Browser
    val elapsed = measureTimeMillis {
        browser = Browser()
    }
    println("Elapsed time $elapsed")

    return browser
}
