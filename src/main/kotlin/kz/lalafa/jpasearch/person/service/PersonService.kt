package kz.lalafa.jpasearch.person.service

import kz.lalafa.jpasearch.jpa.SearchCriteria
import kz.lalafa.jpasearch.person.dao.PersonEntity
import kz.lalafa.jpasearch.person.dao.PersonSpecification
import kz.lalafa.jpasearch.person.repository.PersonRepository
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class PersonService(
        private val personRepository: PersonRepository
) {

    fun get(search: String?, pageable: Pageable): List<PersonEntity> {
        search?.let {
            val specification = SearchCriteria.build(it).map {
                Specification.where(PersonSpecification(SearchCriteria(it.group(1), it.group(2), it.group(3))))
            }.reduce { t: Specification<PersonEntity>, u: Specification<PersonEntity> -> t.and(u) }
            return personRepository.findAll(specification, pageable).content
        }
        return personRepository.findAll(pageable).content
    }

    @PostConstruct
    fun before() {
        val person1 = PersonEntity(firstName = "maxim", secondName = "kuzichev1", age = 32)
        val person2 = PersonEntity(firstName = "maxim", secondName = "ivanov", age = 23)
        val person3 = PersonEntity(firstName = "elena", secondName = "brovko1", age = 23)

        personRepository.saveAll(listOf(person1, person2, person3))
    }
}