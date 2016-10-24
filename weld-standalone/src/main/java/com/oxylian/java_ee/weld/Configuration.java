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

package com.oxylian.java_ee.weld;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;

@Named("config")
public class Configuration {
	public int getValue() {
		return 42;
	}

	@PostConstruct
	public void postConstruct()	{
		System.out.println("Configuration.postConstruct");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("Configuration.preDestroy");
	}
}
