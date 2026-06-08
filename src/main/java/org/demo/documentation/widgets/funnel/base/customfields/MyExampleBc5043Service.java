package org.demo.documentation.widgets.funnel.base.customfields;

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
public class MyExampleBc5043Service extends AnySourceVersionAwareResponseService<MyExampleBc5043DTO, MyExampleBc5043DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5043MetaBuilder> meta = MyExampleBc5043MetaBuilder.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5043DAO> dao = MyExampleBc5043DAO.class;

	@Override
	protected CreateResult<MyExampleBc5043DTO> doCreateEntity(MyExampleBc5043DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, getBaseDao().create(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	protected ActionResultDTO<MyExampleBc5043DTO> doUpdateEntity(MyExampleBc5043DTO entity, MyExampleBc5043DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExampleBc5043DTO_.funnelKey, entity::setFunnelKey);
		setIfChanged(data, MyExampleBc5043DTO_.amount, entity::setAmount);
		return new ActionResultDTO<>(entityToDto(bc, getBaseDao().update(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<MyExampleBc5043DTO> getActions() {
		return Actions.<MyExampleBc5043DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}
}