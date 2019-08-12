package org.olddriver.listener;

import java.io.IOException;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

public class LearnAsyncListener implements AsyncListener {

	@Override
	public void onComplete(AsyncEvent event) throws IOException {
		System.out.println("LearnAsyncListener ----- onComplete");
	}

	@Override
	public void onTimeout(AsyncEvent event) throws IOException {
		System.out.println("LearnAsyncListener ----- onTimeout");
	}

	@Override
	public void onError(AsyncEvent event) throws IOException {
		System.out.println("LearnAsyncListener ----- onError");
	}

	@Override
	public void onStartAsync(AsyncEvent event) throws IOException {
		System.out.println("LearnAsyncListener ----- onStartAsync");
	}

}
