package org.demo.documentation.widgets.funnel.icon.withicon;

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
public class MyExampleBc5050Service extends AnySourceVersionAwareResponseService<MyExampleBc5050DTO, MyExampleBc5050DTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5050MetaBuilder> meta = MyExampleBc5050MetaBuilder.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc5050DAO> dao = MyExampleBc5050DAO.class;

	@Override
	protected CreateResult<MyExampleBc5050DTO> doCreateEntity(MyExampleBc5050DTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, getBaseDao().create(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	protected ActionResultDTO<MyExampleBc5050DTO> doUpdateEntity(MyExampleBc5050DTO entity, MyExampleBc5050DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExampleBc5050DTO_.funnelKey, entity::setFunnelKey);
		setIfChanged(data, MyExampleBc5050DTO_.amount, entity::setAmount);
		return new ActionResultDTO<>(entityToDto(bc, getBaseDao().update(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<MyExampleBc5050DTO> getActions() {
		return Actions.<MyExampleBc5050DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}
}