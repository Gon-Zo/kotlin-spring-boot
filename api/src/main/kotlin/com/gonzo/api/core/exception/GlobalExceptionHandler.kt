package com.gonzo.api.core.exception

import com.gonzo.api.core.log.Log
import org.apache.commons.lang3.exception.ExceptionUtils
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

/**
 * Create by park031517@gmail.com on 2020-07-28, 화
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@ControllerAdvice
class GlobalExceptionHandler {

    companion object : Log

    @ResponseBody
    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handlerException(exception: java.lang.Exception): ErrorDto {

        logger!!.error(exception.message)
        logger!!.error(ExceptionUtils.getStackTrace(exception))

        return ErrorDto(ErrorCode.SYSTEM_ERROR.errorCode,
                ErrorCode.SYSTEM_ERROR.message,
                ExceptionUtils.getStackTrace(exception))

    }

    @ResponseBody
    @ExceptionHandler(AppException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handlerException(exception: AppException): ErrorDto {

        var errorCode = exception.errorCode

        logger!!.error(exception.message)

        logger!!.error(ExceptionUtils.getStackTrace(exception))

        return ErrorDto(errorCode.errorCode,
                errorCode.message,
                ExceptionUtils.getStackTrace(exception))

    }

}
