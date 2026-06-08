package org.demo.documentation.widgets.funnel.title.withtitle;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Getter
@Service
@RequiredArgsConstructor
public class MyExampleBc5054Service extends AnySourceVersionAwareResponseService<MyExampleBc5054DTO, MyExampleBc5054DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5054MetaBuilder> meta = MyExampleBc5054MetaBuilder.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5054DAO> dao = MyExampleBc5054DAO.class;

	@Override
	protected CreateResult<MyExampleBc5054DTO> doCreateEntity(MyExampleBc5054DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, getBaseDao().create(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	protected ActionResultDTO<MyExampleBc5054DTO> doUpdateEntity(MyExampleBc5054DTO entity, MyExampleBc5054DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExampleBc5054DTO_.funnelKey, entity::setFunnelKey);
		setIfChanged(data, MyExampleBc5054DTO_.amount, entity::setAmount);
		return new ActionResultDTO<>(entityToDto(bc, getBaseDao().update(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<MyExampleBc5054DTO> getActions() {
		return Actions.<MyExampleBc5054DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}
}