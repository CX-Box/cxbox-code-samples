package org.demo.documentation.widgets.column2d.showcondition;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample4276FormService extends VersionAwareResponseService<MyExample4276FormDTO, MyEntity4276> {

	private final MyEntity4276Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4276FormMeta> meta = MyExample4276FormMeta.class;

	@Override
	protected CreateResult<MyExample4276FormDTO> doCreateEntity(MyEntity4276 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4276FormDTO> doUpdateEntity(MyEntity4276 entity, MyExample4276FormDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample4276FormDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample4276FormDTO> getActions() {
		return Actions.<MyExample4276FormDTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}

}
