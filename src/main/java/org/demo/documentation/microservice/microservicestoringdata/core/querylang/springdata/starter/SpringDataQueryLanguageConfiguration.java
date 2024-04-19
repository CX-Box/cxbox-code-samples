package org.demo.documentation.microservice.microservicestoringdata.core.querylang.springdata.starter;

import jakarta.persistence.EntityManager;
import org.demo.documentation.microservice.microservicestoringdata.core.querylang.common.DtoToEntityFilterParameterMapper;
import org.demo.documentation.microservice.microservicestoringdata.core.querylang.springdata.core.QueryLanguageRepository;
import org.demo.documentation.microservice.microservicestoringdata.core.querylang.springdata.core.QueryLanguageRepositoryImpl;
import org.demo.documentation.microservice.microservicestoringdata.core.querylang.common.filterMapper.AutoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
@ConditionalOnClass(QueryLanguageRepository.class)
public class SpringDataQueryLanguageConfiguration {

	@ConditionalOnMissingBean(QueryLanguageRepository.class)
	@Bean
	public <T, I> QueryLanguageRepository<T, I> queryLanguageRepository(@Autowired EntityManager entityManager,
			@Autowired List<DtoToEntityFilterParameterMapper> providers) {
		return new QueryLanguageRepositoryImpl<>(entityManager, providers);
	}

	@ConditionalOnMissingBean(AutoMapper.class)
	@Bean
	public AutoMapper autoProvider() {
		return new AutoMapper();
	}

}
