package org.demo.documentation.microservice.microservicestoringdata.mapper;

import org.demo.documentation.microservice.microservicestoringdata.dto.MyExample3910DTO;
import org.demo.documentation.microservice.microservicestoringdata.repository.entity.MyEntity3910;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface MyEntity3910Mapper {

	MyExample3910DTO toDto(final MyEntity3910 myEntity3910);

}
