package group.learn.example.runner

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class CommandLineRunner :CommandLineRunner {
    override fun run(vararg args: String?) {
        print("Hello World")
    }
}