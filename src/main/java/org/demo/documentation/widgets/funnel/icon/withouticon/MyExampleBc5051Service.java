package org.demo.documentation.widgets.funnel.icon.withouticon;

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
public class MyExampleBc5051Service extends AnySourceVersionAwareResponseService<MyExampleBc5051DTO, MyExampleBc5051DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5051MetaBuilder> meta = MyExampleBc5051MetaBuilder.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5051DAO> dao = MyExampleBc5051DAO.class;

	@Override
	protected CreateResult<MyExampleBc5051DTO> doCreateEntity(MyExampleBc5051DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, getBaseDao().create(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	protected ActionResultDTO<MyExampleBc5051DTO> doUpdateEntity(MyExampleBc5051DTO entity, MyExampleBc5051DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExampleBc5051DTO_.funnelKey, entity::setFunnelKey);
		setIfChanged(data, MyExampleBc5051DTO_.amount, entity::setAmount);
		return new ActionResultDTO<>(entityToDto(bc, getBaseDao().update(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<MyExampleBc5051DTO> getActions() {
		return Actions.<MyExampleBc5051DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}
}