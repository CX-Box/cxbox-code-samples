package org.demo.documentation.feature.encryptsign.encrypt;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.MessageType;
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
public class Myexample3713Service extends VersionAwareResponseService<Myexample3713DTO, Myexample3713> {

	@Getter(onMethod_ = @Override)
	private final Class<Myexample3713MetaBuilder> meta = Myexample3713MetaBuilder.class;

	private final MyEntity3713Repository myexample3713Repository;

	@Override
	protected Specification<Myexample3713> getSpecification(BusinessComponent bc) {
		return super.getSpecification(bc);
	}

	@Override
	protected CreateResult<Myexample3713DTO> doCreateEntity(Myexample3713 entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, myexample3713Repository.save(entity)));
	}

	@Override
	protected ActionResultDTO<Myexample3713DTO> doUpdateEntity(Myexample3713 entity, Myexample3713DTO data, BusinessComponent bc) {

		setIfChanged(data, Myexample3713DTO_.fileEncryptId, entity::setFileEncryptId);
		setIfChanged(data, Myexample3713DTO_.fileEncrypt, entity::setFileEncrypt);
		setIfChanged(data, Myexample3713DTO_.fileId, entity::setFileId);
		setIfChanged(data, Myexample3713DTO_.file, entity::setFile);
		return new ActionResultDTO<>(entityToDto(bc, myexample3713Repository.save(entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<Myexample3713DTO> getActions() {
		return Actions.<Myexample3713DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.action(act -> act
						.action("documentEncrypt", "Document Encrypt")
						.scope(ActionScope.RECORD)
						.available(bc -> {
							// TODO: Write action availability condition here
							return true;
						})
						.invoker((bc, dto) -> {
							// TODO: Write action processing code here
							return new ActionResultDTO<Myexample3713DTO>()
									.setAction(PostAction.showMessage(
											MessageType.INFO, "Action documentEncrypt was invoked"
									));
						})
				)
				.cancelCreate(ccr -> ccr.text("Cancel"))
				.build();
	}

}
