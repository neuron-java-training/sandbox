package hu.neuron.java.service;

import java.util.concurrent.atomic.AtomicInteger;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Remote;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton(mappedName = "TimerBean", name = "TimerBean")
@Lock(LockType.READ)
@Remote(TimerRemote.class)
public class TimerBean implements TimerRemote {

	private final AtomicInteger checks = new AtomicInteger();

	@Schedule(second = "*", minute = "*", hour = "*")
	private void checkOnTheDaughters() {
		checks.incrementAndGet();
	}

	public int getChecks() {
		return checks.get();
	}
}
