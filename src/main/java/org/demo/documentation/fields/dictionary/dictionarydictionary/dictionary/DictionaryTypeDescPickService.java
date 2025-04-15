package org.demo.documentation.fields.dictionary.dictionarydictionary.dictionary;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.dictionary.entity.DictionaryTypeDesc;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class DictionaryTypeDescPickService extends VersionAwareResponseService<DictionaryTypeDescPickDTO, DictionaryTypeDesc> {

	private final DictoryTypeRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<DictionaryTypeDescPickMeta> meta = DictionaryTypeDescPickMeta.class;

    @Override
	protected CreateResult<DictionaryTypeDescPickDTO> doCreateEntity(DictionaryTypeDesc entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<DictionaryTypeDescPickDTO> doUpdateEntity(DictionaryTypeDesc entity, DictionaryTypeDescPickDTO data,
                                                                        BusinessComponent bc) {
		setIfChanged(data, DictionaryTypeDescPickDTO_.type, entity::setType);
		repository.save(entity);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<DictionaryTypeDescPickDTO> getActions() {
		return Actions.<DictionaryTypeDescPickDTO>builder()
				.create(crt -> crt.text("Create"))
				.cancelCreate(ccr -> ccr.text("Cancel"))
				.save(sv -> sv.text("Save"))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}

}