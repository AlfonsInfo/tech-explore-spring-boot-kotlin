package group.learn.springsecurity.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/no-auth")
class NoAuthController {
    @GetMapping("/hello")
    fun sayHello() :  String{
        return "Hello ges"
    }
}