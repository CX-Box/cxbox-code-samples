package org.demo.documentation.widgets.calendaryearlist.base;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class MyExampleBc5039Service extends VersionAwareResponseService<MyExampleBc5039DTO, MyExampleBc5039> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5039MetaBuilder> meta = MyExampleBc5039MetaBuilder.class;

	private final MyExampleBc5039Repository myExampleBc5039Repository;


	@Override
	protected Specification<MyExampleBc5039> getSpecification(BusinessComponent bc) {
		return super.getSpecification(bc);
	}

	@Override
	protected CreateResult<MyExampleBc5039DTO> doCreateEntity(MyExampleBc5039 entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, myExampleBc5039Repository.save(entity)));
	}

	@Override
	protected ActionResultDTO<MyExampleBc5039DTO> doUpdateEntity(MyExampleBc5039 entity, MyExampleBc5039DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExampleBc5039DTO_.endDateTime, entity::setEndDateTime);
		setIfChanged(data, MyExampleBc5039DTO_.startDateTime, entity::setStartDateTime);
		setIfChanged(data, MyExampleBc5039DTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, myExampleBc5039Repository.save(entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<MyExampleBc5039DTO> getActions() {
		return Actions.<MyExampleBc5039DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}

}
