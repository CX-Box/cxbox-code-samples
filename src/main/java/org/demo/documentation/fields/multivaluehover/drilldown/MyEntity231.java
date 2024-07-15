package org.demo.documentation.fields.multivaluehover.drilldown;

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
public class MyEntity231 extends BaseEntity {

	@JoinTable(name = "MyEntity231_MyEntity232",
			joinColumns = @JoinColumn(name = "MyEntity231_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity232_id")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<MyEntity232> customFieldList = new ArrayList<>();

}