package com.gonzo.api.core

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

@Configuration
//@ComponentScan("com.baeldung.jdbc")
class SpringJdbcConfig {

    @Bean
    fun postgresDataBaseSource () : DataSource {

        var dmd = DriverManagerDataSource()

        dmd.setDriverClassName("")

        dmd.url = ""

        dmd.username = ""

        dmd.password = ""

//        return null
    }

}
