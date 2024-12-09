package org.demo.documentation.feature.microservice.microservicestoringdata.mapper;


import org.demo.documentation.feature.microservice.microservicestoringdata.dto.MyExample380ExternalDTO;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity380;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MyEntity380Mapper {


	MyExample380ExternalDTO toDto(final MyEntity380 myEntity);

}
