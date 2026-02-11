package org.demo.documentation.widgets.funnel.base.data;


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
public class MyExampleBc5042Service extends VersionAwareResponseService<MyExampleBc5042DTO, MyExampleBc5042> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5042MetaBuilder> meta = MyExampleBc5042MetaBuilder.class;

	private final MyExampleBc5042Repository myExampleBc5042Repository;


	@Override
	protected Specification<MyExampleBc5042> getSpecification(BusinessComponent bc) {
		return super.getSpecification(bc);
	}

	@Override
	protected CreateResult<MyExampleBc5042DTO> doCreateEntity(MyExampleBc5042 entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, myExampleBc5042Repository.save(entity)));
	}

	@Override
	protected ActionResultDTO<MyExampleBc5042DTO> doUpdateEntity(MyExampleBc5042 entity, MyExampleBc5042DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExampleBc5042DTO_.customFieldNum, entity::setCustomFieldNum);
		return new ActionResultDTO<>(entityToDto(bc, myExampleBc5042Repository.save(entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<MyExampleBc5042DTO> getActions() {
		return Actions.<MyExampleBc5042DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}

}
