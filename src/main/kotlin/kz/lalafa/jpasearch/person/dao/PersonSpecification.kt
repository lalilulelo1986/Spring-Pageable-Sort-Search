package kz.lalafa.jpasearch.person.dao

import kz.lalafa.jpasearch.jpa.SearchCriteria
import org.springframework.data.jpa.domain.Specification
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

class PersonSpecification(private val criteria: SearchCriteria) : Specification<PersonEntity> {

    override fun toPredicate(root: Root<PersonEntity>, query: CriteriaQuery<*>, builder: CriteriaBuilder): Predicate? {
        return when (criteria.operation) {
            ">" -> builder.greaterThanOrEqualTo(
                    root.get<String>(criteria.key), criteria.value.toString())
            "<" -> builder.lessThanOrEqualTo(
                    root.get<String>(criteria.key), criteria.value.toString())
            ":" ->
                if (root.get<String>(criteria.key).javaType === String::class.java) {
                    builder.like(
                            root.get<String>(criteria.key), "%" + criteria.value + "%")
                } else {
                    builder.equal(root.get<String>(criteria.key), criteria.value)
                }
            else -> null
        }
    }
}