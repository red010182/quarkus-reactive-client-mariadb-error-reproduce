package org.acme

import io.quarkus.logging.Log
import io.quarkus.test.junit.QuarkusTest
import io.restassured.module.kotlin.extensions.*
import org.junit.jupiter.api.Test

@QuarkusTest
class GreetingResourceTest {

    @Test
    fun testHelloEndpoint() {
        When {
            get("/hello")
        } Then {
            statusCode(200)
        } Extract {
            Log.info(body())
        }
    }

}