package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Repository
public class DB {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public String getProductByName(String name) {
        StringBuilder sb = new StringBuilder();
        SqlParameterSource namedParameters = new MapSqlParameterSource("name", "%" + name + "%");
        String sql = readSQLqueryFromFile("my-script.sql");
        SqlRowSet obj = namedParameterJdbcTemplate.queryForRowSet(sql, namedParameters);

        while (obj.next()) {
            sb.append(obj.getString("product_name"));
            sb.append(";");
        }
        return sb.toString();
    }

    private static String readSQLqueryFromFile(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
