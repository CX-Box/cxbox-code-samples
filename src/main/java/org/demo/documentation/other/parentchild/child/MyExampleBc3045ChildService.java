package org.demo.documentation.other.parentchild.child;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.entity.BaseEntity_;
import org.demo.documentation.other.parentchild.PlatformMyExample3045Controller;
import org.demo.documentation.other.parentchild.parent.MyExampleBc3045Repository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class MyExampleBc3045ChildService extends VersionAwareResponseService<MyExampleBc3045ChildDTO, MyExampleBc3045Child> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExampleBc3045ChildMetaBuilder> meta = MyExampleBc3045ChildMetaBuilder.class;

	private final MyExampleBc3045ChildRepository myExampleBc3045ChildRepository;

	private final MyExampleBc3045Repository myExampleBc3045Repository;


	@Override
	protected Specification<MyExampleBc3045Child> getSpecification(BusinessComponent bc) {
		if (PlatformMyExample3045Controller.myExampleBc3045Child.isBc(bc)) {
			return (root, cq, cb) ->
					cb.and(
							cb.equal(root.get(MyExampleBc3045Child_.myExampleBc3045).get(BaseEntity_.id), bc.getParentIdAsLong())
					);
		}
		return super.getSpecification(bc);
	}

	@Override
	protected CreateResult<MyExampleBc3045ChildDTO> doCreateEntity(MyExampleBc3045Child entity, BusinessComponent bc) {
		entity.setMyExampleBc3045(myExampleBc3045Repository.findById(bc.getParentIdAsLong()).orElse(null));
		return new CreateResult<>(entityToDto(bc, myExampleBc3045ChildRepository.save(entity)));
	}

	@Override
	protected ActionResultDTO<MyExampleBc3045ChildDTO> doUpdateEntity(MyExampleBc3045Child entity, MyExampleBc3045ChildDTO data, BusinessComponent bc) {
        setIfChanged(data, MyExampleBc3045ChildDTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, myExampleBc3045ChildRepository.save(entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<MyExampleBc3045ChildDTO> getActions() {
		return Actions.<MyExampleBc3045ChildDTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}

}
