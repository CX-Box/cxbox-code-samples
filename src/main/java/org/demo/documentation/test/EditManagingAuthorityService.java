package org.demo.documentation.test;


import jakarta.persistence.criteria.Root;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;
import org.demo.documentation.fields.checkbox.basic.enums.TypesEnum;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Getter
@RequiredArgsConstructor
public class EditManagingAuthorityService extends VersionAwareResponseService<EditManagingAuthorityDTO, EditManagingAuthority> {

	@Getter(onMethod_ = @Override)
	private final Class<EditManagingAuthorityMetaBuilder> meta = EditManagingAuthorityMetaBuilder.class;

	private final EditManagingAuthorityRepository editManagingAuthorityRepository;


	@Override
	protected Specification<EditManagingAuthority> getSpecification(BusinessComponent bc) {
		return super.getSpecification(bc);
	}
	@Override
	protected Specification<EditManagingAuthority> getParentSpecification(BusinessComponent bc) {
		return (root, cq, cb) -> {
			Root<EditManagingAuthority> rootManagingAuthority = cb.treat(root, EditManagingAuthority.class);
			return cb.and(
					cb.equal(rootManagingAuthority.get(EditManagingAuthority_.party).get(BaseEntity_.ID), bc.getParentIdAsLong())
			);
		};
	}
	@Override
	protected CreateResult<EditManagingAuthorityDTO> doCreateEntity(EditManagingAuthority entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, editManagingAuthorityRepository.save(entity)));
	}

	@Override
	protected ActionResultDTO<EditManagingAuthorityDTO> doUpdateEntity(EditManagingAuthority entity, EditManagingAuthorityDTO data, BusinessComponent bc) {
		setIfChanged(data, EditManagingAuthorityDTO_.otherType, entity::setOtherType);
		if (data.isFieldChanged(EditManagingAuthorityDTO_.types)) {
			entity.setTypes(
					data.getTypes().getValues()
							.stream()
							.map(v -> TypesEnum.getByValue(v.getValue()))
							.collect(Collectors.toSet()));
		}
		setIfChanged(data, EditManagingAuthorityDTO_.partyInn, entity::setPartyInn);
		setIfChanged(data, EditManagingAuthorityDTO_.partyName, entity::setPartyName);
		setIfChanged(data, EditManagingAuthorityDTO_.partyType, entity::setPartyType);
		return new ActionResultDTO<>(entityToDto(bc, editManagingAuthorityRepository.save(entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<EditManagingAuthorityDTO> getActions() {
		return Actions.<EditManagingAuthorityDTO>builder()
				.save(sv -> sv
						.text("Button.SAVE")
						.withoutIcon())
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.action(act -> act
						.action("saveManagingAuthorityEdit", "Button.SAVE")
						.invoker(this::saveManagingAuthorityEdit))				.build();
	}
	private ActionResultDTO<EditManagingAuthorityDTO> saveManagingAuthorityEdit(
			@NotNull BusinessComponent bc,
			EditManagingAuthorityDTO dto
	) {
		return doUpdateEntity(loadEntity(bc, dto), dto, bc).setAction(PostAction.drillDown(
						DrillDownType.INNER,
						""
						)

		);
	}

}
