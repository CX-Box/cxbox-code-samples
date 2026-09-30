package org.demo.documentation.feature.encryptsign.signencrypt;

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
import org.demo.documentation.feature.encryptsign.signencrypt.enums.StatusSignEncryptEnum;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
@SuppressWarnings("java:S1170")
public class Myexample3714MassService extends VersionAwareResponseService<Myexample3714DTO, Myexample3714> {

	@Getter(onMethod_ = @Override)
	private final Class<Myexample3714MetaBuilder> meta = Myexample3714MetaBuilder.class;

	private final MyEntity3714Repository myexample3714Repository;

	@Override
	protected CreateResult<Myexample3714DTO> doCreateEntity(Myexample3714 entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, myexample3714Repository.save(entity)));
	}

	@Override
	protected ActionResultDTO<Myexample3714DTO> doUpdateEntity(Myexample3714 entity, Myexample3714DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<Myexample3714DTO> getActions() {
		return Actions.<Myexample3714DTO>builder()
				.action(act -> act
						.action("massDocumentSignEncrypt", "Mass Document Sign Encrypt")
						.massInvoker((bc, data, ids) -> {
							// only the rows processed on the frontend, the others get the frontend errors automatically
							var massResult = data.getMassIds_().stream()
									.map(mass -> {
										Myexample3714 entity = myexample3714Repository.getReferenceById(Long.parseLong(mass.getId()));
										entity.setFileSignId(mass.getOption(MassOptionType.SIGNATURE_FILE_ID));
										entity.setFileSign(mass.getOption(MassOptionType.SIGNATURE_FILE_NAME));
										entity.setFileEncryptId(mass.getOption(MassOptionType.ENCRYPTED_FILE_ID));
										entity.setFileEncrypt(mass.getOption(MassOptionType.ENCRYPTED_FILE_NAME));
										entity.setStatus(StatusSignEncryptEnum.SIGN_ENCRYPT);
										return MassDTO.success(mass.getId());
									})
									.collect(Collectors.toSet());
							return new MassActionResultDTO<Myexample3714DTO>(massResult);
						})
				)
				.build();
	}
	// --8<-- [end:getActions]

}
