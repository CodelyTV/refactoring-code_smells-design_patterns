package com.codely.browser_pool

import org.junit.jupiter.api.Test

class HttpCat200Test : BrowserTest() {
    @Test
    fun `it should get HTTP 😺 200`() {
        navigateTo("https://http.cat/200")
    }
}
