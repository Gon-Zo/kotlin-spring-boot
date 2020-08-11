package com.gonzo.api.service.user

import com.gonzo.api.core.enums.Groups
import com.gonzo.api.core.exception.AppException
import com.gonzo.api.core.exception.ErrorCode
import com.gonzo.api.domain.group.GroupRepository
import com.gonzo.api.domain.user.User
import com.gonzo.api.domain.user.UserRepository
import com.gonzo.api.domain.user.support.UserSupport
import com.gonzo.api.domain.usergroup.UserGroupRepository
import com.gonzo.api.web.dto.UserDto
import com.gonzo.api.web.dto.UserGroupDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Create by park031517@gmail.com on 2020-07-26, 일
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Service
class UserServiceImpl( private val repository: UserRepository,
                       private val support: UserSupport,
                       private val groupRepository: GroupRepository ,
                       private val userGroupRepository: UserGroupRepository
) : UserService {

    @Transactional
    override fun createdByUser(dto: UserDto) {

        var sameUser = repository.findByEmail(dto.email)

        if (sameUser.isPresent){
           throw AppException(ErrorCode.NOT_FOUND_USER)
        }

        dto.encodingPassword()

        dto.isUseToUser()

//        var group = groupRepository.findByTitle(Groups.USER.value)
        var user = repository.saveAndFlush(dto.toEntity())
//        userGroupRepository.save(UserGroupDto(user, group).toEntity())
    }

    @Transactional
    override fun modifyByUser(seq: Long, dto: UserDto) {
        support.update(seq, dto)
    }

    @Transactional
    override fun deleteByUser(seq: Long) {
        repository.deleteById(seq)
    }

    @Transactional
    override fun updateByUser(seq: Long, dto: UserDto) {
        var user : User = repository.getOne(seq)
        user.email = dto.email
        user.password = dto.password
        repository.save(user)
    }

}
