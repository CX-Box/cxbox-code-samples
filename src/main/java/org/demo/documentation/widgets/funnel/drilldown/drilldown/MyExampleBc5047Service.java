package org.demo.documentation.widgets.funnel.drilldown.drilldown;

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
public class MyExampleBc5047Service extends AnySourceVersionAwareResponseService<MyExampleBc5047DTO, MyExampleBc5047DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5047MetaBuilder> meta = MyExampleBc5047MetaBuilder.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5047DAO> dao = MyExampleBc5047DAO.class;

	@Override
	protected CreateResult<MyExampleBc5047DTO> doCreateEntity(MyExampleBc5047DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, getBaseDao().create(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	protected ActionResultDTO<MyExampleBc5047DTO> doUpdateEntity(MyExampleBc5047DTO entity, MyExampleBc5047DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExampleBc5047DTO_.funnelKey, entity::setFunnelKey);
		setIfChanged(data, MyExampleBc5047DTO_.amount, entity::setAmount);
		return new ActionResultDTO<>(entityToDto(bc, getBaseDao().update(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<MyExampleBc5047DTO> getActions() {
		return Actions.<MyExampleBc5047DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}
}