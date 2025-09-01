package org.demo.documentation.other.test;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

import java.util.Optional;

import static org.demo.documentation.fields.main.TextError.ONLY_LETTER;


@Getter
@Setter
@NoArgsConstructor
public class MyExample420DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    @Pattern(regexp = "[A-Za-z]+", message = ONLY_LETTER)
    private String customField;

    @SearchParameter(name = "customField2")
    @Pattern(regexp = "[A-Za-z]+", message = ONLY_LETTER)
    private String customField2;

    @Pattern(regexp = "[A-Za-z]+", message = ONLY_LETTER)
    private String customField3;

    @Pattern(regexp = "[A-Za-z]+", message = ONLY_LETTER)
    @SearchParameter(name = "customFieldForceActive")
    private String customFieldForceActive;

    @Pattern(regexp = "[A-Za-z]+", message = ONLY_LETTER)
    @SearchParameter(name = "customFieldForceActive3")
    private String customFieldForceActive3;

    @Pattern(regexp = "[A-Za-z]+", message = ONLY_LETTER)
    @SearchParameter(name = "customFieldForceActive2")
    private String customFieldForceActive2;

    @SearchParameter(name = "paymentRequestEntity.name", provider = StringValueProvider.class)
    private String paymentRequest;

    @SearchParameter(name = "paymentRequestEntity.id", provider = LongValueProvider.class)
    private Long paymentRequestId;

    @SearchParameter(name = "endpoint", provider = StringValueProvider.class)
    private String endpoint;

    @SearchParameter(name = "request", provider = StringValueProvider.class)
    private String request;

    @SearchParameter(name = "requestFiles", provider = StringValueProvider.class)
    private String requestFiles;

    @SearchParameter(name = "response", provider = StringValueProvider.class)
    private String response;

    @SearchParameter(name = "responseFiles", provider = StringValueProvider.class)
    private String responseFiles;


    public MyExample420DTO(MyEntity420 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customField2 = entity.getCustomField2();
        this.customField3 = entity.getCustomField3();

        this.customFieldForceActive = entity.getCustomFieldForceActive();
        this.customFieldForceActive3 = entity.getCustomFieldForceActive3();
        this.customFieldForceActive2 = entity.getCustomFieldForceActive2();
        this.paymentRequestId = Optional.ofNullable(entity.getPaymentRequestEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.paymentRequest = Optional.ofNullable(entity.getPaymentRequestEntity())
                .map(e -> e.getName())
                .orElse(null);
        this.endpoint = entity.getEndpoint();
        this.request = entity.getRequest();
        this.requestFiles = entity.getRequestFiles();
        this.response = entity.getResponse();
        this.responseFiles = entity.getResponseFiles();
    }

}