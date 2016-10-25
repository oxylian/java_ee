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

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oxylian.java_ee.hibernate.entity.Event;
import com.oxylian.java_ee.hibernate.entity.Location;
import com.oxylian.java_ee.hibernate.entity.Participant;
import com.oxylian.java_ee.hibernate.entity.Ticket;

public class Main {
	private static Logger log = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sample-pu");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Event nullEvent = new Event();
	    entityManager.persist(nullEvent);
	 
	    Location location = new Location();
	    location.setCountry("Romania");
	    location.setCity("Cluj-Napoca");
	 
	    Event event = new Event();
	    event.setLocation(location);
	    entityManager.persist(event);
	 
	    Ticket ticket = new Ticket();
	    ticket.setPrice(12.34d);
	    ticket.setRegistrationCode("ABC123");
	 
	    Participant participant = new Participant();
	    participant.setTicket(ticket);
	    participant.setEvent(event);
	 
	    entityManager.persist(participant);
	    
	    entityManager.getTransaction().commit();
	    
	    List<Participant> participants = entityManager.createNativeQuery(
	    	    "SELECT p.* FROM participant p WHERE p.ticket ->> 'price' > '10'", Participant.class)
	    	.getResultList();
	    
	    for (Participant p: participants) {
	    	log.info("PARTICIPANT: " + p);
	    }
	    
		entityManager.close();

		entityManagerFactory.close();
	}
}
