package org.demo.documentation.fields.multivaluetree.validationbusinessex;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3325Multivalue extends BaseEntity {

	@Column
	private String customField;

	@Column
	private Long parentId;

	@OneToMany(mappedBy = "parentId", fetch = FetchType.LAZY)
	private List<MyEntity3325Multivalue> children = new ArrayList<>();

}
