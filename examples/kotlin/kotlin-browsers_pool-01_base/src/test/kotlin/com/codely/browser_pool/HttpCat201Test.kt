package com.codely.browser_pool

import org.junit.jupiter.api.Test

class HttpCat201Test : BrowserTest() {
    @Test
    fun `it should get HTTP 😺 201`() {
        navigateTo("https://http.cat/201")
    }
}
