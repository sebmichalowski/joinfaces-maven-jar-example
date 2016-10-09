/*
 * Copyright 2016-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.joinfaces.example.view;

import javax.faces.application.ResourceHandler;

import org.joinfaces.example.JoinFacesExampleApplication;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.openqa.selenium.WebDriver;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JoinFacesExampleApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ImagesAndCssIT extends AbstractPageIT {

	private String resource(String url) {
		return ResourceHandler.RESOURCE_IDENTIFIER + url + ".jsf";
	}

	@Test
	public void faviconIcoResource() {
		WebDriver page = navegateTo(resource("/images/favicon.ico"));

		assertThat(page.getPageSource().length())
			.isEqualTo(1150);
	}

	@Test
	public void starterCssResource() {
		WebDriver page = navegateTo(resource("/starter.css"));

		assertThat(page.getPageSource().length())
			.isEqualTo(114);
	}

	@Test
	public void joinfacesPngResource() {
		WebDriver page = navegateTo(resource("/images/joinfaces.png"));

		assertThat(page.getPageSource().length())
			.isEqualTo(38810);
	}

}