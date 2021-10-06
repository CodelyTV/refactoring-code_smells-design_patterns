package com.codely.lazy_initialization

import org.junit.jupiter.api.Test

class HttpCat202Test : BrowserTest() {
    @Test
    fun `it should get HTTP 😺 202`() {
        navigateTo("https://http.cat/202")
    }
}
