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

import java.io.Serializable;

public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;

	private String registrationCode;

    private double price;

    public String getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
    	return "Ticket(registrationCode=" + this.getRegistrationCode() + ", price=" + this.getPrice() + ")";
    }
}