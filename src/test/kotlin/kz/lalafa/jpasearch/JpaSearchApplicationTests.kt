package kz.lalafa.jpasearch

import kz.lalafa.jpasearch.jpa.SearchCriteria
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

//@RunWith(SpringRunner::class)
//@SpringBootTest
class JpaSearchApplicationTests {

	@Test
	fun contextLoads() {
		val build = SearchCriteria.build("firstName:maxim'asf")
		println(build.get(0).group(0))
	}

}
