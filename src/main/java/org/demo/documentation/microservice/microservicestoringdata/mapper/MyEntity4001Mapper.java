package org.demo.documentation.microservice.microservicestoringdata.mapper;
import org.demo.documentation.microservice.microservicestoringdata.dto.MyExample3900DTO;
import org.demo.documentation.microservice.microservicestoringdata.dto.MyExample4001DTO;
import org.demo.documentation.microservice.microservicestoringdata.repository.entity.MyEntity3900;
import org.demo.documentation.microservice.microservicestoringdata.repository.entity.MyEntity4001;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MyEntity4001Mapper {

	MyExample4001DTO toDto(final MyEntity4001 myEntity4001);

	MyEntity4001 newEntityByDto(final String id, final MyExample4001DTO request);


	MyEntity4001 updateEntityByDto(@MappingTarget final MyEntity4001 myEntity, final MyExample4001DTO request);

}
