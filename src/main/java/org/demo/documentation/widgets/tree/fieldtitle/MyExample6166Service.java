package org.demo.documentation.widgets.tree.fieldtitle;

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
public class MyExample6166Service extends VersionAwareResponseService<MyExample6166DTO, Myexample3262> {

	private final MyEntity3262Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample6166Meta> meta = MyExample6166Meta.class;

	@Override
	protected CreateResult<MyExample6166DTO> doCreateEntity(Myexample3262 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample6166DTO> doUpdateEntity(Myexample3262 entity, MyExample6166DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample6166DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample6166DTO> getActions() {
		return Actions.<MyExample6166DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
}
