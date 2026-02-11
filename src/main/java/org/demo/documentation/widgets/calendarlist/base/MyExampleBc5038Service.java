package org.demo.documentation.widgets.calendarlist.base;


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
public class MyExampleBc5038Service extends VersionAwareResponseService<MyExampleBc5038DTO, MyExampleBc5038> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5038MetaBuilder> meta = MyExampleBc5038MetaBuilder.class;

	private final MyExampleBc5038Repository myExampleBc5038Repository;


	@Override
	protected Specification<MyExampleBc5038> getSpecification(BusinessComponent bc) {
		return super.getSpecification(bc);
	}

	@Override
	protected CreateResult<MyExampleBc5038DTO> doCreateEntity(MyExampleBc5038 entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, myExampleBc5038Repository.save(entity)));
	}

	@Override
	protected ActionResultDTO<MyExampleBc5038DTO> doUpdateEntity(MyExampleBc5038 entity, MyExampleBc5038DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExampleBc5038DTO_.endDateTime, entity::setEndDateTime);
		setIfChanged(data, MyExampleBc5038DTO_.startDateTime, entity::setStartDateTime);
		setIfChanged(data, MyExampleBc5038DTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, myExampleBc5038Repository.save(entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<MyExampleBc5038DTO> getActions() {
		return Actions.<MyExampleBc5038DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}

}
