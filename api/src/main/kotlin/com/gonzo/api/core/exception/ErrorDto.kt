package com.gonzo.api.core.exception

import com.fasterxml.jackson.annotation.JsonAlias
import com.sun.xml.internal.ws.developer.Serialization

/**
 * Create by park031517@gmail.com on 2020-08-9, 일
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
data class ErrorDto(var errorCode: String, var errorMessage: String, var errorDetail: String)

