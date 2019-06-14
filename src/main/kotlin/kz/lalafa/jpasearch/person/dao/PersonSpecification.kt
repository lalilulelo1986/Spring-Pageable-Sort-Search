package kz.lalafa.jpasearch.person.dao

import kz.lalafa.jpasearch.jpa.SearchCriteria
import org.springframework.data.jpa.domain.Specification
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

class PersonSpecification(private val criteria: SearchCriteria) : Specification<PersonEntity> {

    override fun toPredicate(root: Root<PersonEntity>, query: CriteriaQuery<*>, builder: CriteriaBuilder): Predicate? {

        val matchList = criteria.value.takeIf { criteria.operation == ":" }.toString().split("'")
        return when (criteria.operation) {
            ":" ->
                if (matchList.size > 1) {
                    root.get<String>(criteria.key).`in`(matchList)
                } else {
                    builder.like(root.get<String>(criteria.key), "%" + criteria.value + "%")
                }
            ">" -> builder.greaterThanOrEqualTo(
                    root.get<String>(criteria.key), criteria.value.toString())
            "<" -> builder.lessThanOrEqualTo(
                    root.get<String>(criteria.key), criteria.value.toString())
            else -> null
        }
    }
}