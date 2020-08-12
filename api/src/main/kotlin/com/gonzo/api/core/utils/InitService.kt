package com.gonzo.api.core.utils

import com.gonzo.api.domain.group.Group
import com.gonzo.api.domain.group.GroupRepository
import com.gonzo.api.domain.menu.Menu
import com.gonzo.api.domain.menu.MenuRepository
import com.gonzo.api.domain.menugroup.MenuGroup
import com.gonzo.api.domain.menugroup.MenuGroupRepository
import com.gonzo.api.domain.user.User
import com.gonzo.api.domain.user.UserRepository
import com.gonzo.api.domain.usergroup.UserGroup
import com.gonzo.api.domain.usergroup.UserGroupRepository
import com.gonzo.api.web.dto.GroupDto
import com.gonzo.api.web.dto.UserDto
import org.springframework.stereotype.Service
import java.util.*

/**
 * Create by park031517@gmail.com on 2020-08-12, 수
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Service
class InitService (
        private var userRepository: UserRepository ,
        private var groupRepository: GroupRepository ,
        private var menuRepository: MenuRepository ,
        private var menuGroupRepository: MenuGroupRepository ,
        private var userGroupRepository: UserGroupRepository
) {

    fun initService() {

        var userCnt = userRepository.count()

        var user: User? = null

        if (userCnt == 0L) {
            var userDto = UserDto("admin", "1234", false)
            userDto.encodingPassword()
            userDto.isUseToUser()
            user = userRepository.saveAndFlush(userDto.toEntity())
        }

        var groupCnt = groupRepository.count()

        var group: Group? = null

        if (groupCnt == 0L) {

            var groupDto = GroupDto("ADMIN")

            group = groupRepository.saveAndFlush(groupDto.toEntity())

        }

        var menuCnt = menuRepository.count()

        var menuList: MutableList<Menu> = mutableListOf<Menu>()

        var menuStrList = Arrays.asList("/api/user")

        if (menuCnt == 0L) {

            menuStrList.forEach { str -> menuList.add(menuRepository.saveAndFlush(Menu(str as String, true))) }

            menuList.forEach{menu -> menuGroupRepository.save(MenuGroup(menu , group!!)) }

            userGroupRepository.save(UserGroup(user!! , group!!))

        }


    }
}

