package com.gonzo.api.core.exception

/**
 * Create by park031517@gmail.com on 2020-07-28, 화
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
enum class ErrorCode (val stats : Int , val errorCode : String , val message : String) {
    NOT_FOUNT_PASSWORD(500 , "U001" , "Not found password"),
    SYSTEM_ERROR(500 , "S001" , "System Error"),
    NOT_USE_USER (500 ,"U001" , " Is Not Use User"),
    NOT_FOUND_TOKEN( 500 , "A001" , "Not Found Token"),
    UNABLE_JWT_TOKEN( 500 , "A002" , "Unable Jwt Token"),
    EXPIRED_JWT_TOKEN( 500 , "A004" , "EXPIRED JWT TOKEN"),
    IS_NOT_VALIDATE( 500 , "A005" , "IS NOT VALIDATE"),
    NOT_FOUND_USER( 500 , "U002" , "Not Found User")

}
