package com.github.neylorsousa.treinamento.laboratorio4.util;

import com.github.neylorsousa.treinamento.laboratorio4.view.WicketApplication;
import org.apache.wicket.util.tester.WicketTester;

public class WicketTesterSingleton {

	private WicketTesterSingleton(){}

	public static WicketTester newInstance() {
		return new WicketTester(new WicketApplication());
	}

}
