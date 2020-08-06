package com.gonzo.api.service.user

import com.gonzo.api.domain.user.User
import com.gonzo.api.domain.user.UserRepository
import com.gonzo.api.domain.user.support.UserSupport
import com.gonzo.api.web.dto.UserDto
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
/**
 * Create by park031517@gmail.com on 2020-07-26, 일
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Service
class UserServiceImpl( private val repository: UserRepository, private val support: UserSupport) : UserService {

    override fun createdByUser(dto: UserDto) {
        dto.encodingPassword()
        repository.save(User(dto!!.email, dto!!.password))
    }

    override fun modifyByUser(seq: Long, dto: UserDto) {
        support.update(seq, dto)
    }

    override fun deleteByUser(seq: Long) {
        repository.deleteById(seq)
    }

    override fun updateByUser(seq: Long, dto: UserDto) {
        var user : User = repository.getOne(seq)
        user.email = dto.email
        user.password = dto.password
        repository.save(user)
    }

}
