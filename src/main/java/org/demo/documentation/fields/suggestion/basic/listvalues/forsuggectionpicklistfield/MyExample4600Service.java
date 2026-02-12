package org.demo.documentation.fields.suggestion.basic.listvalues.forsuggectionpicklistfield;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings({"java:S1170", "java:S2387"})
@RequiredArgsConstructor
@Service
public class MyExample4600Service extends AnySourceVersionAwareResponseService<MyExample4600DTO, MyEntity4600OutServiceDTO> {


	@Getter(onMethod_ = @Override)
	private final Class<MyExample4600Meta> meta = MyExample4600Meta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyEntity4600Dao> dao = MyEntity4600Dao.class;


	@Override
	protected CreateResult<MyExample4600DTO> doCreateEntity(MyEntity4600OutServiceDTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4600DTO> doUpdateEntity(MyEntity4600OutServiceDTO entity, MyExample4600DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample4600DTO> getActions() {
		return Actions.<MyExample4600DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel"))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}


}