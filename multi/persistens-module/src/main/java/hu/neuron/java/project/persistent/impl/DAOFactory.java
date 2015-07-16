package hu.neuron.java.project.persistent.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAOFactory {
	private Connection connection;
	private boolean scopeMarked = false;
	private DataDaoImpl daoImpl;

	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return new DAOFactory();
	}

	public DataDaoImpl getDataDaoImpl() throws Exception {
		if (connection == null)
			throw new Exception();
		if (daoImpl == null) {
			daoImpl = new DataDaoImpl(connection);
		}
		return daoImpl;
	}

	public void beginConnectionScope() throws Exception {
		// System.out.println(Thread.currentThread().getId() + " "
		// + this.toString() + " begin");
		if (scopeMarked) {
			throw new Exception("The beginning of scope is already marked.");
		} else {
			try {

				InitialContext cxt = new InitialContext();

				DataSource ds = (DataSource) cxt
						.lookup("java:/comp/env/jdbc/TestDB");

				connection = ds.getConnection();
			} catch (Exception e) {
				scopeMarked = false;
				throw new Exception(e);
			}
		}
		scopeMarked = true;
	}

	public void endConnectionScope() throws Exception {
		// System.out.println(Thread.currentThread().getId() + " "
		// + this.toString() + " closed");
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
