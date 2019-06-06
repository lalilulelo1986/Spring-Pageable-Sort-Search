package kz.lalafa.jpasearch.person.controller

import kz.lalafa.jpasearch.person.dao.PersonEntity
import kz.lalafa.jpasearch.person.service.PersonService
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.data.web.SortDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController("person")
class PersonController(
        private val personService: PersonService
) {

    @GetMapping
    fun get(@RequestParam(value = "search") search: String?,
            @PageableDefault(value = 10, page = 0)
            @SortDefault(sort = ["firstName"], direction = Sort.Direction.ASC)
            pageable: Pageable): List<PersonEntity> {
        return personService.get(search, pageable)
    }
}