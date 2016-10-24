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

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oxylian.java_ee.hibernate.entity.SimpleEntity;

public class Main {
	private static Logger log = Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sample-pu");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		SimpleEntity a = new SimpleEntity("a");
		SimpleEntity b = new SimpleEntity("b");
		SimpleEntity c = new SimpleEntity("c");
		
		entityManager.persist(a);
		entityManager.persist(b);
		entityManager.persist(c);
		
		entityManager.getTransaction().commit();

		log.info("a.id: " + a.getId());
		log.info("b.id: " + b.getId());
		log.info("c.id: " + c.getId());
		
		entityManager.close();

		entityManagerFactory.close();
	}
}
