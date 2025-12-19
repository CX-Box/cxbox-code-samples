package org.demo.documentation;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.demo.repository.core.MyExampleBc832Repository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class MyExampleBc832Service extends VersionAwareResponseService<MyExampleBc832DTO, MyExampleBc832> {

    @Getter(onMethod_ = @Override)
    private final Class<MyExampleBc832MetaBuilder> meta = MyExampleBc832MetaBuilder.class;

    private final MyExampleBc832Repository myExampleBc832Repository;


    @Override
    protected Specification<MyExampleBc832> getSpecification(BusinessComponent bc) {
        return super.getSpecification(bc);
    }

    @Override
    protected CreateResult<MyExampleBc832DTO> doCreateEntity(MyExampleBc832 entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, myExampleBc832Repository.save(entity)));
    }

    @Override
    protected ActionResultDTO<MyExampleBc832DTO> doUpdateEntity(MyExampleBc832 entity, MyExampleBc832DTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, myExampleBc832Repository.save(entity)))
                .setAction(PostAction.refreshBc(bc));
    }

    @Override
    public Actions<MyExampleBc832DTO> getActions() {
        return Actions.<MyExampleBc832DTO>builder()
                .create(crt -> crt.text("Create"))
                .delete(dlt -> dlt.text("Delete"))
                .save(sv -> sv.text("Save"))
                .build();
    }

}
