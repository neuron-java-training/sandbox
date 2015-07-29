package hu.neuron.java.service;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Remote;
import javax.ejb.Singleton;

@Singleton(mappedName = "AsyncProcessorBean", name = "AsyncProcessorBean")
@Remote(AsyncProcessorRemote.class)
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class AsyncProcessor implements AsyncProcessorRemote {

	private final AtomicInteger progress = new AtomicInteger();

	@Override
	@Asynchronous
	// @Lock(LockType.READ)
	// @AccessTimeout(-1)
	public Future<Integer> addJob(Integer number) {
		progress.set(0);
		for (int i = 0; i < number; i++) {
			doSomeHeavyLifting();
			progress.incrementAndGet();
		}

		return new AsyncResult<Integer>(number);
	}

	private void doSomeHeavyLifting() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.interrupted();
			throw new IllegalStateException(e);
		}
	}

	@Override
	public Integer getProgress() {
		return progress.get();
	}
}