package org.demo.documentation.feature.encryptsign.largefile;

import java.util.Set;
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
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
@SuppressWarnings("java:S1170")
public class Myexample10000MassService extends VersionAwareResponseService<Myexample10000DTO, Myexample10000> {

	@Getter(onMethod_ = @Override)
	private final Class<Myexample10000MetaBuilder> meta = Myexample10000MetaBuilder.class;

	private final MyEntity10000Repository repository;

	@Override
	protected CreateResult<Myexample10000DTO> doCreateEntity(Myexample10000 entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, repository.save(entity)));
	}

	@Override
	protected ActionResultDTO<Myexample10000DTO> doUpdateEntity(Myexample10000 entity, Myexample10000DTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<Myexample10000DTO> getActions() {
		return Actions.<Myexample10000DTO>builder()
				.action(act -> act
						.action("massDocumentSign", "Mass sign")
						.massInvoker((bc, data, ids) -> new MassActionResultDTO<Myexample10000DTO>(saveResults(data, "Mass sign")))
				)
				.action(act -> act
						.action("massDocumentSignEncrypt", "Mass sign and encrypt")
						.massInvoker((bc, data, ids) -> new MassActionResultDTO<Myexample10000DTO>(saveResults(data, "Mass sign and encrypt")))
				)
				.build();
	}

	// only the rows processed on the frontend, the others get the frontend errors automatically
	private Set<MassDTO> saveResults(Myexample10000DTO data, String operation) {
		return data.getMassIds_().stream()
				.map(mass -> {
					Myexample10000 entity = repository.getReferenceById(Long.parseLong(mass.getId()));
					if (mass.getOption(MassOptionType.SIGNATURE_FILE_ID) != null) {
						entity.setFileSignId(mass.getOption(MassOptionType.SIGNATURE_FILE_ID));
						entity.setFileSign(mass.getOption(MassOptionType.SIGNATURE_FILE_NAME));
					}
					if (mass.getOption(MassOptionType.ENCRYPTED_FILE_ID) != null) {
						entity.setFileEncryptId(mass.getOption(MassOptionType.ENCRYPTED_FILE_ID));
						entity.setFileEncrypt(mass.getOption(MassOptionType.ENCRYPTED_FILE_NAME));
					}
					entity.setLastOperation(operation);
					return MassDTO.success(mass.getId());
				})
				.collect(Collectors.toSet());
	}

}
