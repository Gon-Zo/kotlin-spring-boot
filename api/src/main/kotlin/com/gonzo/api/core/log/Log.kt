package com.gonzo.api.core.log

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Create by park031517@gmail.com on [2020-08-6, 목
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
interface Log {
    val logger: Logger? get() = LoggerFactory.getLogger(this.javaClass)
}
