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

import java.util.logging.Logger;

import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main {
	private static Logger log = Logger.getLogger(Main.class.getName());

	@Inject
	private Configuration configuration;

	void run() {
		log.info("run @ Main");
		log.info("configuration.value: " + configuration.getValue());
	}

	public static void main(String[] args) {
		Weld weld = new Weld();

		WeldContainer weldContainer = weld.initialize();

		weldContainer.select(Main.class).get().run();

		weldContainer.shutdown();
	}
}
