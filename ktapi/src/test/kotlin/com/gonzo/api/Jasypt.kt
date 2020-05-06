package com.gonzo.api

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor

class Jasypt

fun main(args: Array<String>) {

    val jasypt = StandardPBEStringEncryptor()

    jasypt.setPassword("jkpark1234")

    jasypt.setAlgorithm("PBEWithMD5AndDES")

    val encryptedText = jasypt.encrypt("1234")

    val plainText = jasypt.decrypt(encryptedText)

    println("encryptedText:  $encryptedText")

    println("plainText:  $plainText")

}

