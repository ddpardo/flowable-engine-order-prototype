package be.ddprd.example.config;

import javax.sql.DataSource;

import org.flowable.cmmn.api.CmmnRepositoryService;
import org.flowable.cmmn.api.CmmnRuntimeService;
import org.flowable.cmmn.engine.CmmnEngine;
import org.flowable.cmmn.engine.CmmnEngineConfiguration;
import org.flowable.cmmn.spring.SpringCmmnEngineConfiguration;
import org.flowable.common.engine.impl.AbstractEngineConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
public class FlowableCmmnConfig {

	
	@Bean
	public SpringCmmnEngineConfiguration cmmnEngineConfiguration(DataSource dataSource, PlatformTransactionManager platformTransactionManager) {
		SpringCmmnEngineConfiguration spec = new SpringCmmnEngineConfiguration();
		spec.setDataSource(dataSource);
		spec.setTransactionManager(platformTransactionManager);
		spec.setDatabaseSchemaUpdate(AbstractEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		spec.setDeploymentResources(new Resource[] {new ClassPathResource("/cmmn/hello-world.cmmn.xml")});
		
		return spec;
	}
	
	@Bean
	public CmmnEngine cmmnEngine(CmmnEngineConfiguration configuration) {
		return configuration.buildCmmnEngine();
	}
	
	@Bean
	public CmmnRepositoryService cmmnRepositoryService(CmmnEngine cmmnEngine) {
		return cmmnEngine.getCmmnRepositoryService();
	}
	
	@Bean
	public CmmnRuntimeService cmmnRuntimeService(CmmnEngine cmmnEngine) {
		return cmmnEngine.getCmmnRuntimeService();
	}
}
