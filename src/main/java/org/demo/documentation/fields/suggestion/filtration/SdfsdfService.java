package org.demo.documentation.fields.suggestion.filtration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
@RequiredArgsConstructor
public class SdfsdfService extends AnySourceVersionAwareResponseService<SdfsdfDTO, SdfsdfDTO> {

	@Getter(onMethod_ = @Override)
	private final Class<SdfsdfMetaBuilder> meta = SdfsdfMetaBuilder.class;

	@Getter(onMethod_ = @Override)
	private final Class<SdfsdfDAO> dao = SdfsdfDAO.class;

	@Override
	protected CreateResult<SdfsdfDTO> doCreateEntity(SdfsdfDTO entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, getBaseDao().create(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	protected ActionResultDTO<SdfsdfDTO> doUpdateEntity(SdfsdfDTO entity, SdfsdfDTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, getBaseDao().create(bc, entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<SdfsdfDTO> getActions() {
		return Actions.<SdfsdfDTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}
}