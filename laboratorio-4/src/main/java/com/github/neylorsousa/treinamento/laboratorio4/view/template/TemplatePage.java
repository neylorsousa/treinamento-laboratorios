package com.github.neylorsousa.treinamento.laboratorio4.view.template;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;

public class TemplatePage extends WebPage{
	private Component headerPanel;
	private Component menuPanel;
	private Component footerPanel;

	public TemplatePage(){
		add(headerPanel = new HeaderPanel("headerPanel"));
		add(footerPanel = new FooterPanel("footerPanel"));
	}
}
