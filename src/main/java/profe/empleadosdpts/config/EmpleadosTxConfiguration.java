package profe.empleadosdpts.config;

import javax.transaction.SystemException;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionManager;


@Configuration
@EnableTransactionManagement
public class EmpleadosTxConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.jta.atomikos.empleadosdatasource")
    public AtomikosDataSourceBean empleadosDataSource() {
        return new AtomikosDataSourceBean(); 
    }
    
    @Bean
    @ConfigurationProperties(prefix = "spring.jta.atomikos.departamentosdatasource")
    public AtomikosDataSourceBean departamentosDataSource() {
        return new AtomikosDataSourceBean(); 
    }
    
    @Bean(initMethod = "init", destroyMethod = "close")
    public UserTransactionManager userTransactionManager() throws SystemException {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setTransactionTimeout(300);
        userTransactionManager.setForceShutdown(true);
        return userTransactionManager;
    }
    
    @Bean
    public JtaTransactionManager jtaTransactionManager() throws SystemException {
        JtaTransactionManager jtaTransactionManager = new JtaTransactionManager();
        jtaTransactionManager.setTransactionManager(userTransactionManager());
        jtaTransactionManager.setUserTransaction(userTransactionManager());
        return jtaTransactionManager;
    }
}
