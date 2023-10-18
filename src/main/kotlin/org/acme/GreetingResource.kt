package org.acme

import io.quarkus.reactive.datasource.ReactiveDataSource
import io.smallrye.mutiny.coroutines.awaitSuspending
import io.vertx.mutiny.mysqlclient.MySQLPool
import io.vertx.mysqlclient.MySQLClient
import jakarta.enterprise.context.ApplicationScoped
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType

@ApplicationScoped
@Path("/hello")
class GreetingResource(@ReactiveDataSource("cool") val db: MySQLPool) {
    @GET
    suspend fun hello(): List<Int> {
        return db.query("SELECT 1").execute().awaitSuspending().map { it.getInteger("1") }
    }
}