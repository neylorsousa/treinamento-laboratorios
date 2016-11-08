package com.github.neylorsousa.treinamento.laboratorio4.view;

import com.github.neylorsousa.treinamento.laboratorio4.util.WicketTesterSingleton;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Test;

public class HomePageTest {

	@Test
	public void homepageRendersSuccessfully() {
		WicketTester tester = WicketTesterSingleton.newInstance();

		//start and render the test page
		tester.startPage(HomePage.class);

		//assert rendered page class
		tester.assertRenderedPage(HomePage.class);
	}
}
