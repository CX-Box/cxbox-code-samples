package org.demo.documentation.feature.microservice.microservicestoringdata.mapper;

import org.demo.documentation.feature.microservice.microservicestoringdata.dto.MyExample4002ExternalDTO;

import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity4002External;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MyEntity4002Mapper {

	MyExample4002ExternalDTO toDto(final MyEntity4002External myEntity);

	MyEntity4002External newEntityByDto(final String id, final MyExample4002ExternalDTO request);


	MyEntity4002External updateEntityByDto(@MappingTarget final MyEntity4002External myEntity, final MyExample4002ExternalDTO request);

}
