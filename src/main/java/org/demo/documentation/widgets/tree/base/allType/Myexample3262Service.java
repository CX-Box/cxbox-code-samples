package org.demo.documentation.widgets.tree.base.allType;


import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.tree.base.allType.entity.Myexample3262Multi;
import org.demo.documentation.widgets.tree.base.allType.entity.Myexample3262MultiHover;
import org.demo.documentation.widgets.tree.base.allType.entity.Myexample3262Pick;
import org.demo.documentation.widgets.tree.base.allType.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.tree.data.alltypes.Myexample3262;
import org.demo.repository.core.Myexample3262Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Getter
@RequiredArgsConstructor
public class Myexample3262Service extends VersionAwareResponseService<Myexample3262DTO, Myexample3262> {

	@Getter(onMethod_ = @Override)
	private final Class<Myexample3262MetaBuilder> meta = Myexample3262MetaBuilder.class;

	private final Myexample3262Repository repository;

	@Autowired
	private EntityManager entityManager;


	@Override
	protected Specification<Myexample3262> getSpecification(BusinessComponent bc) {
		return super.getSpecification(bc);
	}

	@Override
	protected CreateResult<Myexample3262DTO> doCreateEntity(Myexample3262 entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, repository.save(entity)));
	}

	@Override
	protected ActionResultDTO<Myexample3262DTO> doUpdateEntity(Myexample3262 entity, Myexample3262DTO data, BusinessComponent bc) {
		setIfChanged(data, Myexample3262DTO_.customField, entity::setCustomField);
		setIfChanged(data, Myexample3262DTO_.customFieldHidden, entity::setCustomFieldHidden);
		setIfChanged(data, Myexample3262DTO_.customFieldText, entity::setCustomFieldText);
		setIfChanged(data, Myexample3262DTO_.customFieldDateTime, entity::setCustomFieldDateTime);
		setIfChanged(data, Myexample3262DTO_.customFieldCheckbox, entity::setCustomFieldCheckbox);
		setIfChanged(data, Myexample3262DTO_.customFieldDate, entity::setCustomFieldDate);
		setIfChanged(data, Myexample3262DTO_.customFieldDateTimeWithSeconds, entity::setCustomFieldDateTimeWithSeconds);
		setIfChanged(data, Myexample3262DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
		setIfChanged(data, Myexample3262DTO_.customFieldFileUploadId, entity::setCustomFieldFileUploadId);
		setIfChanged(data, Myexample3262DTO_.customFieldFileUpload, entity::setCustomFieldFileUpload);
		setIfChanged(data, Myexample3262DTO_.customFieldNumber, entity::setCustomFieldNumber);
		setIfChanged(data, Myexample3262DTO_.customFieldPercent, entity::setCustomFieldPercent);
		if (data.isFieldChanged(Myexample3262DTO_.customFieldPickListId)) {
			entity.setCustomFieldPickListEntity(data.getCustomFieldPickListId() != null
					? entityManager.getReference(Myexample3262Pick.class, data.getCustomFieldPickListId())
					: null);
		}
		if (data.isFieldChanged(Myexample3262DTO_.customFieldInlineId)) {
			entity.setCustomFieldInlineEntity(data.getCustomFieldInlineId() != null
					? entityManager.getReference(Myexample3262Pick.class, data.getCustomFieldInlineId())
					: null);
		}
		setIfChanged(data, Myexample3262DTO_.customFieldMoney, entity::setCustomFieldMoney);
		setIfChanged(data, Myexample3262DTO_.customFieldRadio, entity::setCustomFieldRadio);
		if (data.isFieldChanged(Myexample3262DTO_.customFieldMultipleSelect)) {
			entity.setCustomFieldMultipleSelect(
					data.getCustomFieldMultipleSelect().getValues()
							.stream()
							.map(v -> CustomFieldMultipleSelectEnum.getByValue(v.getValue()))
							.collect(Collectors.toSet()));
		}
		if (data.isFieldChanged(Myexample3262DTO_.customFieldMultivalue)) {
			entity.getCustomFieldMultivalueList().clear();
			entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldMultivalue().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(Myexample3262Multi.class, e))
					.collect(Collectors.toList()));
		}
		if (data.isFieldChanged(Myexample3262DTO_.customFieldMultivalueHover)) {
			entity.getCustomFieldMultivalueHoverList().clear();
			entity.getCustomFieldMultivalueHoverList().addAll(data.getCustomFieldMultivalueHover().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(Myexample3262MultiHover.class, e))
					.collect(Collectors.toList()));
		}
		setIfChanged(data, Myexample3262DTO_.customFieldHint, entity::setCustomFieldHint);

		Myexample3262DTO dto = entityToDto(bc, repository.save(entity));

		if (data.isFieldChanged(Myexample3262DTO_.isLeaf)) {
			dto.setIsLeaf(!repository.existsByParentId(entity.getId()));
		}
		return new ActionResultDTO<>(dto)
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<Myexample3262DTO> getActions() {
		return Actions.<Myexample3262DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}

}
