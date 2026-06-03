package org.demo.documentation.widgets.funnel.color.colorconst;

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
public class MyExampleBc5045Service extends AnySourceVersionAwareResponseService<MyExampleBc5045DTO, MyExampleBc5045DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5045MetaBuilder> meta = MyExampleBc5045MetaBuilder.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5045DAO> dao = MyExampleBc5045DAO.class;

	@Override
	protected CreateResult<MyExampleBc5045DTO> doCreateEntity(MyExampleBc5045DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, getBaseDao().create(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	protected ActionResultDTO<MyExampleBc5045DTO> doUpdateEntity(MyExampleBc5045DTO entity, MyExampleBc5045DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExampleBc5045DTO_.funnelKey, entity::setFunnelKey);
		setIfChanged(data, MyExampleBc5045DTO_.amount, entity::setAmount);
		return new ActionResultDTO<>(entityToDto(bc, getBaseDao().update(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<MyExampleBc5045DTO> getActions() {
		return Actions.<MyExampleBc5045DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}
}