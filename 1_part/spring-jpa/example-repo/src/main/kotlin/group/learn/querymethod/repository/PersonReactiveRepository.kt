package group.learn.querymethod.repository

import group.learn.querymethod.domain.entity.Person
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonReactiveRepository : ReactiveCrudRepository<Person, Long>