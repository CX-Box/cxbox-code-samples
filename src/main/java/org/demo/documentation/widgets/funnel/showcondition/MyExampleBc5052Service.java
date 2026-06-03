package org.demo.documentation.widgets.funnel.showcondition;

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
public class MyExampleBc5052Service extends AnySourceVersionAwareResponseService<MyExampleBc5052DTO, MyExampleBc5052DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5052MetaBuilder> meta = MyExampleBc5052MetaBuilder.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5052DAO> dao = MyExampleBc5052DAO.class;

	@Override
	protected CreateResult<MyExampleBc5052DTO> doCreateEntity(MyExampleBc5052DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, getBaseDao().create(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	protected ActionResultDTO<MyExampleBc5052DTO> doUpdateEntity(MyExampleBc5052DTO entity, MyExampleBc5052DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExampleBc5052DTO_.funnelKey, entity::setFunnelKey);
		setIfChanged(data, MyExampleBc5052DTO_.amount, entity::setAmount);
		return new ActionResultDTO<>(entityToDto(bc, getBaseDao().update(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<MyExampleBc5052DTO> getActions() {
		return Actions.<MyExampleBc5052DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}
}