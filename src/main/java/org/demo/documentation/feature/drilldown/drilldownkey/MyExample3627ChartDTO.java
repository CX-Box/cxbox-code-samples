package org.demo.documentation.feature.drilldown.drilldownkey;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MyExample3627ChartDTO extends DataResponseDTO {

	private String name;

	private Long amount;

}
