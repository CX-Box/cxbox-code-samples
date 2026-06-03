package org.demo.documentation.widgets.funnel.base.defaultfields;

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
public class MyExampleBc5044Service extends AnySourceVersionAwareResponseService<MyExampleBc5044DTO, MyExampleBc5044DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5044MetaBuilder> meta = MyExampleBc5044MetaBuilder.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5044DAO> dao = MyExampleBc5044DAO.class;

	@Override
	protected CreateResult<MyExampleBc5044DTO> doCreateEntity(MyExampleBc5044DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, getBaseDao().create(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	protected ActionResultDTO<MyExampleBc5044DTO> doUpdateEntity(MyExampleBc5044DTO entity, MyExampleBc5044DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExampleBc5044DTO_.funnelKey, entity::setFunnelKey);
		setIfChanged(data, MyExampleBc5044DTO_.amount, entity::setAmount);
		return new ActionResultDTO<>(entityToDto(bc, getBaseDao().update(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<MyExampleBc5044DTO> getActions() {
		return Actions.<MyExampleBc5044DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}
}