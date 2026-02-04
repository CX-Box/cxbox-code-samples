package org.demo.documentation.test;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class EditLegalEntityService extends VersionAwareResponseService<EditLegalEntityDTO, EditLegalEntity> {

	@Getter(onMethod_ = @Override)
	private final Class<EditLegalEntityMetaBuilder> meta = EditLegalEntityMetaBuilder.class;

	private final EditLegalEntityRepository editLegalEntityRepository;

	@Override
	protected Specification<EditLegalEntity> getSpecification(BusinessComponent bc) {
		return super.getSpecification(bc);
	}

	@Override
	protected CreateResult<EditLegalEntityDTO> doCreateEntity(EditLegalEntity entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, editLegalEntityRepository.save(entity)));
	}

	@Override
	protected ActionResultDTO<EditLegalEntityDTO> doUpdateEntity(EditLegalEntity entity, EditLegalEntityDTO data, BusinessComponent bc) {
		setIfChanged(data, EditLegalEntityDTO_.sdsad, entity::setSdsad);
		return new ActionResultDTO<>(entityToDto(bc, editLegalEntityRepository.save(entity))
		);
	}

	@Override
	public Actions<EditLegalEntityDTO> getActions() {
		return Actions.<EditLegalEntityDTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.action(act -> act
						.action("finishEditAssociatedPersonsLegal", "Finish Edit Associated Persons Legal")
						.scope(ActionScope.BC)
						.available(bc -> {
							return true;
						})
						.invoker((bc, dto) -> {
							EditLegalEntity legalEntity = editLegalEntityRepository.getReferenceById(bc.getIdAsLong());

							return doUpdateEntity(legalEntity, dto, bc).setAction(PostAction.drillDown(
									DrillDownType.INNER, "/screen/myexampletest/" + PlatformMyExampletestController.editLegalEntity));

						})
				)
				.build();
	}

}
