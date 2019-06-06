package kz.lalafa.jpasearch

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JpaSearchApplication

fun main(args: Array<String>) {
	runApplication<JpaSearchApplication>(*args)
}
