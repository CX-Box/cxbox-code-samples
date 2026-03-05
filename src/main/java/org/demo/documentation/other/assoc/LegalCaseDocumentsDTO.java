package org.demo.documentation.other.assoc;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.other.drilldown.option.MyEntity3421;

import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class LegalCaseDocumentsDTO extends DataResponseDTO {


	@SearchParameter(name = "fileName", provider = StringValueProvider.class)
	private String fileName;

	private String fileNameId;

	@SearchParameter(name = "filesList.id", provider = LongValueProvider.class)
	private MultivalueField files;

	private String filesDisplayedKey;

	public LegalCaseDocumentsDTO(LegalCaseDocuments entity) {
		this.id = Optional.of(entity).map(BaseEntity::getId).map(String::valueOf).orElse(null);
		this.fileName = entity.getFileName();
		this.fileNameId = entity.getFileNameId();
		this.files = entity.getFilesList()!=null ? entity.getFilesList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				e -> String.valueOf(e.getCustomField())
		)):null;
		this.filesDisplayedKey = StringUtils.abbreviate(entity.getFilesList().stream().map(MyEntity3421::getCustomField
		).map(e -> e.toString()).collect(Collectors.joining(",")), 12);
	}

}
