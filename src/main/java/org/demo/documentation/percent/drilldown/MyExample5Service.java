package org.demo.documentation.percent.drilldown;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample5Service extends VersionAwareResponseService<MyExample5DTO, MyEntity5> {

	private final MyEntity5Repository repository;

	public MyExample5Service(MyEntity5Repository repository) {
		super(MyExample5DTO.class, MyEntity5.class, null, MyExample5Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample5DTO> doCreateEntity(MyEntity5 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5DTO> doUpdateEntity(MyEntity5 entity, MyExample5DTO data, BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample5DTO> getActions() {
		return Actions.<MyExample5DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}