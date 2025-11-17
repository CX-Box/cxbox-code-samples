package org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.anysource;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.feature.microservice.conf.IntegrationConfiguration;
import org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.enums.CountryEnum;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

import static org.demo.documentation.fields.main.TextError.MORE_CURRENT_DATE;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.web.util.UriComponentsBuilder.fromUriString;


@SuppressWarnings({"java:S1170", "java:S2387"})
@RequiredArgsConstructor
@Service
public class MyExample3420Service extends AnySourceVersionAwareResponseService<MyExample3420DTO, MyEntity3420OutServiceDTO> {

    private final IntegrationConfiguration integrationConfig;
    private final RestTemplate restTemplate;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3420Meta> meta = MyExample3420Meta.class;
    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3420Dao> dao = MyEntity3420Dao.class;


    @Override
    protected CreateResult<MyExample3420DTO> doCreateEntity(MyEntity3420OutServiceDTO entity, BusinessComponent bc) {
        entity.setCountry(CountryEnum.RUSSIA);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3420DTO> doUpdateEntity(MyEntity3420OutServiceDTO entity, MyExample3420DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3420DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        if (data.isFieldChanged(MyExample3420DTO_.customFieldNew)) {
            entity.setCustomFieldNew(data.getCustomFieldNew());
        }
        if (data.isFieldChanged(MyExample3420DTO_.customFieldDateTime)) {
            LocalDateTime sysdate = LocalDateTime.now();
            if (data.getCustomFieldDateTime() != null && sysdate.isBefore(data.getCustomFieldDateTime())) {
                throw new BusinessException().addPopup(MORE_CURRENT_DATE);
            }
            entity.setCustomFieldDateTime(data.getCustomFieldDateTime());
        }

        if (data.isFieldChanged(MyExample3420DTO_.customFieldDouble)) {
            entity.setCustomFieldDouble(data.getCustomFieldDouble());
        }

        if (data.isFieldChanged(MyExample3420DTO_.region)) {
            entity.setRegion(data.getRegion());
        }
        if (data.isFieldChanged(MyExample3420DTO_.country)) {
            entity.setCountry(data.getCountry());
        }
        setIfChanged(data, MyExample3420DTO_.street, entity::setStreet);
        setIfChanged(data, MyExample3420DTO_.product, entity::setProduct);
        setIfChanged(data, MyExample3420DTO_.descriptionProduct, entity::setDescriptionProduct);

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3420DTO> getActions() {
        return Actions.<MyExample3420DTO>builder()
                .create(crt -> crt.text("Add"))
                .delete(dlt -> dlt.text("Delete"))
                .action(act -> act
                        .action("customButton", "Custom Save")
                        .invoker(this::customButton)
                )
                .save(sv -> sv.text("Save"))
                .build();
    }

    // --8<-- [end:getActions]
    private ActionResultDTO<MyExample3420DTO> customButton(BusinessComponent bc, MyExample3420DTO dto) {
        MyEntity3420OutServiceDTO entity = new MyEntity3420OutServiceDTO();
        entity.setCountry(dto.getCountry());
        entity.setDescriptionProduct(dto.getDescriptionProduct());
        entity.setRegion(dto.getRegion());
        entity.setCustomField(dto.getCustomField());
        entity.setCustomFieldNew(dto.getCustomFieldNew());
        entity.setCustomFieldDateTime(dto.getCustomFieldDateTime());
        entity.setCustomFieldDouble(dto.getCustomFieldDouble());
        entity.setProduct(dto.getProduct());
        entity.setStreet(dto.getStreet());
        entity.setId(dto.getId());
        restTemplate.exchange(
                fromUriString(integrationConfig.getDataServerUrl()).build().normalize().encode().toUriString(),
                PUT, new HttpEntity<>(entity), MyEntity3420OutServiceDTO.class
        ).getBody();
        return new ActionResultDTO<>();
    }
}