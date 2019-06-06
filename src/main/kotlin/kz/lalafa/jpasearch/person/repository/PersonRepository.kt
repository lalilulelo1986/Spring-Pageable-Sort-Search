package kz.lalafa.jpasearch.person.repository

import kz.lalafa.jpasearch.person.dao.PersonEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface PersonRepository : JpaRepository<PersonEntity, Long>, JpaSpecificationExecutor<PersonEntity>