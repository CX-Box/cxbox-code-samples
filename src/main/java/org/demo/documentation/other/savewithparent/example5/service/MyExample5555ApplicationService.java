package org.demo.documentation.other.savewithparent.example5.service;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.other.savewithparent.example5.dto.ApplicationEntityDTO;
import org.demo.documentation.other.savewithparent.example5.dto.ApplicationEntityDTO_;
import org.demo.documentation.other.savewithparent.example5.entity.ApplicationEntity;
import org.demo.documentation.other.savewithparent.example5.enums.StatusEnum;
import org.demo.documentation.other.savewithparent.example5.repositories.ApplicationRepository;
import org.springframework.stereotype.Service;

@Service
public class MyExample5555ApplicationService extends
		VersionAwareResponseService<ApplicationEntityDTO, ApplicationEntity> {

	private final ApplicationRepository repository;

	public MyExample5555ApplicationService(ApplicationRepository repository) {
		super(ApplicationEntityDTO.class, ApplicationEntity.class, null, MyExample5555ApplicationMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<ApplicationEntityDTO> doCreateEntity(ApplicationEntity entity, BusinessComponent bc) {
		entity.setStatus(StatusEnum.NEW);
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<ApplicationEntityDTO> doUpdateEntity(ApplicationEntity entity, ApplicationEntityDTO data,
			BusinessComponent bc) {
		setIfChanged(data, ApplicationEntityDTO_.name, entity::setName);
		setIfChanged(data, ApplicationEntityDTO_.status, entity::setStatus);
		setIfChanged(data, ApplicationEntityDTO_.createdDate, entity::setCreatedDate);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<ApplicationEntityDTO> getActions() {
		return Actions.<ApplicationEntityDTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}
