package org.demo.documentation.other.savewithparent.example2.parent;

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
public class MyExample3131Service extends VersionAwareResponseService<MyExample3131DTO, MyEntity3131> {

	private final MyEntity3131Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3131Meta> meta = MyExample3131Meta.class;

	@Override
	protected CreateResult<MyExample3131DTO> doCreateEntity(MyEntity3131 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3131DTO> doUpdateEntity(MyEntity3131 entity, MyExample3131DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3131DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3131DTO> getActions() {
		return Actions.<MyExample3131DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}


}

