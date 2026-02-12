package org.demo.documentation.navigation.tab.typestandard.defaultview.typicalexample;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3238Service extends VersionAwareResponseService<MyExample3238DTO, MyEntity3238> {

	private final MyEntity3238Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3238Meta> meta = MyExample3238Meta.class;

	@Override
	protected CreateResult<MyExample3238DTO> doCreateEntity(MyEntity3238 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3238DTO> doUpdateEntity(MyEntity3238 entity, MyExample3238DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample3238DTO_.status, entity::setStatus);
		setIfChanged(data, MyExample3238DTO_.address, entity::setAddress);
		setIfChanged(data, org.demo.documentation.navigation.tab.typestandard.defaultview.typicalexample.MyExample3238DTO_.fullName, entity::setFullName);
		if (data.isFieldChanged(MyExample3238DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample3238DTO> getActions() {
		return Actions.<MyExample3238DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}

