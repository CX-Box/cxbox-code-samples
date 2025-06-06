package org.demo.documentation.fields.dictionary.dictionarydictionary.dictionary;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.cxbox.api.data.dictionary.DictionaryCache;
import org.cxbox.api.data.dto.AssociateDTO;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.api.service.LocaleService;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.BusinessError;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.AssociateResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.file.dto.FileDownloadDto;
import org.cxbox.core.file.service.CxboxFileService;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.cxbox.model.core.api.TranslationId;
import org.cxbox.model.dictionary.entity.DictionaryItem;
import org.cxbox.model.dictionary.entity.DictionaryItemTranslation;
import org.cxbox.model.dictionary.entity.DictionaryItem_;
import org.cxbox.model.dictionary.entity.DictionaryTypeDesc;
import org.hibernate.exception.ConstraintViolationException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample357Service extends VersionAwareResponseService<DictionaryItemDTO, DictionaryItem> {

    @Getter(onMethod_ = @Override)
    private final Class<MyExample357Meta> meta = MyExample357Meta.class;
    @Autowired
    private DictionaryCache dictionaryCache;

    private final MyEntity357Repository repository;
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private LocaleService localeService;

    @Autowired
    private CxboxFileService cxboxFileService;

    @Override
    protected CreateResult<DictionaryItemDTO> doCreateEntity(DictionaryItem entity, BusinessComponent bc) {
        entity.setActive(true);
        entity.setTranslations(localeService.getSupportedLanguages().stream().collect(Collectors.toMap(
                lang -> lang,
                lang -> new DictionaryItemTranslation(new TranslationId(lang), entity, null)
        )));
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }
    @Override
    protected ActionResultDTO<DictionaryItemDTO> doUpdateEntity(DictionaryItem entity, DictionaryItemDTO data,
                                                                BusinessComponent bc) {
        setIfChanged(data, DictionaryItemDTO_.type, entity::setType);
        if (data.isFieldChanged(DictionaryItemDTO_.dictionaryTypeId)) {
            entity.setDictionaryTypeId(data.getDictionaryTypeId() != null
                    ? entityManager.getReference(DictionaryTypeDesc.class, data.getDictionaryTypeId())
                    : null);
        }
        setIfChanged(data, DictionaryItemDTO_.key, entity::setKey);
        if (data.isFieldChanged(DictionaryItemDTO_.value)) {
            entity.setValue(data.getValue());
            entity.getTranslations().forEach((lang, tr) -> tr.setValue(data.getValue()));
        }
        setIfChanged(data, DictionaryItemDTO_.active, entity::setActive);
        setIfChanged(data, DictionaryItemDTO_.displayOrder, entity::setDisplayOrder);
        setIfChanged(data, DictionaryItemDTO_.description, entity::setDescription);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:updateEntity]
    @Override
    public ActionResultDTO<DictionaryItemDTO> updateEntity(BusinessComponent bc, DataResponseDTO data) {
        var result = super.updateEntity(bc, data);
        validate(bc, result);
        return result;
    }

    @Override
    protected AssociateResultDTO doAssociate(List<AssociateDTO> data, BusinessComponent bc) {
        return super.doAssociate(data, bc);
    }

    // --8<-- [end:updateEntity]

    // --8<-- [start:getActions]
    @Override
    public Actions<DictionaryItemDTO> getActions() {
        return Actions.<DictionaryItemDTO>builder()
                .action(act -> act
                        .action("clear-cache", "Clear Cache")
                        .scope(ActionScope.BC)
                        .invoker((bc, data) -> {
                            // This will not work in cluster (>1 app nodes).
                            // Please, add scheduler or other mechanism to clear cache in cluster
                            dictionaryCache.reload();
                            return new ActionResultDTO<>();
                        }))
                .action(act -> act
                        .action("export_liquibase", "Export")
                        .scope(ActionScope.BC)
                        .invoker((data, bc) -> new ActionResultDTO<DictionaryItemDTO>()
                                .setAction(PostAction.downloadFile(cxboxFileService.upload(toCsv(), null))))
                )
                .create(crt -> crt.text("Create"))
                .cancelCreate(ccr -> ccr.text("Cancel"))
                .save(sv -> sv.text("Save"))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }
    // --8<-- [end:getActions]

    // --8<-- [start:validate]
    private void validate(BusinessComponent bc, ActionResultDTO<DictionaryItemDTO> result) {
        try {
            repository.flush();
        } catch (DataIntegrityViolationException e) {
            if (e.getCause() instanceof ConstraintViolationException uniqEx) {
                if (DictionaryItem.CONSTRAINT_UNIQ_TYPE_KEY.equalsIgnoreCase(uniqEx.getConstraintName())) {
                    throw new BusinessException(e).setEntity(new BusinessError.Entity(bc).addField(
                            DictionaryItem_.key.getName(),
                            "Key already exists for type " + result.getRecord().getType()));
                }
                if (DictionaryItem.CONSTRAINT_UNIQ_TYPE_VALUE.equalsIgnoreCase(uniqEx.getConstraintName())) {
                    throw new BusinessException(e).setEntity(new BusinessError.Entity(bc).addField(
                            DictionaryItem_.value.getName(),
                            "Value already exists for type " + result.getRecord().getType()));
                }
            }
            throw e;
        }
    }

    // --8<-- [end:validate]

    // --8<-- [start:toCsv]
    @SneakyThrows
    @NotNull
    private FileDownloadDto toCsv() {
        String name = "DICTIONARY.csv";
        var header = List.of("TYPE", "KEY", "VALUE", "DISPLAY_ORDER", "DESCRIPTION", "ACTIVE", "ID");
        var body = repository.findAll().stream()
                .sorted(Comparator.comparing(DictionaryItem::getType)
                        .thenComparing(dictionaryItem -> Optional.ofNullable(dictionaryItem.getDisplayOrder()).orElse(Integer.MAX_VALUE))
                        .thenComparing(DictionaryItem::getValue)
                        .thenComparing(DictionaryItem::getId)
                )
                .map(e -> List.of(
                        e.getType(),
                        e.getKey(),
                        e.getValue(),
                        Optional.ofNullable(e.getDisplayOrder()).map(d -> "" + d).orElse(""),
                        e.getDescription(),
                        e.isActive() ? "" : "false",
                        ""
                ));
        return CSVUtils.toCsv(header, body, name, ";");
    }
    // --8<-- [end:toCsv]
}
