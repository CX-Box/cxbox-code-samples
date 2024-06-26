/*
 * © OOO "SI IKS LAB", 2022-2023
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.demo.conf.cxbox.meta;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dictionary.LOV;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_ROLE")
public class UserRole extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User user;

/*	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DIVISION_ID")
	private Division division;*/

	@Column(name = "INTERNAL_ROLE_CD")
	private LOV internalRoleCd;

	@Column
	//@Convert(converter = org.hibernate.type.NumericBooleanConverter.class)
	private Boolean active;

	@Column
	//@Convert(converter = org.hibernate.type.NumericBooleanConverter.class)
	private Boolean main;

}
