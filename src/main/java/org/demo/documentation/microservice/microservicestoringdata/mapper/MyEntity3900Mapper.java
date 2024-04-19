package org.demo.documentation.microservice.microservicestoringdata.mapper;


import org.demo.documentation.microservice.microservicestoringdata.dto.MyExample3900DTO;
import org.demo.documentation.microservice.microservicestoringdata.repository.entity.MyEntity3900;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MyEntity3900Mapper {

	@Mapping(target = "id", source = "myEntity3900.id")
	@Mapping(target = "customField", source = "myEntity3900.customField")

	MyExample3900DTO toDto(final MyEntity3900 myEntity3900);

	@Mapping(target = "id")
	@Mapping(target = "customField")
	MyEntity3900 newEntityByDto(final String id, final MyExample3900DTO request);

	@Mapping(target = "id")
	@Mapping(target = "customField")
	MyEntity3900 updateEntityByDto(@MappingTarget final MyEntity3900 myEntity3900, final MyExample3900DTO request);

}
