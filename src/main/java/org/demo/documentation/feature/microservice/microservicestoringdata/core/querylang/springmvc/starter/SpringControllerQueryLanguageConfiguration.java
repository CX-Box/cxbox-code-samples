package org.demo.documentation.feature.microservice.microservicestoringdata.core.querylang.springmvc.starter;

import lombok.RequiredArgsConstructor;

import org.demo.documentation.feature.microservice.microservicestoringdata.core.querylang.springdata.core.QueryLanguageRepository;
import org.demo.documentation.feature.microservice.microservicestoringdata.core.querylang.springmvc.core.FilterParameterArgumentResolver;
import org.demo.documentation.feature.microservice.microservicestoringdata.core.querylang.springmvc.core.FilterParameterArgumentResolverImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@Lazy(value = false)
@RequiredArgsConstructor
@ConditionalOnClass(value = {QueryLanguageRepository.class, WebMvcConfigurer.class})
public class SpringControllerQueryLanguageConfiguration implements WebMvcConfigurer {

	@Lazy
	@Autowired
	private FilterParameterArgumentResolver filterParameterArgumentResolver;

	@ConditionalOnMissingBean(FilterParameterArgumentResolver.class)
	@Bean
	public FilterParameterArgumentResolver filterParameterArgumentResolver() {
		return new FilterParameterArgumentResolverImpl();
	}

	@Override
	public void addArgumentResolvers(final List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(filterParameterArgumentResolver);
	}

}
