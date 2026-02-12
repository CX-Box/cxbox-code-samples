package org.demo.documentation.fields.multivaluehover.colorconst;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;


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