package com.gonzo.api.core.exception

data class ErrorDto(private var errorCode: String, private var errorMessage: String, private var errorDetail: String)
