package org.demo.documentation.feature.encryptsign.encryptsign;

import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.data.dto.MassDTO;
import org.cxbox.api.data.dto.MassOptionType;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.MassActionResultDTO;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.feature.encryptsign.encryptsign.enums.StatusEncryptSignEnum;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
@SuppressWarnings("java:S1170")
public class Myexample3712MassService extends VersionAwareResponseService<Myexample3712DTO, Myexample3712> {

	@Getter(onMethod_ = @Override)
	private final Class<Myexample3712MetaBuilder> meta = Myexample3712MetaBuilder.class;

	private final MyEntity3712Repository myexample3712Repository;

	@Override
	protected CreateResult<Myexample3712DTO> doCreateEntity(Myexample3712 entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, myexample3712Repository.save(entity)));
	}

	@Override
	protected ActionResultDTO<Myexample3712DTO> doUpdateEntity(Myexample3712 entity, Myexample3712DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<Myexample3712DTO> getActions() {
		return Actions.<Myexample3712DTO>builder()
				.action(act -> act
						.action("massDocumentEncryptSign", "Mass Document Encrypt Sign")
						.massInvoker((bc, data, ids) -> {
							// only the rows processed on the frontend, the others get the frontend errors automatically
							var massResult = data.getMassIds_().stream()
									.map(mass -> {
										Myexample3712 entity = myexample3712Repository.getReferenceById(Long.parseLong(mass.getId()));
										entity.setFileEncryptId(mass.getOption(MassOptionType.ENCRYPTED_FILE_ID));
										entity.setFileEncrypt(mass.getOption(MassOptionType.ENCRYPTED_FILE_NAME));
										entity.setFileSignId(mass.getOption(MassOptionType.SIGNATURE_FILE_ID));
										entity.setFileSign(mass.getOption(MassOptionType.SIGNATURE_FILE_NAME));
										entity.setStatus(StatusEncryptSignEnum.SIGN_ENCRYPT);
										return MassDTO.success(mass.getId());
									})
									.collect(Collectors.toSet());
							return new MassActionResultDTO<Myexample3712DTO>(massResult);
						})
				)
				.build();
	}
	// --8<-- [end:getActions]

}
