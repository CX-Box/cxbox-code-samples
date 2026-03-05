package org.demo.documentation.other.assoc;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.other.drilldown.option.MyEntity3421;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "LEGAL_CASE_DOCUMENTS")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {}, callSuper = true)
public class LegalCaseDocuments extends BaseEntity {


	@Column
	private String fileName;

	@Column
	private String fileNameId;

	@JoinTable(name = "LegalCaseDocuments_MyEntity3421Pick",
			joinColumns = @JoinColumn(name = "LegalCaseDocuments_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3421_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3421> filesList = new ArrayList<>();
}