package org.demo.documentation.widgets.tree.any.data.users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Table(name = "MY3261_USERS")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {}, callSuper = true)
public class My3261Users extends BaseEntity {


	@Column
	private String lastName;

	@Column
	private String firstName;

	@Column
	private String middleName;
}