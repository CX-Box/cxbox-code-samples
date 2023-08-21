package org.demo.documentation.multivaluehover.colorconst;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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