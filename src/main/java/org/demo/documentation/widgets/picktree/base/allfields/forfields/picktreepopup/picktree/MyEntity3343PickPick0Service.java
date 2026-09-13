package org.demo.documentation.widgets.picktree.base.allfields.forfields.picktreepopup.picktree;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.MyEntity3343Multi;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.MyEntity3343MultiMulti;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.MyEntity3343PickInlinePicktree;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.MyEntity3343PickPicktree;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.picktreepopup.MyEntity3343Pick;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.picktreepopup.MyEntity3343PickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3343PickPick0Service extends VersionAwareResponseService<MyEntity3343PickPick0DTO, MyEntity3343Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3343PickPick0Meta> meta = MyEntity3343PickPick0Meta.class;
	MyEntity3343PickRepository repository;

	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyEntity3343PickPick0DTO> doCreateEntity(MyEntity3343Pick entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyEntity3343PickPick0DTO> doUpdateEntity(MyEntity3343Pick entity, MyEntity3343PickPick0DTO data,
																	   BusinessComponent bc) {
		if (data.isFieldChanged(MyEntity3343PickPick0DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		if (data.isFieldChanged(MyEntity3343PickPick0DTO_.customFieldInput)) {
			entity.setCustomFieldInput(data.getCustomFieldInput());
		}
		if (data.isFieldChanged(MyEntity3343PickPick0DTO_.customFieldText)) {
			entity.setCustomFieldText(data.getCustomFieldText());
		}
		if (data.isFieldChanged(MyEntity3343PickPick0DTO_.customFieldDateTime)) {
			entity.setCustomFieldDateTime(data.getCustomFieldDateTime());
		}
		if (data.isFieldChanged(MyEntity3343PickPick0DTO_.customFieldCheckbox)) {
			entity.setCustomFieldCheckbox(data.getCustomFieldCheckbox());
		}
		if (data.isFieldChanged(MyEntity3343PickPick0DTO_.customFieldDate)) {
			entity.setCustomFieldDate(data.getCustomFieldDate());
		}
		if (data.isFieldChanged(MyEntity3343PickPick0DTO_.customFieldDateTimeWithSeconds)) {
			entity.setCustomFieldDateTimeWithSeconds(data.getCustomFieldDateTimeWithSeconds());
		}
		if (data.isFieldChanged(MyEntity3343PickPick0DTO_.customFieldDictionary)) {
			entity.setCustomFieldDictionary(data.getCustomFieldDictionary());
		}
		if (data.isFieldChanged(MyEntity3343PickPick0DTO_.customFieldFileUploadeId)) {
			entity.setCustomFieldFileUploadeId(data.getCustomFieldFileUploadeId());
		}
		if (data.isFieldChanged(MyEntity3343PickPick0DTO_.customFieldFileUploade)) {
			entity.setCustomFieldFileUploade(data.getCustomFieldFileUploade());
		}
		if (data.isFieldChanged(MyEntity3343PickPick0DTO_.customFieldNumber)) {
			entity.setCustomFieldNumber(data.getCustomFieldNumber());
		}
		if (data.isFieldChanged(MyEntity3343PickPick0DTO_.customFieldPercent)) {
			entity.setCustomFieldPercent(data.getCustomFieldPercent());
		}
		if (data.isFieldChanged(MyEntity3343PickPick0DTO_.customFieldMoney)) {
			entity.setCustomFieldMoney(data.getCustomFieldMoney());
		}
		if (data.isFieldChanged(MyEntity3343PickPick0DTO_.customFieldRadio)) {
			entity.setCustomFieldRadio(data.getCustomFieldRadio());
		}
		if (data.isFieldChanged(MyEntity3343PickPick0DTO_.customFieldPicktreeId)) {
			entity.setCustomFieldPicktreeEntity(data.getCustomFieldPicktreeId() != null
					? entityManager.getReference(MyEntity3343PickPicktree.class, data.getCustomFieldPicktreeId())
					: null);
		}
		if (data.isFieldChanged(MyEntity3343PickPick0DTO_.customFieldInlinePicktreeId)) {
			entity.setCustomFieldInlinePicktreeEntity(data.getCustomFieldInlinePicktreeId() != null
					? entityManager.getReference(MyEntity3343PickInlinePicktree.class, data.getCustomFieldInlinePicktreeId())
					: null);
		}
		if (data.isFieldChanged(MyEntity3343PickPick0DTO_.customFieldMultivalue)) {
			entity.getCustomFieldMultivalueList().clear();
			entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldMultivalue().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3343Multi.class, e))
					.toList());
		}
		if (data.isFieldChanged(MyEntity3343PickPick0DTO_.customFieldMultivalueHover)) {
			entity.getCustomFieldMultivalueHoverList().clear();
			entity.getCustomFieldMultivalueHoverList().addAll(data.getCustomFieldMultivalueHover().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3343MultiMulti.class, e))
					.toList());
		}
		repository.save(entity);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}


}