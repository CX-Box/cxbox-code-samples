package org.demo.documentation.widgets.relationGraph.showcondition;

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
public class MyExample6153FormService extends VersionAwareResponseService<MyExample6153FormDTO, MyEntity6153> {

	private final MyEntity6153Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample6153FormMeta> meta = MyExample6153FormMeta.class;

	@Override
	protected CreateResult<MyExample6153FormDTO> doCreateEntity(MyEntity6153 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample6153FormDTO> doUpdateEntity(MyEntity6153 entity, MyExample6153FormDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample6153FormDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample6153FormDTO> getActions() {
		return Actions.<MyExample6153FormDTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
}
