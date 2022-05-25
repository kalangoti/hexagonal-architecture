package conta.prd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.nio.file.FileSystems;
import java.nio.file.Path;

// Responsável por configurar os serviços do spring
@Configuration
@EnableTransactionManagement
@ComponentScan({
        // adptadores front-end javafx
        "conta.tela",
        "conta.prd",
        // core do sistema
        "conta.sistema",
        // adptadores hsqdl
        "conta.servicos.respositorio"})
public class Build4 {

    // Build 4 - Adaptador JavaFX -> Sistema <- Adaptadores Real em Produção

    @Bean
    public DataSource dataSource() {
        Path path = FileSystems.getDefault().getPath("");
        String directoryName = path.toAbsolutePath().toString().replace("desktop","");
        var ds = new SimpleDriverDataSource();
        ds.setDriverClass(org.hsqldb.jdbcDriver.class);
        ds.setUrl("jdbc:hsqldb:file:" + directoryName + "db/");
        ds.setUsername("SA");
        ds.setPassword("1234");
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public DataSourceTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
