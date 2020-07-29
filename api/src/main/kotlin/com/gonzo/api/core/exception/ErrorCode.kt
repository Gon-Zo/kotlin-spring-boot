package com.gonzo.api.core.exception

/**
 * Create by park031517@gmail.com on 2020-07-28, 화
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
enum class ErrorCode (val stats : Int , val errorCode : String , val message : String) {
    NOT_FOUNT_PASSWORD(500 , "U001" , "Not found password"),
    SYSTEM_ERROR(500 , "S001" , "System Error")
}
