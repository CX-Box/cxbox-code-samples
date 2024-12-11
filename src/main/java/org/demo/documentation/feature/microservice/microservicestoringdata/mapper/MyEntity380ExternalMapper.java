package org.demo.documentation.feature.microservice.microservicestoringdata.mapper;


import org.demo.documentation.feature.microservice.microservicestoringdata.dto.MyExample380ExternalDTO;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity380External;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MyEntity380ExternalMapper {

	MyExample380ExternalDTO toDto(final MyEntity380External myEntity380External);

}
