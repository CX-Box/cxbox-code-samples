package org.demo.documentation.widgets.line2d.showcondition;

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
public class MyExample4242FormService extends VersionAwareResponseService<MyExample4242FormDTO, MyEntity4242> {

	private final MyEntity4242Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4242FormMeta> meta = MyExample4242FormMeta.class;

	@Override
	protected CreateResult<MyExample4242FormDTO> doCreateEntity(MyEntity4242 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4242FormDTO> doUpdateEntity(MyEntity4242 entity, MyExample4242FormDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample4242FormDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample4242FormDTO> getActions() {
		return Actions.<MyExample4242FormDTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
}
