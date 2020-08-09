package com.gonzo.api.core.utils

import org.json.JSONObject

/**
 * Create by park031517@gmail.com on 2020-08-9, 일
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
class AppUtils{

    companion object{

        fun passerJSONObject(str : String , key : String) : Any?{
            var jsonObject  = JSONObject(str)
            return jsonObject[key]
        }

    }


}
