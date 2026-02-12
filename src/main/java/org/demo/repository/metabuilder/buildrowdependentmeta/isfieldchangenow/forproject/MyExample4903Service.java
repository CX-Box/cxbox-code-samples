package org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.forproject;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.forproject.enums.ChannelEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample4903Service extends VersionAwareResponseService<MyExample4903DTO, MyEntity4903> {

	private final MyEntity4903Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4903Meta> meta = MyExample4903Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample4903DTO> doCreateEntity(MyEntity4903 entity, BusinessComponent bc) {
		entity.setChannel(ChannelEnum.EMAIL);
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4903DTO> doUpdateEntity(MyEntity4903 entity, MyExample4903DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample4903DTO_.nameFileId)) {
			entity.setNameFileEntity(data.getNameFileId() != null
					? entityManager.getReference(MyEntity4903FileNamePick.class, data.getNameFileId())
					: null);
		}
		setIfChanged(data, MyExample4903DTO_.usersName, entity::setUsersName);
		setIfChanged(data, MyExample4903DTO_.channel, entity::setChannel);
		setIfChanged(data, MyExample4903DTO_.fileId, entity::setFileId);
		setIfChanged(data, MyExample4903DTO_.file, entity::setFile);
		if (data.isFieldChanged(MyExample4903DTO_.instanceId)) {
			entity.setInstanceEntity(data.getInstanceId() != null
					? entityManager.getReference(MyEntity4903Instance.class, data.getInstanceId())
					: null);
		}
		setIfChanged(data, MyExample4903DTO_.fileType, entity::setFileType);
		setIfChanged(data, MyExample4903DTO_.objectType, entity::setObjectType);
		if (data.isFieldChanged(MyExample4903DTO_.nameOSPId)) {
			entity.setNameOSPEntity(data.getNameOSPId() != null
					? entityManager.getReference(MyEntity4903OCPPick.class, data.getNameOSPId())
					: null);
		}
		setIfChanged(data, MyExample4903DTO_.placePresentation, entity::setPlacePresentation);
		if (data.isFieldChanged(MyExample4903DTO_.nameFSPPId)) {
			entity.setNameFSPPEntity(data.getNameFSPPId() != null
					? entityManager.getReference(MyEntity4903Pick.class, data.getNameFSPPId())
					: null);
		}
		if (data.isFieldChanged(MyExample4903DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample4903DTO> getActions() {
		return Actions.<MyExample4903DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}