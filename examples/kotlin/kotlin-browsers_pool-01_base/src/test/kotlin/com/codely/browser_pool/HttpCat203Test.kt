package com.codely.browser_pool

import org.junit.jupiter.api.Test

class HttpCat203Test : BrowserTest() {
    @Test
    fun `it should get HTTP 😺 203`() {
        navigateTo("https://http.cat/203")
    }
}
