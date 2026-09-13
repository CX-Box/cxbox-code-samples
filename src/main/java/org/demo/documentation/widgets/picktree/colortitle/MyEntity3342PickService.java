package org.demo.documentation.widgets.picktree.colortitle;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.picktree.colortitle.forfields.MyEntity3342Multi;
import org.demo.documentation.widgets.picktree.colortitle.forfields.MyEntity3342MultiMulti;
import org.demo.documentation.widgets.picktree.colortitle.forfields.MyEntity3342Pick;
import org.demo.documentation.widgets.picktree.colortitle.forfields.MyEntity3342PickPick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3342PickService extends VersionAwareResponseService<MyEntity3342PickDTO, MyEntity3342> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3342PickMeta> meta = MyEntity3342PickMeta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyEntity3342PickDTO> doCreateEntity(MyEntity3342 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3342PickDTO> doUpdateEntity(MyEntity3342 entity, MyEntity3342PickDTO data,
																  BusinessComponent bc) {
		setIfChanged(data, MyEntity3342PickDTO_.customFieldColorText, entity::setCustomFieldColorText);
		setIfChanged(data, MyEntity3342PickDTO_.customFieldColorInput, entity::setCustomFieldColorInput);
		if (data.isFieldChanged(MyEntity3342PickDTO_.customFieldColorDateTime)) {
			entity.setCustomFieldColorDateTime(data.getCustomFieldColorDateTime());
		}
		if (data.isFieldChanged(MyEntity3342PickDTO_.customFieldColorCheckbox)) {
			entity.setCustomFieldColorCheckbox(data.getCustomFieldColorCheckbox());
		}
		if (data.isFieldChanged(MyEntity3342PickDTO_.customFieldColorDate)) {
			entity.setCustomFieldColorDate(data.getCustomFieldColorDate());
		}
		if (data.isFieldChanged(MyEntity3342PickDTO_.customFieldColorDateTimeWithSeconds)) {
			entity.setCustomFieldColorDateTimeWithSeconds(data.getCustomFieldColorDateTimeWithSeconds());
		}
		if (data.isFieldChanged(MyEntity3342PickDTO_.customFieldColorDictionary)) {
			entity.setCustomFieldColorDictionary(data.getCustomFieldColorDictionary());
		}
		if (data.isFieldChanged(MyEntity3342PickDTO_.customFieldColorFileUploadeId)) {
			entity.setCustomFieldColorFileUploadeId(data.getCustomFieldColorFileUploadeId());
		}
		if (data.isFieldChanged(MyEntity3342PickDTO_.customFieldColorFileUploade)) {
			entity.setCustomFieldColorFileUploade(data.getCustomFieldColorFileUploade());
		}
		if (data.isFieldChanged(MyEntity3342PickDTO_.customFieldColorFileUploadeId)) {
			entity.setCustomFieldColorFileUploadeId(data.getCustomFieldColorFileUploadeId());
		}
		if (data.isFieldChanged(MyEntity3342PickDTO_.customFieldColorFileUploade)) {
			entity.setCustomFieldColorFileUploade(data.getCustomFieldColorFileUploade());
		}
		if (data.isFieldChanged(MyEntity3342PickDTO_.customFieldColorNumber)) {
			entity.setCustomFieldColorNumber(data.getCustomFieldColorNumber());
		}
		if (data.isFieldChanged(MyEntity3342PickDTO_.customFieldColorPercent)) {
			entity.setCustomFieldColorPercent(data.getCustomFieldColorPercent());
		}
		if (data.isFieldChanged(MyEntity3342PickDTO_.customFieldColorMoney)) {
			entity.setCustomFieldColorMoney(data.getCustomFieldColorMoney());
		}
		if (data.isFieldChanged(MyEntity3342PickDTO_.customFieldColorRadio)) {
			entity.setCustomFieldColorRadio(data.getCustomFieldColorRadio());
		}
		if (data.isFieldChanged(MyEntity3342PickDTO_.customFieldColorPicktreeId)) {
			entity.setCustomFieldColorPicktreeEntity(data.getCustomFieldColorPicktreeId() != null
					? entityManager.getReference(MyEntity3342PickPick.class, data.getCustomFieldColorPicktreeId())
					: null);
		}
		if (data.isFieldChanged(MyEntity3342PickDTO_.customFieldColorInlinePicktreeId)) {
			entity.setCustomFieldColorInlinePicktreeEntity(data.getCustomFieldColorInlinePicktreeId() != null
					? entityManager.getReference(MyEntity3342Pick.class, data.getCustomFieldColorInlinePicktreeId())
					: null);
		}
		if (data.isFieldChanged(MyEntity3342PickDTO_.customFieldColorMultivalue)) {
			entity.getCustomFieldColorMultivalueList().clear();
			entity.getCustomFieldColorMultivalueList().addAll(data.getCustomFieldColorMultivalue().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3342MultiMulti.class, e))
					.toList());
		}
		if (data.isFieldChanged(MyEntity3342PickDTO_.customFieldColorMultivalueHover)) {
			entity.getCustomFieldColorMultivalueHoverList().clear();
			entity.getCustomFieldColorMultivalueHoverList().addAll(data.getCustomFieldColorMultivalueHover().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3342Multi.class, e))
					.toList());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}


}