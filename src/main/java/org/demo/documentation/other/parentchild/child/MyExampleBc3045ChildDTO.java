package org.demo.documentation.other.parentchild.child;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.model.core.entity.BaseEntity;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MyExampleBc3045ChildDTO extends DataResponseDTO {

	private String myExampleBc3045Id;

	@SearchParameter(name = "customField")
	private String customField;

	public MyExampleBc3045ChildDTO(MyExampleBc3045Child entity) {
		this.id = Optional.of(entity).map(BaseEntity::getId).map(String::valueOf).orElse(null);
		this.myExampleBc3045Id = Optional.of(entity).map(MyExampleBc3045Child::getMyExampleBc3045).map(BaseEntity::getId).map(String::valueOf).orElse(null);
		this.customField = entity.getCustomField();
	}

}
