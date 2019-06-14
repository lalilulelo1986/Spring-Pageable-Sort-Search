package kz.lalafa.jpasearch

import kz.lalafa.jpasearch.jpa.SearchCriteria
import org.junit.Test

class JpaSearchApplicationTests {

	@Test
	fun contextLoads() {
		val build = SearchCriteria.build("firstName:maxim'asf")
		println(build[0].group())
	}

}
