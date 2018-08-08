package com.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.EmbeddedValueResolutionSupport;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class JDBCTest {
    private ApplicationContext context = null;
    private JdbcTemplate jdbcTemplate;
    private WebSitesDao webSitesDao;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    {
        context = new ClassPathXmlApplicationContext("beans-jdbc.xml");
        jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        webSitesDao = context.getBean(WebSitesDao.class);
        namedParameterJdbcTemplate = context.getBean(NamedParameterJdbcTemplate.class);
    }

    @Test
    public void testNameParameterJdbcTemplate() {
        String sql = "insert into websites (url, name, country) values(:url, :email, :country)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("url", "www.yi.com");
        paramMap.put("email", "fsfasf@yi.com");
        paramMap.put("country", "chin");

        namedParameterJdbcTemplate.update(sql, paramMap);

    }

    @Test
    public void testQueryForObject2() {
        System.out.println(webSitesDao.get(2));
    }
    @Test
    public void testQueryForObject() {
        String sql = "select id, url url, name name from websites where id = ?";
        RowMapper<WebSites> rowMapper = new BeanPropertyRowMapper<>(WebSites.class);
        WebSites webSites = jdbcTemplate.queryForObject(sql, rowMapper, 1);
        System.out.println(webSites);
    }

    @Test
    public void testUpdate() {
        String sql = "update websites set name = ? where id = ? ";
        jdbcTemplate.update(sql, "test", 1);
    }
    @Test
    public void testDataSource()  throws SQLException {
        DataSource dataSource = context.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }


}
