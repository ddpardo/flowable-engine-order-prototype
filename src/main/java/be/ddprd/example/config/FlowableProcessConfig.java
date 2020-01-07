package be.ddprd.example.config;

import javax.sql.DataSource;

import org.flowable.common.engine.impl.AbstractEngineConfiguration;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.TaskService;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class FlowableProcessConfig {

	
	@Bean
	public SpringProcessEngineConfiguration processEngineConfiguration(DataSource dataSource, PlatformTransactionManager platformTransactionManager) {
		SpringProcessEngineConfiguration spec = new SpringProcessEngineConfiguration();
		spec.setDataSource(dataSource);
		spec.setTransactionManager(platformTransactionManager);
		spec.setDatabaseSchemaUpdate(AbstractEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		return spec;
	}
	
	@Bean
	public ProcessEngine processEngine(ProcessEngineConfiguration configuration) {
		return configuration.buildProcessEngine();
	}
	
	@Bean
	public TaskService taskService(ProcessEngine engine) {
		return engine.getTaskService();
	}
}
