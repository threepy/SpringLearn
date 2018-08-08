package com.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class WebSitesDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public WebSites get(Integer id) {
        String sql = "select id, name name, url url, alexa alexa, country country from websites where id = ?";
        RowMapper<WebSites> rowMapper = new BeanPropertyRowMapper<>(WebSites.class);
        WebSites webSites = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return webSites;
    }
}
