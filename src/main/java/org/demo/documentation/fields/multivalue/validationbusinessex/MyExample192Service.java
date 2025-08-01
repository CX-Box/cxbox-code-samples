package org.demo.documentation.fields.multivalue.validationbusinessex;

import java.util.Objects;
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

import static org.demo.documentation.fields.main.TextError.ONLY_LETTER;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample192Service extends VersionAwareResponseService<MyExample192DTO, MyEntity192> {

	private final MyEntity192Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample192Meta> meta = MyExample192Meta.class;

    @Autowired
	private EntityManager entityManager;

    @Override
	protected CreateResult<MyExample192DTO> doCreateEntity(MyEntity192 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample192DTO> doUpdateEntity(MyEntity192 entity, MyExample192DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample192DTO_.customField)) {
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
					.map(e -> entityManager.getReference(MyEntity193.class, e))
					.toList());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample192DTO> getActions() {
		return Actions.<MyExample192DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}