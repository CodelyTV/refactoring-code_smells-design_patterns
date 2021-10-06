package com.codely.lazy_initialization

import org.junit.jupiter.api.Test

class HttpCat201Test : BrowserTest() {
    @Test
    fun `it should get HTTP 😺 201`() {
        navigateTo("https://http.cat/201")
    }
}
