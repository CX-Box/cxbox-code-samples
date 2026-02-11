package org.demo.documentation.widgets.dashboardlist.base;


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
public class MyExampleBc5040Service extends VersionAwareResponseService<MyExampleBc5040DTO, MyExampleBc5040> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5040MetaBuilder> meta = MyExampleBc5040MetaBuilder.class;

	private final MyExampleBc5040Repository myExampleBc5040Repository;


	@Override
	protected Specification<MyExampleBc5040> getSpecification(BusinessComponent bc) {
		return super.getSpecification(bc);
	}

	@Override
	protected CreateResult<MyExampleBc5040DTO> doCreateEntity(MyExampleBc5040 entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, myExampleBc5040Repository.save(entity)));
	}

	@Override
	protected ActionResultDTO<MyExampleBc5040DTO> doUpdateEntity(MyExampleBc5040 entity, MyExampleBc5040DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExampleBc5040DTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, myExampleBc5040Repository.save(entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<MyExampleBc5040DTO> getActions() {
		return Actions.<MyExampleBc5040DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}

}
