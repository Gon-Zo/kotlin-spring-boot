package com.gonzo.api.core.exception

/**
 * Create by park031517@gmail.com on 2020-08-9, 일
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
class AppException : RuntimeException {

    var errorCode : ErrorCode

    constructor(errorCode: ErrorCode){
        this.errorCode = errorCode
    }

    constructor(message : String , errorCode: ErrorCode) : super(message){
        this.errorCode = errorCode
    }

}
