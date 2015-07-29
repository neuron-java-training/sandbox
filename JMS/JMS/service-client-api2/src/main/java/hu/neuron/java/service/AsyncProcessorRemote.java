package hu.neuron.java.service;

import java.util.concurrent.Future;

public interface AsyncProcessorRemote {

	public Integer getProgress();

	public Future<Integer> addJob(Integer number);
}
