package hu.neuron.java.project.core.db;

import hu.neuron.java.project.core.db.PooDataSource;
import hu.neuron.java.project.core.db.TestResultDAOImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class DAOFactory {
	private Connection connection;
	private boolean scopeMarked = false;
	private static DAOFactory me;

	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		if(me == null){
			me = new DAOFactory();
		}
		return me;
	}

	public TestResultDAOImpl getTestResultDAO() throws Exception {
		if (connection == null)
			throw new Exception();
		return new TestResultDAOImpl(connection);
	}

	public void beginConnectionScope() throws Exception {
//		 System.out.println(Thread.currentThread().getId() + " "
//		 + this.toString() + " begin");
		if (scopeMarked) {
			throw new Exception("The beginning of scope is already marked.");
		} else {
			try {
				connection = PooDataSource.getDataSource()
						.getConnection();
//				connection = ConnectionFactory.getConnection();
			} catch (Exception e) {
				scopeMarked = false;
				System.out.println("DAOFactory: exception");
				throw new Exception(e);
			}
		}
		scopeMarked = true;
	}

	public void endConnectionScope() throws Exception {
//		 System.out.println(Thread.currentThread().getId() + " "
//		 + this.toString() + " closed");
		if (!scopeMarked) {
			throw new Exception(Thread.currentThread().getId()
					+ " The end of scope is already marked.");
		} else {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new Exception(e);
				} finally {
					connection = null;
					scopeMarked = false;
				}
			}
		}
	}

	public void beginTransaction() {
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void endTransaction() {
		try {
			connection.commit();
			connection.setAutoCommit(true);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void abortTransaction() {
		try {
			connection.rollback();
			connection.setAutoCommit(true);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
