package com.gonzo.api.web.dto

class HelloDto {

    var title: String
        set(title) {
            this.title = title
        }
        get() = this.title

    var content: String
        get() = this.content
        set(content) {
            this.content = content
        }

    constructor(){

    }

    constructor(title: String, content: String) {
        this.title = title
        this.content = content
    }

}
