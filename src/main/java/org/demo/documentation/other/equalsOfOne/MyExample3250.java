package org.demo.documentation.other.equalsOfOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.other.equalsOfOne.onetoone.MyExample3250OneToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "MY_EXAMPLE3250")
public class MyExample3250 extends BaseEntity {

	@OneToOne
	@JoinColumn(name = "MY_EXAMPLE3250_ONE_TO_ONE_ID")
	public MyExample3250OneToOne myExample3250OneToOne;

}
