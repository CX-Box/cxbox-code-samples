package org.demo.documentation.widgets.list.actions.edit.withwidget;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.fileupload.required.MyEntity101;
import org.demo.documentation.fields.percent.validationbusinessex.MyEntity10;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.list.actions.edit.withwidget.MyEntity10PickMeta;


@SuppressWarnings("java:S1170")
@Getter
@Service
@RequiredArgsConstructor
public class MyEntity10PickService extends VersionAwareResponseService<MyEntity10PickDTO, MyEntity10> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity10PickMeta> meta = MyEntity10PickMeta.class;

	@Autowired
	private EntityManager entityManager;

	@Override
    protected CreateResult<MyEntity10PickDTO> doCreateEntity(MyEntity10 entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity10PickDTO> doUpdateEntity(MyEntity10 entity, MyEntity10PickDTO data,
                                                                BusinessComponent bc) {
		if (data.isFieldChanged(MyEntity10PickDTO_.dfgdfgdId)) {
			entity.setDfgdfgdEntity(data.getDfgdfgdId() != null
					? entityManager.getReference(MyEntity101.class, data.getDfgdfgdId())
					: null);
		}
		setIfChanged(data, MyEntity10PickDTO_.customFieldText, entity::setCustomFieldText);
		return new ActionResultDTO<>(entityToDto(bc, entity));
    }

	@Override
	public Actions<MyEntity10PickDTO> getActions() {
		return Actions.<MyEntity10PickDTO>builder()
				.save(sv -> sv.text("Save"))
				.action(act -> act
						.action("edit", "Edit"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.build();
	}

}