package org.demo.documentation.widgets.tree.any.data.departments;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.demo.repository.core.MydepartmentsRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class MydepartmentsService extends VersionAwareResponseService<MydepartmentsDTO, Mydepartments> {

	@Getter(onMethod_ = @Override)
	private final Class<MydepartmentsMetaBuilder> meta = MydepartmentsMetaBuilder.class;

	private final MydepartmentsRepository mydepartmentsRepository;


	@Override
	protected Specification<Mydepartments> getSpecification(BusinessComponent bc) {
		return super.getSpecification(bc);
	}

	@Override
	protected CreateResult<MydepartmentsDTO> doCreateEntity(Mydepartments entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, mydepartmentsRepository.save(entity)));
	}

	@Override
	protected ActionResultDTO<MydepartmentsDTO> doUpdateEntity(Mydepartments entity, MydepartmentsDTO data, BusinessComponent bc) {
		setIfChanged(data, MydepartmentsDTO_.departmentName, entity::setDepartmentName);
		return new ActionResultDTO<>(entityToDto(bc, mydepartmentsRepository.save(entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<MydepartmentsDTO> getActions() {
		return Actions.<MydepartmentsDTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}

}
