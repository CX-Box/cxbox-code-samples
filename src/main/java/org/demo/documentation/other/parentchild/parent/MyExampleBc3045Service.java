package org.demo.documentation.other.parentchild.parent;


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
public class MyExampleBc3045Service extends VersionAwareResponseService<MyExampleBc3045DTO, MyExampleBc3045> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc3045MetaBuilder> meta = MyExampleBc3045MetaBuilder.class;

	private final MyExampleBc3045Repository myExampleBc3045Repository;


	@Override
	protected Specification<MyExampleBc3045> getSpecification(BusinessComponent bc) {
		return super.getSpecification(bc);
	}

	@Override
	protected CreateResult<MyExampleBc3045DTO> doCreateEntity(MyExampleBc3045 entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, myExampleBc3045Repository.save(entity)));
	}

	@Override
	protected ActionResultDTO<MyExampleBc3045DTO> doUpdateEntity(MyExampleBc3045 entity, MyExampleBc3045DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExampleBc3045DTO_.customFieldDrilldown, entity::setCustomFieldDrilldown);
		setIfChanged(data, MyExampleBc3045DTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, myExampleBc3045Repository.save(entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<MyExampleBc3045DTO> getActions() {
		return Actions.<MyExampleBc3045DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}

}
