package org.demo.documentation.other.drilldown.option.any;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.dto.multivalue.MultivalueField;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
public class MyEntity3424OutServiceDTO implements Serializable {

	private String id;
	private String customField;

	private String fileName;

	private String fileNameId;

	private MultivalueField files;

	private MultivalueField filesMV;
}