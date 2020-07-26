package com.gonzo.api.service.user

import com.gonzo.api.domain.user.UserRepository
import com.gonzo.api.domain.user.support.UserSupport
import com.gonzo.api.web.dto.UserDto
import org.springframework.stereotype.Service

/**
 * Create by pnw1517@gmail.com on 2020-07-26, 일
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Service
class UserServiceImpl : UserService {

    private lateinit var repository: UserRepository

    private lateinit var support: UserSupport

    override fun createdByUser(dto: UserDto) {
        repository.save(dto.toEntity())
    }

    override fun modifyByUser(seq: Long, dto: UserDto) {
        support.update(seq, dto)
    }

    override fun deleteByUser(seq: Long) {
        repository.deleteById(seq)
    }

}
