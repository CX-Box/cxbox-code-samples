package org.demo.microservicestoringdata.mapper;


import org.demo.microservicestoringdata.dto.MyExample3900DTO;
import org.demo.microservicestoringdata.repository.entity.MyEntity3900;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MyEntity3900Mapper {

	@Mapping(target = "id", source = "myEntity3900.id")
	@Mapping(target = "customField", source = "myEntity3900.customField")

	MyExample3900DTO toDto(final MyEntity3900 myEntity3900);

}
