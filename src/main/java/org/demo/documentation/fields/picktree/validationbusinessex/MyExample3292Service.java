package org.demo.documentation.fields.picktree.validationbusinessex;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.demo.documentation.fields.main.TextError.ONLY_LETTER;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3292Service extends VersionAwareResponseService<MyExample3292DTO, MyEntity3292> {

	private final MyEntity3292Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3292Meta> meta = MyExample3292Meta.class;

	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3292DTO> doCreateEntity(MyEntity3292 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample3292DTO> doUpdateEntity(MyEntity3292 entity, MyExample3292DTO data,
															  BusinessComponent bc) {
		if (StringUtils.isNotEmpty(data.getCustomField())
				&& !String.valueOf(data.getCustomField()).matches("[A-Za-z]+")
		) {
			throw new BusinessException().addPopup(ONLY_LETTER);
		}
		if (data.isFieldChanged(MyExample3292DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity3292Pick.class, data.getCustomFieldId())
					: null);
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3292DTO> getActions() {
		return Actions.<MyExample3292DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}