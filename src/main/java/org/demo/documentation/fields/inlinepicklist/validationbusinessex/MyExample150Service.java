package org.demo.documentation.fields.inlinepicklist.validationbusinessex;

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
import org.demo.documentation.fields.inlinepicklist.validationbusinessex.picklist.MyEntity151;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.demo.documentation.fields.main.TextError.ONLY_LETTER;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample150Service extends VersionAwareResponseService<MyExample150DTO, MyEntity150> {

	private final MyEntity150Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample150Meta> meta = MyExample150Meta.class;

    @Autowired
	private EntityManager entityManager;

    @Override
	protected CreateResult<MyExample150DTO> doCreateEntity(MyEntity150 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample150DTO> doUpdateEntity(MyEntity150 entity, MyExample150DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample150DTO_.customFieldId)) {
			if (StringUtils.isNotEmpty(data.getCustomField())
					&& !data.getCustomField().matches("[A-Za-z]+")
			) {
				throw new BusinessException().addPopup(ONLY_LETTER);
			}
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity151.class, data.getCustomFieldId())
					: null);

		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample150DTO> getActions() {
		return Actions.<MyExample150DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}