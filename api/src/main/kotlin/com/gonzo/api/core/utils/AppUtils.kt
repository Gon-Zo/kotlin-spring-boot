package com.gonzo.api.core.utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.gonzo.api.core.exception.AppException
import com.gonzo.api.core.exception.ErrorDto
import org.json.JSONObject
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import javax.servlet.http.HttpServletResponse

/**
 * Create by park031517@gmail.com on 2020-08-9, 일
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
class AppUtils {

    companion object {

        fun passerJSONObject(str: String, key: String): Any? {
            var jsonObject = JSONObject(str)
            return jsonObject[key]
        }

        fun getBadRequest(e: AppException, response: HttpServletResponse) {
            try {
                var objectMapper = ObjectMapper()
                response.status = INTERNAL_SERVER_ERROR.value()
                var code = e.errorCode.errorCode
                var message = e.errorCode.message
                response.outputStream.println(objectMapper.writeValueAsString(ErrorDto(code, message, "")))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }


}
