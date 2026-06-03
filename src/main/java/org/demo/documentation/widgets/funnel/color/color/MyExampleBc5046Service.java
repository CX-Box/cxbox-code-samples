package org.demo.documentation.widgets.funnel.color.color;

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
public class MyExampleBc5046Service extends AnySourceVersionAwareResponseService<MyExampleBc5046DTO, MyExampleBc5046DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5046MetaBuilder> meta = MyExampleBc5046MetaBuilder.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5046DAO> dao = MyExampleBc5046DAO.class;

	@Override
	protected CreateResult<MyExampleBc5046DTO> doCreateEntity(MyExampleBc5046DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, getBaseDao().create(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	protected ActionResultDTO<MyExampleBc5046DTO> doUpdateEntity(MyExampleBc5046DTO entity, MyExampleBc5046DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExampleBc5046DTO_.funnelKey, entity::setFunnelKey);
		setIfChanged(data, MyExampleBc5046DTO_.amount, entity::setAmount);
		return new ActionResultDTO<>(entityToDto(bc, getBaseDao().update(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<MyExampleBc5046DTO> getActions() {
		return Actions.<MyExampleBc5046DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}
}