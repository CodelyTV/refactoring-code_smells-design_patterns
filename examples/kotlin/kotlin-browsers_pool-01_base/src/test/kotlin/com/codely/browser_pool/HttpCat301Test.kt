package com.codely.browser_pool

import org.junit.jupiter.api.Test

class HttpCat301Test : BrowserTest() {
    @Test
    fun `it should get HTTP 😺 301`() {
        navigateTo("https://http.cat/301")
    }
}
