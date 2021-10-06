package com.codely.lazy_initialization

import org.junit.jupiter.api.Test

class HttpCat303Test : BrowserTest() {
    @Test
    fun `it should get HTTP 😺 302`() {
        navigateTo("https://http.cat/303")
    }
}
