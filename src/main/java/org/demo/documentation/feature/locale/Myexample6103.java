package org.demo.documentation.feature.locale;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.feature.locale.dictionary.ClientImportance;
import org.demo.documentation.feature.locale.enums.StatusEnum;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "MYEXAMPLE6103")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {}, callSuper = true)
public class Myexample6103 extends BaseEntity {


	@Column
	private String fullName;

	@Column
	private String address;

	@Column
	private ClientImportance importance;

	@Enumerated(value = EnumType.STRING)
	@Column
	private StatusEnum status;

	@Column
	private LocalDateTime dateStart;
}