package org.demo.documentation.widgets.assoc.customizationcolumns;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3078Service extends VersionAwareResponseService<MyExample3078DTO, MyEntity3078> {

	private final MyEntity3078Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3078Meta> meta = MyExample3078Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3078DTO> doCreateEntity(MyEntity3078 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3078DTO> doUpdateEntity(MyEntity3078 entity, MyExample3078DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3078DTO_.customFieldMultivalue)) {
			entity.getCustomFieldMultivalueList().clear();
			entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldMultivalue().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3078Assoc.class, e))
					.toList());
		}
		setIfChanged(data, MyExample3078DTO_.customFieldNumber, entity::setCustomFieldNumber);
		setIfChanged(data, MyExample3078DTO_.customFieldTest, entity::setCustomFieldTest);
		if (data.isFieldChanged(MyExample3078DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3078DTO> getActions() {
		return Actions.<MyExample3078DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}

