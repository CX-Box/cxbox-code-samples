package org.demo.documentation.widgets.assoctree.customizationcolumns;

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
public class MyExample3335Service extends VersionAwareResponseService<MyExample3335DTO, MyEntity3335> {

	private final MyEntity3335Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3335Meta> meta = MyExample3335Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3335DTO> doCreateEntity(MyEntity3335 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3335DTO> doUpdateEntity(MyEntity3335 entity, MyExample3335DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3335DTO_.customFieldMultivalue)) {
			entity.getCustomFieldMultivalueList().clear();
			entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldMultivalue().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3335Assoc.class, e))
					.toList());
		}
		setIfChanged(data, MyExample3335DTO_.customFieldNumber, entity::setCustomFieldNumber);
		setIfChanged(data, MyExample3335DTO_.customFieldTest, entity::setCustomFieldTest);
		if (data.isFieldChanged(MyExample3335DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3335DTO> getActions() {
		return Actions.<MyExample3335DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}

