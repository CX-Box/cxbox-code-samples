package org.demo.documentation.microservice.microservicestoringdata.mapper;
import org.demo.documentation.microservice.microservicestoringdata.dto.MyExample4001DTO;
import org.demo.documentation.microservice.microservicestoringdata.repository.entity.MyEntity4001;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MyEntity4001Mapper {

	MyExample4001DTO toDto(final MyEntity4001 myEntity4001);

}
