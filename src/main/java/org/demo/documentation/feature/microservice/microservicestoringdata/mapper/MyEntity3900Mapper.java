package org.demo.documentation.feature.microservice.microservicestoringdata.mapper;


import org.demo.documentation.feature.microservice.microservicestoringdata.dto.MyExample3900DTO;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity3900;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MyEntity3900Mapper {


	MyExample3900DTO toDto(final MyEntity3900 entity);


	MyEntity3900 newEntityByDto(final String id, final MyExample3900DTO request);

	@Mapping(target = "id", ignore = true)
	MyEntity3900 updateEntityByDto(final MyExample3900DTO request, @MappingTarget final MyEntity3900 entity);

}
