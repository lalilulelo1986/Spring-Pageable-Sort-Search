package kz.lalafa.jpasearch.person.dao

import java.time.Instant
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class PersonEntity (

    @Id
    @GeneratedValue
    val id: UUID? = null,

    @Column
    var firstName: String? = null,

    @Column
    var secondName: String? = null,

    @Column
    var age: Int? = null,

    @Column
    var dob: Instant? = null,

    @Column
    var hight: Int? = null,

    @Column
    var weight: Int? = null
)