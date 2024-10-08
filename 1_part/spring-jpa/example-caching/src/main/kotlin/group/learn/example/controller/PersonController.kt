package group.learn.example.controller

import group.learn.example.service.PersonService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/person")
class PersonController(
    val personService: PersonService
) {

    @GetMapping
    fun createAutomatic() : ResponseEntity<Any>{
        personService.createAutomatic()
        return ResponseEntity.ok(null)
    }
}