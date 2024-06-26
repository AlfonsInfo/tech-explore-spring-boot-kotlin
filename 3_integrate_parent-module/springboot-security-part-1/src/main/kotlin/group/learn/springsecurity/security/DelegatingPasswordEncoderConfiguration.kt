package group.learn.springsecurity.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.DelegatingPasswordEncoder
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder
import org.springframework.security.crypto.password.StandardPasswordEncoder
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder

/*
  1. memungkinkan aplikasi untuk menggunakan beberapa metode enkripsi password sekaligus
  2. menghasilkan fleksibelitas
 */
@Configuration
class DelegatingPasswordEncoderConfiguration {

    //* Default Delegating Password Encoder
    @Bean
    fun passwordEncoder() : PasswordEncoder{
        return PasswordEncoderFactories.createDelegatingPasswordEncoder()
    }

    fun customDelegatingPasswordEncoder() : PasswordEncoder{
        val idForEncode = "bcrypt"
        val encoders: MutableMap<String, PasswordEncoder> = mutableMapOf()
        encoders[idForEncode] = BCryptPasswordEncoder()
        encoders["noop"] = NoOpPasswordEncoder.getInstance()
        encoders["pbkdf2"] = Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_5()
        encoders["pbkdf2@SpringSecurity_v5_8"] = Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8()
        encoders["scrypt"] = SCryptPasswordEncoder.defaultsForSpringSecurity_v4_1()
        encoders["scrypt@SpringSecurity_v5_8"] = SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8()
        encoders["argon2"] = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_2()
        encoders["argon2@SpringSecurity_v5_8"] = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8()
        encoders["sha256"] = StandardPasswordEncoder()

        val passwordEncoder: PasswordEncoder = DelegatingPasswordEncoder(idForEncode, encoders)
        return passwordEncoder
    }
}