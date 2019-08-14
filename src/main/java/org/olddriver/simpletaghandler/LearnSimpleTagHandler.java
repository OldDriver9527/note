package org.olddriver.simpletaghandler;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class LearnSimpleTagHandler extends SimpleTagSupport{

	private boolean test;

	
	@Override
	public void setParent(JspTag parent) {
		System.out.println("setParent run....");
		super.setParent(parent);
	}

	@Override
	public void setJspContext(JspContext pc) {
		System.out.println("setJspContext run ....");
		super.setJspContext(pc);
	}

	@Override
	public void setJspBody(JspFragment jspBody) {
		System.out.println("setJspBody run...");
		super.setJspBody(jspBody);
	}

	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("doTag run ...");
		JspFragment jspFragment = getJspBody();
		if(test) {
			jspFragment.invoke(null);
		}
	}

	public boolean isTest() {
		return test;
	}
	public void setTest(boolean test) {
		System.out.println("setTest run....");
		this.test = test;
	}
}
