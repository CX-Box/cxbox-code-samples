package org.demo.documentation.widgets.tree.any.data.users;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.demo.repository.core.My3261UsersRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class My3261UsersService extends VersionAwareResponseService<My3261UsersDTO, My3261Users> {

	@Getter(onMethod_ = @Override)
	private final Class<My3261UsersMetaBuilder> meta = My3261UsersMetaBuilder.class;

	private final My3261UsersRepository my3261UsersRepository;


	@Override
	protected Specification<My3261Users> getSpecification(BusinessComponent bc) {
		return super.getSpecification(bc);
	}

	@Override
	protected CreateResult<My3261UsersDTO> doCreateEntity(My3261Users entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, my3261UsersRepository.save(entity)));
	}

	@Override
	protected ActionResultDTO<My3261UsersDTO> doUpdateEntity(My3261Users entity, My3261UsersDTO data, BusinessComponent bc) {
		setIfChanged(data, My3261UsersDTO_.middleName, entity::setMiddleName);
		setIfChanged(data, My3261UsersDTO_.firstName, entity::setFirstName);
		setIfChanged(data, My3261UsersDTO_.lastName, entity::setLastName);
		return new ActionResultDTO<>(entityToDto(bc, my3261UsersRepository.save(entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<My3261UsersDTO> getActions() {
		return Actions.<My3261UsersDTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}

}
