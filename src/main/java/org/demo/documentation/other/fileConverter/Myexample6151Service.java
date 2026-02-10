package org.demo.documentation.other.fileConverter;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class Myexample6151Service extends VersionAwareResponseService<Myexample6151DTO, Myexample6151> {

	@Getter(onMethod_ = @Override)
	private final Class<Myexample6151MetaBuilder> meta = Myexample6151MetaBuilder.class;

	private final Myexample6151Repository myexample6151Repository;


	@Override
	protected Specification<Myexample6151> getSpecification(BusinessComponent bc) {
		return super.getSpecification(bc);
	}

	@Override
	protected CreateResult<Myexample6151DTO> doCreateEntity(Myexample6151 entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, myexample6151Repository.save(entity)));
	}

	@Override
	protected ActionResultDTO<Myexample6151DTO> doUpdateEntity(Myexample6151 entity, Myexample6151DTO data, BusinessComponent bc) {
		setIfChanged(data, Myexample6151DTO_.fileName, entity::setFileName);
		setIfChanged(data, Myexample6151DTO_.fileNameId, entity::setFileNameId);

		///
		setIfChanged(data, Myexample6151DTO_.fileNameNAF, entity::setFileName);
		setIfChanged(data, Myexample6151DTO_.fileNameNAFId, entity::setFileNameId);

		return new ActionResultDTO<>(entityToDto(bc, myexample6151Repository.save(entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<Myexample6151DTO> getActions() {
		return Actions.<Myexample6151DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}

}
