package org.demo.documentation.feature.encryptsign.sign;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.MessageType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.cxbox.core.service.action.PreActionSpecifier;
import org.demo.documentation.feature.encryptsign.sign.enums.StatusSignEnum;
import org.demo.documentation.fields.dictionary.validationannotation.MyExample293DTO_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Getter
@RequiredArgsConstructor
@SuppressWarnings("java:S1170")
public class Myexample3711Service extends VersionAwareResponseService<Myexample3711DTO, Myexample3711> {

	@Getter(onMethod_ = @Override)
	private final Class<Myexample3711MetaBuilder> meta = Myexample3711MetaBuilder.class;

	private final MyEntity3711Repository myexample3711Repository;

	@Override
	protected CreateResult<Myexample3711DTO> doCreateEntity(Myexample3711 entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, myexample3711Repository.save(entity)));
	}

	@Override
	protected ActionResultDTO<Myexample3711DTO> doUpdateEntity(Myexample3711 entity, Myexample3711DTO data, BusinessComponent bc) {
		setIfChanged(data, Myexample3711DTO_.status, entity::setStatus);
		setIfChanged(data, Myexample3711DTO_.fileSignId, entity::setFileSignId);
		setIfChanged(data, Myexample3711DTO_.fileSign, entity::setFileSign);
		setIfChanged(data, Myexample3711DTO_.fileId, entity::setFileId);
		setIfChanged(data, Myexample3711DTO_.file, entity::setFile);
		myexample3711Repository.save(entity);
		return new ActionResultDTO<>(entityToDto(bc, myexample3711Repository.save(entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<Myexample3711DTO> getActions() {
		return Actions.<Myexample3711DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.action(act -> act
						.action("documentSign", "Document Sign")
						.scope(ActionScope.RECORD)
						.available(bc -> {
							return true;
						})
						.invoker((bc, dto) -> {
							Optional<Myexample3711> myexample3711 = myexample3711Repository.findById(Long.valueOf(dto.getId()));
							myexample3711.ifPresent(e -> {
								e.setStatus(StatusSignEnum.SIGNED);
								myexample3711Repository.save(myexample3711.get());
							});
							return new ActionResultDTO<Myexample3711DTO>()
									.setAction(PostAction.showMessage(
											MessageType.INFO, "Action documentSign was invoked"
									));
						})
				)
				.cancelCreate(ccr -> ccr.text("Cancel"))
				.build();
	}

}
