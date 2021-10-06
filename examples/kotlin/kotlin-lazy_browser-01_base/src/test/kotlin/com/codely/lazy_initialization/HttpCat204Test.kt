package com.codely.lazy_initialization

import org.junit.jupiter.api.Test

class HttpCat204Test : BrowserTest() {
    @Test
    fun `it should get HTTP 😺 204`() {
        navigateTo("https://http.cat/204")
    }
}
