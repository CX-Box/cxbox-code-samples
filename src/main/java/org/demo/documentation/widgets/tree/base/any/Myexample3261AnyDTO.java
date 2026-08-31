package org.demo.documentation.widgets.tree.base.any;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class Myexample3261AnyDTO extends DataResponseDTO {


	private String department;

	private String parentId;

	private Boolean isLeaf;

	private String lastName;

	private String firstName;

	private String middleName;

	private String fullName;
}
