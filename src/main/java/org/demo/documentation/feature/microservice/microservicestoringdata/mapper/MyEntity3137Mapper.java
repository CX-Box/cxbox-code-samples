package org.demo.documentation.feature.microservice.microservicestoringdata.mapper;

import org.demo.documentation.feature.microservice.microservicestoringdata.dto.MyExample3137DTO;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity3137;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MyEntity3137Mapper {

	MyExample3137DTO toDto(final MyEntity3137 entity);

	MyEntity3137 newEntityByDto(final String id, final MyExample3137DTO request);

	MyEntity3137 updateEntityByDto(final MyExample3137DTO request, @MappingTarget final MyEntity3137 entity);

}
