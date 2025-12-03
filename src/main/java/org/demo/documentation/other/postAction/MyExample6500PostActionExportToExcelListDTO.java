package org.demo.documentation.other.postAction;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MyExample6500PostActionExportToExcelListDTO extends DataResponseDTO {
    private String testData;

    public MyExample6500PostActionExportToExcelListDTO(MyExample6500PostActionExportToExcelListEntity entity) {
        this.id = Optional.ofNullable(entity.getId()).map(String::valueOf).orElse(null);
        this.testData = entity.getTestData();
    }

}
