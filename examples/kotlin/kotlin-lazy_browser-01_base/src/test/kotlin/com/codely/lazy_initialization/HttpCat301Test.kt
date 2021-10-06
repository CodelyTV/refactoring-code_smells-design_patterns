package com.codely.lazy_initialization

import org.junit.jupiter.api.Test

class HttpCat301Test : BrowserTest() {
    @Test
    fun `it should get HTTP 😺 301`() {
        navigateTo("https://http.cat/301")
    }
}
