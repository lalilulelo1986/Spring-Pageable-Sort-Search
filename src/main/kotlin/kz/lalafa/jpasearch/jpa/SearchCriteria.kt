package kz.lalafa.jpasearch.jpa

import org.springframework.data.jpa.domain.Specification
import java.util.regex.MatchResult
import java.util.regex.Pattern
import kotlin.streams.toList

data class SearchCriteria (
     val key: String,
     val operation: String,
     val value: Any?
) {
    companion object {
        fun build(search: String): List<MatchResult> {
            val pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),")
            val matcher = pattern.matcher("$search,")
            return  matcher.results().toList()
        }
    }
}

fun <T> Specification<T>.build1(search: String): List<MatchResult> {
    val pattern = java.util.regex.Pattern.compile("(\\w+?)(:|<|>)(\\w+?),")
    val matcher = pattern.matcher("$search,")
    return  matcher.results().toList()
}