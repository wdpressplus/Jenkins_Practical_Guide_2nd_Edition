package jp.gihyo.jenkinsbook.action;

import static org.junit.Assert.*;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SampleActionTest {

	public static void main(String[] args) {
		JUnitCore.main(SampleActionTest.class.getName());
	}

	@Test
	public void testCheckNormal() {
		SampleAction action = new SampleAction();
		HttpServletRequest request = createMock(HttpServletRequest.class);

		expect(request.getParameter("FirstName")).andReturn("firstName");
		expect(request.getParameter("LastName")).andReturn("lastName");

		replay(request);
		boolean result = action.checkParameter(request);
		verify(request);

		assertEquals(true, result);
	}

	@Test
	public void testCheckError1() {
		SampleAction action = new SampleAction();
		HttpServletRequest request = createMock(HttpServletRequest.class);

		expect(request.getParameter("FirstName")).andReturn(null);

		replay(request);
		boolean result = action.checkParameter(request);
		verify(request);

		assertEquals(false, result);
	}

	@Test
	public void testCheckError2() {
		HttpServletRequest request = createMock(HttpServletRequest.class);
		SampleAction action = new SampleAction();

		expect(request.getParameter("FirstName")).andReturn("firstName");
		expect(request.getParameter("LastName")).andReturn(null);

		replay(request);
		boolean result = action.checkParameter(request);
		verify(request);

		assertEquals(false, result);
	}
	
	@Test
	public void testCheckError3() {
		SampleAction action = new SampleAction();
		HttpServletRequest request = createMock(HttpServletRequest.class);

		expect(request.getParameter("FirstName")).andReturn("");

		replay(request);
		boolean result = action.checkParameter(request);
		verify(request);

		assertEquals(false, result);
	}
}
