package org.demo.documentation.feature.microservice.microservicestoringdata.mapper;

import org.demo.documentation.feature.microservice.microservicestoringdata.dto.MyExample4002ExternalDTO;

import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity4002External;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MyEntity4002Mapper {

	MyExample4002ExternalDTO toDto(final MyEntity4002External entity);

	MyEntity4002External newEntityByDto(final String id, final MyExample4002ExternalDTO request);

	MyEntity4002External updateEntityByDto(final MyExample4002ExternalDTO request,@MappingTarget final MyEntity4002External entity);

}
