package org.demo.documentation.multivaluehover.drilldown;

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
public class MyEntity231 extends BaseEntity {

	@JoinTable(name = "MyEntity231_MyEntity232",
			joinColumns = @JoinColumn(name = "MyEntity231_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity232_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity232> customFieldList = new ArrayList<>();

}