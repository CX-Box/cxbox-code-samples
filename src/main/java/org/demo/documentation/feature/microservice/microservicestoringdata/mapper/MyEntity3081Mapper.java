package org.demo.documentation.feature.microservice.microservicestoringdata.mapper;


import org.demo.documentation.feature.microservice.microservicestoringdata.dto.MyExample3081DTO;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity3081;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MyEntity3081Mapper {


	MyExample3081DTO toDto(final MyEntity3081 entity);


	MyEntity3081 newEntityByDto(final String id, final MyExample3081DTO request);

	MyEntity3081 updateEntityByDto(final MyExample3081DTO request, @MappingTarget final MyEntity3081 entity);

}
