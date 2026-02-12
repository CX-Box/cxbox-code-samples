package org.demo.documentation.other.savewithparent.example443.parent;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings({"java:S1170", "java:S2387"})
@RequiredArgsConstructor
@Service
public class MyExample3076Service extends AnySourceVersionAwareResponseService<MyExample3076DTO, MyEntity3076OutServiceDTO> {


	@Getter(onMethod_ = @Override)
	private final Class<MyExample3076Meta> meta = MyExample3076Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3076Dao> dao = MyEntity3076Dao.class;


	@Override
	protected CreateResult<MyExample3076DTO> doCreateEntity(MyEntity3076OutServiceDTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity))
				.setAction(PostAction.drillDown(
						DrillDownType.INNER,
						"/screen/myexample3076/view/myexample3076/"
								+ CxboxMyExample3076Controller.myexample3076 + "/"
								+ entity.getId()));
	}

	@Override
	protected ActionResultDTO<MyExample3076DTO> doUpdateEntity(MyEntity3076OutServiceDTO entity, MyExample3076DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3076DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		if (data.isFieldChanged(MyExample3076DTO_.customFieldNew)) {
			entity.setCustomFieldNew(data.getCustomFieldNew());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3076DTO> getActions() {
		return Actions.<MyExample3076DTO>builder()
				.create(crt -> crt.text("Add parent").withAutoSaveBefore()
				)

				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
				.build();
	}

}