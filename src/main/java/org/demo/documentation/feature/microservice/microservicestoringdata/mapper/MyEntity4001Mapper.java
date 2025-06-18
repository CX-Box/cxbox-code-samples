package org.demo.documentation.feature.microservice.microservicestoringdata.mapper;

import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity4001;
import org.demo.documentation.feature.microservice.microservicestoringdata.dto.MyExample4001DTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MyEntity4001Mapper {

    MyExample4001DTO toDto(final MyEntity4001 entity);

    MyEntity4001 newEntityByDto(final String id, final MyExample4001DTO request);

    MyEntity4001 updateEntityByDto(final MyExample4001DTO request, @MappingTarget final MyEntity4001 entity);

}
