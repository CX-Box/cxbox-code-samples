package org.demo.documentation.fields.time.baselocaltime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.api.data.dto.rowmeta.jackson.LocalTimeWithDateDeserializer;
import org.cxbox.api.data.dto.rowmeta.jackson.LocalTimeWithDateSerializer;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.TimeValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.cxbox.core.util.filter.provider.impl.TimeValueProvider;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3512DTO extends DataResponseDTO {

    @JsonSerialize(using = LocalTimeWithDateSerializer.class)
    @JsonDeserialize(using = LocalTimeWithDateDeserializer.class)
    @SearchParameter(name = "customField", provider = TimeValueProvider.class)
    private LocalTime customField;

    @JsonSerialize(using = LocalTimeWithDateSerializer.class)
    @JsonDeserialize(using = LocalTimeWithDateDeserializer.class)
    @SearchParameter(name = "customFieldhA", provider = TimeValueProvider.class)
    private LocalTime customFieldhA;

    @JsonSerialize(using = LocalTimeWithDateSerializer.class)
    @JsonDeserialize(using = LocalTimeWithDateDeserializer.class)
    @SearchParameter(name = "customFieldhmmA", provider = TimeValueProvider.class)
    private LocalTime customFieldhmmA;

    @JsonSerialize(using = LocalTimeWithDateSerializer.class)
    @JsonDeserialize(using = LocalTimeWithDateDeserializer.class)
    @SearchParameter(name = "customFieldhmmssA", provider = TimeValueProvider.class)
    private LocalTime customFieldhmmssA;

    @JsonSerialize(using = LocalTimeWithDateSerializer.class)
    @JsonDeserialize(using = LocalTimeWithDateDeserializer.class)
    @SearchParameter(name = "customFieldh", provider = TimeValueProvider.class)
    private LocalTime customFieldh;

    @JsonSerialize(using = LocalTimeWithDateSerializer.class)
    @JsonDeserialize(using = LocalTimeWithDateDeserializer.class)
    @SearchParameter(name = "customFieldhmm", provider = TimeValueProvider.class)
    private LocalTime customFieldhmm;

    public MyExample3512DTO(MyEntity3512 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldhA = entity.getCustomFieldhA();
        this.customFieldhmmA = entity.getCustomFieldhmmA();
        this.customFieldhmmssA = entity.getCustomFieldhmmssA();
        this.customFieldh = entity.getCustomFieldh();
        this.customFieldhmm = entity.getCustomFieldhmm();
    }
}