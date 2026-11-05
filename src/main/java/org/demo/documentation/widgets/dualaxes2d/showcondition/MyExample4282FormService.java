package org.demo.documentation.widgets.dualaxes2d.showcondition;

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
public class MyExample4282FormService extends VersionAwareResponseService<MyExample4282FormDTO, MyEntity4282> {

	private final MyEntity4282Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4282FormMeta> meta = MyExample4282FormMeta.class;

	@Override
	protected CreateResult<MyExample4282FormDTO> doCreateEntity(MyEntity4282 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4282FormDTO> doUpdateEntity(MyEntity4282 entity, MyExample4282FormDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample4282FormDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample4282FormDTO> getActions() {
		return Actions.<MyExample4282FormDTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
}
