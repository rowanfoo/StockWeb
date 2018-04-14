package factory;

import java.sql.Connection;
import java.util.logging.Logger;

import dao.Database;
import util.ExcelLogger;

public class DAOFactoryBase implements AutoCloseable {
	Connection con = null;
	Logger logger = null;

	DAOFactoryBase() {
		try {

			logger = ExcelLogger.getLogger();
			con = Database.getConnection();
			con.setAutoCommit(false);

		} catch (Exception e) {
			System.out.println("Error initialize DAOFactoryBase " + e);
			logger.severe("DAOFactoryBase Error initialize:" + e);
		}

	}
	DAOFactoryBase(Connection con ) {
		try {

			logger = ExcelLogger.getLogger();
			this.con = con;
			con.setAutoCommit(false);

		} catch (Exception e) {
			System.out.println("Error initialize DAOFactoryBase " + e);
			logger.severe("DAOFactoryBase Error initialize:" + e);
		}

	}

	public void close() {

		try {
			con.close();
			// System.out.println("DAOFactoryBase Close Connection OK !!!!!!:");
		} catch (Exception e) {
			System.out.println("EROR DAOFactoryBase closing Connection :" + e);
			logger.severe("EROR DAOFactoryBase closing Connection :" + e);
		}

	}	
	
	
}
