package org.demo.documentation.fields.multivaluetree.validationbusinessex;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.demo.documentation.fields.main.TextError.ONLY_LETTER;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3325Service extends VersionAwareResponseService<MyExample3325DTO, MyEntity3325> {

	private final MyEntity3325Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3325Meta> meta = MyExample3325Meta.class;

	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3325DTO> doCreateEntity(MyEntity3325 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample3325DTO> doUpdateEntity(MyEntity3325 entity, MyExample3325DTO data,
															  BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3325DTO_.customField)) {
			data.getCustomField().getValues()
					.stream()
					.filter(val -> !val.getValue().matches("[A-Za-z]+"))
					.findFirst()
					.orElseThrow(() -> new BusinessException().addPopup(ONLY_LETTER));
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3325Multivalue.class, e))
					.toList());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3325DTO> getActions() {
		return Actions.<MyExample3325DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}