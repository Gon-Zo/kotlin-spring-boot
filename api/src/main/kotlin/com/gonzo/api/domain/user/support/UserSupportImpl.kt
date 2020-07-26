package com.gonzo.api.domain.user.support

import com.gonzo.api.domain.user.User
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport

class UserSupportImpl() : UserSupport , QuerydslRepositorySupport(User::class.java) {

}
