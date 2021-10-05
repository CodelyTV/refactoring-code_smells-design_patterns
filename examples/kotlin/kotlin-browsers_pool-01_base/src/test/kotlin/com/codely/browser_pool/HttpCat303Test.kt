package com.codely.browser_pool

import org.junit.jupiter.api.Test

class HttpCat303Test : BrowserTest() {
    @Test
    fun `it should get HTTP 😺 302`() {
        navigateTo("https://http.cat/303")
    }
}
