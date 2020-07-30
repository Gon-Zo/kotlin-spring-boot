package com.gonzo.api.config

import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.InitBinder

/**
 * Create by park031517@gmail.com on 2020-07-27, 월
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@ControllerAdvice
class WebConfiguration {

    @InitBinder
    public fun onInitBinder(webDataBinder: WebDataBinder) {
        webDataBinder.initDirectFieldAccess()
    }

}
