package org.demo.documentation.widgets.assoctree.colortitle.allfields;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.assoctree.colortitle.allfields.forfields.MyEntity3329MultiAssoc;
import org.demo.documentation.widgets.assoctree.colortitle.allfields.forfields.MyEntity3329MultiMultiAssoc;
import org.demo.documentation.widgets.assoctree.colortitle.allfields.forfields.MyEntity3329Picklist;
import org.demo.documentation.widgets.assoctree.colortitle.allfields.forfields.MyEntity3329PicklistAssoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3329MultiMultivalueService extends VersionAwareResponseService<MyEntity3329MultiMultivalueDTO, MyEntity3329Multi> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3329MultiMultivalueMeta> meta = MyEntity3329MultiMultivalueMeta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyEntity3329MultiMultivalueDTO> doCreateEntity(MyEntity3329Multi entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3329MultiMultivalueDTO> doUpdateEntity(MyEntity3329Multi entity, MyEntity3329MultiMultivalueDTO data,
																			 BusinessComponent bc) {
		if (data.isFieldChanged(MyEntity3329MultiMultivalueDTO_.customFieldColorInput)) {
			entity.setCustomFieldColorInput(data.getCustomFieldColorInput());
		}
		if (data.isFieldChanged(MyEntity3329MultiMultivalueDTO_.customFieldColorText)) {
			entity.setCustomFieldColorText(data.getCustomFieldColorText());
		}
		if (data.isFieldChanged(MyEntity3329MultiMultivalueDTO_.customFieldColorDateTime)) {
			entity.setCustomFieldColorDateTime(data.getCustomFieldColorDateTime());
		}
		if (data.isFieldChanged(MyEntity3329MultiMultivalueDTO_.customFieldColorCheckbox)) {
			entity.setCustomFieldColorCheckbox(data.getCustomFieldColorCheckbox());
		}
		if (data.isFieldChanged(MyEntity3329MultiMultivalueDTO_.customFieldColorDate)) {
			entity.setCustomFieldColorDate(data.getCustomFieldColorDate());
		}
		if (data.isFieldChanged(MyEntity3329MultiMultivalueDTO_.customFieldColorDateTimeWithSeconds)) {
			entity.setCustomFieldColorDateTimeWithSeconds(data.getCustomFieldColorDateTimeWithSeconds());
		}
		if (data.isFieldChanged(MyEntity3329MultiMultivalueDTO_.customFieldColorDictionary)) {
			entity.setCustomFieldColorDictionary(data.getCustomFieldColorDictionary());
		}
		if (data.isFieldChanged(MyEntity3329MultiMultivalueDTO_.customFieldColorFileUploadeId)) {
			entity.setCustomFieldColorFileUploadeId(data.getCustomFieldColorFileUploadeId());
		}
		if (data.isFieldChanged(MyEntity3329MultiMultivalueDTO_.customFieldColorFileUploade)) {
			entity.setCustomFieldColorFileUploade(data.getCustomFieldColorFileUploade());
		}
		if (data.isFieldChanged(MyEntity3329MultiMultivalueDTO_.customFieldColorNumber)) {
			entity.setCustomFieldColorNumber(data.getCustomFieldColorNumber());
		}
		if (data.isFieldChanged(MyEntity3329MultiMultivalueDTO_.customFieldColorPercent)) {
			entity.setCustomFieldColorPercent(data.getCustomFieldColorPercent());
		}
		if (data.isFieldChanged(MyEntity3329MultiMultivalueDTO_.customFieldColorMoney)) {
			entity.setCustomFieldColorMoney(data.getCustomFieldColorMoney());
		}
		if (data.isFieldChanged(MyEntity3329MultiMultivalueDTO_.customFieldColorRadio)) {
			entity.setCustomFieldColorRadio(data.getCustomFieldColorRadio());
		}
		if (data.isFieldChanged(MyEntity3329MultiMultivalueDTO_.customFieldColorPicklistId)) {
			entity.setCustomFieldColorPicklistEntity(data.getCustomFieldColorPicklistId() != null
					? entityManager.getReference(MyEntity3329PicklistAssoc.class, data.getCustomFieldColorPicklistId())
					: null);
		}
		if (data.isFieldChanged(MyEntity3329MultiMultivalueDTO_.customFieldColorInlinePicklistId)) {
			entity.setCustomFieldColorInlinePicklistEntity(data.getCustomFieldColorInlinePicklistId() != null
					? entityManager.getReference(MyEntity3329Picklist.class, data.getCustomFieldColorInlinePicklistId())
					: null);
		}
		if (data.isFieldChanged(MyEntity3329MultiMultivalueDTO_.customFieldColorMultivalue)) {
			entity.getCustomFieldColorMultivalueList().clear();
			entity.getCustomFieldColorMultivalueList().addAll(data.getCustomFieldColorMultivalue().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3329MultiMultiAssoc.class, e))
					.toList());
		}
		if (data.isFieldChanged(MyEntity3329MultiMultivalueDTO_.customFieldColorMultivalueHover)) {
			entity.getCustomFieldColorMultivalueHoverList().clear();
			entity.getCustomFieldColorMultivalueHoverList().addAll(data.getCustomFieldColorMultivalueHover().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3329MultiAssoc.class, e))
					.toList());
		}
		return null;
	}


}