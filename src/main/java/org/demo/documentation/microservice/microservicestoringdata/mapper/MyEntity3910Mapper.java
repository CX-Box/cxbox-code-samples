package org.demo.documentation.microservice.microservicestoringdata.mapper;

import org.demo.documentation.microservice.microservicestoringdata.dto.MyExample3910DTO;
import org.demo.documentation.microservice.microservicestoringdata.repository.entity.MyEntity3910;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MyEntity3910Mapper {

	@Mapping(target = "id", source = "myEntity3910.id")
	@Mapping(target = "customField", source = "myEntity3910.customField")
	MyExample3910DTO toDto(final MyEntity3910 myEntity3910);

}
