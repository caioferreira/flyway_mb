package br.com.dclick.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.googlecode.flyway.core.Flyway;


public class SpringConfig {

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/flyway_mb");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		return jdbcTemplate;
	}
	
	@Bean(initMethod="migrate")
	public Flyway flyway(DataSource dataSource){
		Flyway flyway = new Flyway();
		flyway.setInitOnMigrate(true);
		flyway.setDataSource(dataSource);
		flyway.setEncoding("UTF-8");
		flyway.setLocations("/db/migration");
		return flyway;
	}
	
}
