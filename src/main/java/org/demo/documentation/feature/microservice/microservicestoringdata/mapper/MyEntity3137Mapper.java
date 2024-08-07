package org.demo.documentation.feature.microservice.microservicestoringdata.mapper;

import org.demo.documentation.feature.microservice.microservicestoringdata.dto.MyExample3137DTO;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity3137;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MyEntity3137Mapper {

	MyExample3137DTO toDto(final MyEntity3137 myEntity3137);

	MyEntity3137 newEntityByDto(final String id, final MyExample3137DTO request);


	MyEntity3137 updateEntityByDto(@MappingTarget final MyEntity3137 myEntity, final MyExample3137DTO request);

}
