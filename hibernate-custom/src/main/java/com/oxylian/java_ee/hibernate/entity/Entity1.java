/**  Copyright 2016 Sébastian Dejonghe
  *
  *  Licensed under the Apache License, Version 2.0 (the "License");
  *  you may not use this file except in compliance with the License.
  *  You may obtain a copy of the License at
  *
  *      http://www.apache.org/licenses/LICENSE-2.0
  *
  *   Unless required by applicable law or agreed to in writing, software
  *   distributed under the License is distributed on an "AS IS" BASIS,
  *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  *   See the License for the specific language governing permissions and
  *   limitations under the License.
  **/

package com.oxylian.java_ee.hibernate.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "entity1")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Entity1<Content> extends BaseEntity {
	@Type(type = "jsonb")
	@Column(columnDefinition = "jsonb")
	@Basic(fetch = FetchType.LAZY)
	private Content content;

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}
}
