package com.gonzo.api.web

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor

fun main(args: Array<String>) {
    val jasypt = StandardPBEStringEncryptor()
    jasypt.setPassword("")
    jasypt.setAlgorithm("PBEWithMD5AndDES")

    val encryptedText = jasypt.encrypt("postgres")
    val plainText = jasypt.decrypt(encryptedText)

    println("encryptedText:  $encryptedText")
    println("plainText:  $plainText")
}
