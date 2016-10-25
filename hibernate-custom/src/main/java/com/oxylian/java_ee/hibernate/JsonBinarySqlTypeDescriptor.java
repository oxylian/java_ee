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

package com.oxylian.java_ee.hibernate;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.hibernate.type.descriptor.ValueBinder;
import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.JavaTypeDescriptor;
import org.hibernate.type.descriptor.sql.BasicBinder;

import com.fasterxml.jackson.databind.JsonNode;

public class JsonBinarySqlTypeDescriptor extends AbstractJsonSqlTypeDescriptor {
	private static final long serialVersionUID = 1L;
	
	public static final JsonBinarySqlTypeDescriptor INSTANCE = new JsonBinarySqlTypeDescriptor();

	@Override
	public <X> ValueBinder<X> getBinder(final JavaTypeDescriptor<X> javaTypeDescriptor) {
		return new BasicBinder<X>(javaTypeDescriptor, this) {
			@Override
			protected void doBind(PreparedStatement st, X value, int index, WrapperOptions options)
					throws SQLException {
				st.setObject(index, javaTypeDescriptor.unwrap(value, JsonNode.class, options), getSqlType());
			}

			@Override
			protected void doBind(CallableStatement st, X value, String name, WrapperOptions options)
					throws SQLException {
				st.setObject(name, javaTypeDescriptor.unwrap(value, JsonNode.class, options), getSqlType());
			}
		};
	}
}