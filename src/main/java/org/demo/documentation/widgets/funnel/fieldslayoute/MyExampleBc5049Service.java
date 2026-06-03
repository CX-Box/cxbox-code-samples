package org.demo.documentation.widgets.funnel.fieldslayoute;

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
public class MyExampleBc5049Service extends AnySourceVersionAwareResponseService<MyExampleBc5049DTO, MyExampleBc5049DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5049MetaBuilder> meta = MyExampleBc5049MetaBuilder.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5049DAO> dao = MyExampleBc5049DAO.class;

	@Override
	protected CreateResult<MyExampleBc5049DTO> doCreateEntity(MyExampleBc5049DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, getBaseDao().create(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	protected ActionResultDTO<MyExampleBc5049DTO> doUpdateEntity(MyExampleBc5049DTO entity, MyExampleBc5049DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExampleBc5049DTO_.funnelKey, entity::setFunnelKey);
		setIfChanged(data, MyExampleBc5049DTO_.amount, entity::setAmount);
		return new ActionResultDTO<>(entityToDto(bc, getBaseDao().update(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<MyExampleBc5049DTO> getActions() {
		return Actions.<MyExampleBc5049DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}
}