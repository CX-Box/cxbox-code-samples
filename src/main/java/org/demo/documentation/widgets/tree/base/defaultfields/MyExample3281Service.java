package org.demo.documentation.widgets.tree.base.defaultfields;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.tree.base.allType.repository.MyEntity3262Repository;
import org.demo.documentation.widgets.tree.data.alltypes.Myexample3262;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3281Service extends VersionAwareResponseService<MyExample3281DTO, Myexample3262> {

	private final MyEntity3262Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3281Meta> meta = MyExample3281Meta.class;

	@Override
	protected CreateResult<MyExample3281DTO> doCreateEntity(Myexample3262 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3281DTO> doUpdateEntity(Myexample3262 entity, MyExample3281DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3281DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3281DTO> getActions() {
		return Actions.<MyExample3281DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]
}
