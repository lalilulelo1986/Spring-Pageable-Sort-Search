package kz.lalafa.jpasearch.person.repository

import kz.lalafa.jpasearch.jpa.SearchCriteria
import kz.lalafa.jpasearch.person.dao.PersonEntity
import kz.lalafa.jpasearch.person.dao.PersonSpecification
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.Example
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.domain.Specification
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    private lateinit var personRepository: PersonRepository

    private var person1: PersonEntity? = null
    private var person2: PersonEntity? = null
    private var person3: PersonEntity? = null

    @Before
    fun before() {
        person1 = PersonEntity(firstName = "maxim", secondName = "kuzichev1", age = 32)
        person2 = PersonEntity(firstName = "maxim", secondName = "ivanov", age = 23)
        person3 = PersonEntity(firstName = "elena", secondName = "brovko1", age = 23)

        personRepository.saveAll(listOf(person1, person2, person3))
    }

    @Test
    fun givenLast_whenGettingListOfUsers_thenCorrect() {
        val personSpecification = PersonSpecification(SearchCriteria("secondName", ":", "1"))
        val persons = personRepository.findAll(personSpecification, PageRequest.of(0,2))

        persons.sortedByDescending { "firstName" }.forEach {
            println(it)
        }
    }

    @Test
    fun findByFirstName() {
        val personSpecification = PersonSpecification(SearchCriteria("secondName", ":", "1"))
        val persons = personRepository.findAll(personSpecification, PageRequest.of(0,2))
        persons.get().forEach {
            println(it)
        }

        Specification.where(PersonSpecification(SearchCriteria("secondName", ":", "1")))
    }

    @Test
    fun testExample() {
        val example = Example.of(PersonEntity(firstName = "elena"))
        val persons = personRepository.findAll(example, PageRequest.of(0,2))

        persons.get().forEach {
            println(it)
        }
    }
}