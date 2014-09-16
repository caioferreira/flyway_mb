package db.migration;

import org.springframework.jdbc.core.JdbcTemplate;

import com.googlecode.flyway.core.api.migration.spring.SpringJdbcMigration;

public class V1_2__inserindo_outra_pessoa implements SpringJdbcMigration{

	public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
        jdbcTemplate.execute("INSERT INTO pessoa (nome,idade) VALUES ('Bruno Queiroz', 27)");
    }
}
