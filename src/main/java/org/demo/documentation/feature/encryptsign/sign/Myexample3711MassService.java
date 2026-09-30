package org.demo.documentation.feature.encryptsign.sign;

import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cxbox.api.data.dto.MassDTO;
import org.cxbox.api.data.dto.MassOptionType;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.MassActionResultDTO;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.feature.encryptsign.sign.enums.StatusSignEnum;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Getter
@RequiredArgsConstructor
@SuppressWarnings("java:S1170")
public class Myexample3711MassService extends VersionAwareResponseService<Myexample3711DTO, Myexample3711> {

	@Getter(onMethod_ = @Override)
	private final Class<Myexample3711MetaBuilder> meta = Myexample3711MetaBuilder.class;

	private final MyEntity3711Repository myexample3711Repository;

	@Override
	protected CreateResult<Myexample3711DTO> doCreateEntity(Myexample3711 entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, myexample3711Repository.save(entity)));
	}

	@Override
	protected ActionResultDTO<Myexample3711DTO> doUpdateEntity(Myexample3711 entity, Myexample3711DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<Myexample3711DTO> getActions() {
		return Actions.<Myexample3711DTO>builder()
				.action(act -> act
						.action("massDocumentSign", "Mass Document Sign")
						.massInvoker((bc, data, ids) -> {
							// only the rows signed on the frontend, the others get the frontend errors automatically
							var massResult = data.getMassIds_().stream()
									.map(mass -> {
										Myexample3711 entity = myexample3711Repository.getReferenceById(Long.parseLong(mass.getId()));
										entity.setFileSignId(mass.getOption(MassOptionType.SIGNATURE_FILE_ID));
										entity.setFileSign(mass.getOption(MassOptionType.SIGNATURE_FILE_NAME));
										entity.setStatus(StatusSignEnum.SIGNED);
										return MassDTO.success(mass.getId());
									})
									.collect(Collectors.toSet());
							// --8<-- [start:massErrors]
							data.getMassErrors_().forEach(error ->
									log.warn("Row {} was not signed: {}", error.getId(), error.getErrorMessage()));
							// --8<-- [end:massErrors]
							return new MassActionResultDTO<Myexample3711DTO>(massResult);
						})
				)
				.build();
	}
	// --8<-- [end:getActions]

}
