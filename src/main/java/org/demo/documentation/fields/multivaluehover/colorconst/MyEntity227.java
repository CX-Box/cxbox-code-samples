package org.demo.documentation.fields.multivaluehover.colorconst;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity227 extends BaseEntity {

	@JoinTable(name = "MyEntity227_MyEntity228",
			joinColumns = @JoinColumn(name = "MyEntity227_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity228_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity228> customFieldList = new ArrayList<>();

}