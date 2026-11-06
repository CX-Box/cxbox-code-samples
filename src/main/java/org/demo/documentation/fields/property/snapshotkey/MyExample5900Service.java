package org.demo.documentation.fields.property.snapshotkey;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample5900Service extends VersionAwareResponseService<MyExample5900DTO, MyEntity5900> {

	private final MyEntity5900Repository repository;

	private final EntityManager entityManager;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5900Meta> meta = MyExample5900Meta.class;

	@Override
	protected CreateResult<MyExample5900DTO> doCreateEntity(MyEntity5900 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	/**
	 * Only current values are changed. Snapshot values stay the same,
	 * so after saving the widgets with "snapshotKey" show the difference
	 */
	@Override
	protected ActionResultDTO<MyExample5900DTO> doUpdateEntity(MyEntity5900 entity, MyExample5900DTO data,
			BusinessComponent bc) {
		setIfChanged(data, MyExample5900DTO_.inputField, entity::setInputField);
		setIfChanged(data, MyExample5900DTO_.textField, entity::setTextField);
		setIfChanged(data, MyExample5900DTO_.numberField, entity::setNumberField);
		setIfChanged(data, MyExample5900DTO_.moneyField, entity::setMoneyField);
		setIfChanged(data, MyExample5900DTO_.percentField, entity::setPercentField);
		setIfChanged(data, MyExample5900DTO_.dateField, entity::setDateField);
		setIfChanged(data, MyExample5900DTO_.dateTimeField, entity::setDateTimeField);
		setIfChanged(data, MyExample5900DTO_.dateTimeWithSecondsField, entity::setDateTimeWithSecondsField);
		setIfChanged(data, MyExample5900DTO_.checkboxField, entity::setCheckboxField);
		setIfChanged(data, MyExample5900DTO_.dictionaryField, entity::setDictionaryField);
		setIfChanged(data, MyExample5900DTO_.radioField, entity::setRadioField);
		if (data.isFieldChanged(MyExample5900DTO_.pickListFieldId)) {
			entity.setPickListEntity(data.getPickListFieldId() != null
					? entityManager.getReference(MyEntity5900Pick.class, data.getPickListFieldId())
					: null);
		}
		if (data.isFieldChanged(MyExample5900DTO_.inlinePickListFieldId)) {
			entity.setInlinePickListEntity(data.getInlinePickListFieldId() != null
					? entityManager.getReference(MyEntity5900Pick.class, data.getInlinePickListFieldId())
					: null);
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample5900DTO> getActions() {
		return Actions.<MyExample5900DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}

}
