package com.codely.browser_pool

import org.junit.jupiter.api.Test

class HttpCat202Test : BrowserTest() {
    @Test
    fun `it should get HTTP 😺 202`() {
        navigateTo("https://http.cat/202")
    }
}
