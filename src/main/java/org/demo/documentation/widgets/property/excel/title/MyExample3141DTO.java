package org.demo.documentation.widgets.property.excel.title;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3141DTO extends DataResponseDTO {

	private String client;

	private Double sum;

	private LocalDateTime period;

}
