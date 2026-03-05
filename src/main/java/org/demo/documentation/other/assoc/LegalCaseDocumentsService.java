package org.demo.documentation.other.assoc;


import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.data.dto.AssociateDTO;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.AssociateResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.other.drilldown.option.MyEntity3421;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Getter
@RequiredArgsConstructor
public class LegalCaseDocumentsService extends VersionAwareResponseService<LegalCaseDocumentsDTO, LegalCaseDocuments> {

	@Getter(onMethod_ = @Override)
	private final Class<LegalCaseDocumentsMetaBuilder> meta = LegalCaseDocumentsMetaBuilder.class;

	private final LegalCaseDocumentsRepository legalCaseDocumentsRepository;

	@Autowired
	private EntityManager entityManager;


	@Override
	protected Specification<LegalCaseDocuments> getSpecification(BusinessComponent bc) {
		return super.getSpecification(bc);
	}

	@Override
	protected CreateResult<LegalCaseDocumentsDTO> doCreateEntity(LegalCaseDocuments entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, legalCaseDocumentsRepository.save(entity)));
	}

	@Override
	protected ActionResultDTO<LegalCaseDocumentsDTO> doUpdateEntity(LegalCaseDocuments entity, LegalCaseDocumentsDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(LegalCaseDocumentsDTO_.files)) {
			entity.getFilesList().clear();
			entity.getFilesList().addAll(data.getFiles().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3421.class, e))
					.collect(Collectors.toList()));
		}
		setIfChanged(data, LegalCaseDocumentsDTO_.fileNameId, entity::setFileNameId);
		setIfChanged(data, LegalCaseDocumentsDTO_.fileName, entity::setFileName);
		entity.setFileName(null);
		entity.setFilesList(null);
		return new ActionResultDTO<>(entityToDto(bc, entity));

	}

	@Override
	public Actions<LegalCaseDocumentsDTO> getActions() {
		return Actions.<LegalCaseDocumentsDTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}

}
