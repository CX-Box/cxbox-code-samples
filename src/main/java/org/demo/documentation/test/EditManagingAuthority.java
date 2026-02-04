package org.demo.documentation.test;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.fields.checkbox.basic.enums.TypesEnum;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "EDIT_MANAGING_AUTHORITY")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {}, callSuper = true)
public class EditManagingAuthority extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "PARTY_ID")
	private EditLegalEntity party;

	@Column
	private String partyType;

	@Column
	private String partyName;

	@Column
	private String partyInn;

	@Enumerated(value = EnumType.STRING)
	@CollectionTable(name = "TYPES_EDIT_MANAGING_AUTHORITY", joinColumns = @JoinColumn(name = "EditManagingAuthority_ID"))
	@ElementCollection(targetClass = TypesEnum.class)
	@Column(name = "VALUE", nullable = false)
	private Set<TypesEnum> types = new HashSet<>();

	@Column
	private String otherType;
}