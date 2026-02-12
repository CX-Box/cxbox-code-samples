package org.demo.services;

import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dto.BusinessError.Entity;
import org.cxbox.core.exception.BusinessException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("EmptyMethod")
@Service
public class CustomDynamicErrorService {

	public void sumError(BusinessComponent bc, DataResponseDTO dto) {
		Entity entity = new Entity(bc);
		Set<String> badFields = new HashSet<>();
		badFields.addAll(dto.getSerializableFields());
		for (String fieldName : badFields) {
			entity.addField(fieldName, "Custom error message");
		}
		throw new BusinessException().setEntity(entity);
	}

}
