package com.gonzo.api.web.dto

import com.gonzo.api.domain.group.Group
import com.gonzo.api.domain.user.User
import com.gonzo.api.domain.usergroup.UserGroup

data class UserGroupDto(var user: User, var group: Group) {

    fun toEntity(): UserGroup {
        return UserGroup(this.user, this.group)
    }

}
