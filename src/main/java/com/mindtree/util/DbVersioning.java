package com.mindtree.util;

import org.flywaydb.core.Flyway;

public class DbVersioning {
	
	public void startMigrating()
	{
		Flyway flyway = new Flyway();
        // Point it to the database
        flyway.setDataSource("jdbc:mysql://sonar.southeastasia.cloudapp.azure.com:3306/employee_order_db","demo","Welcome123");
        flyway.repair();
        // Start the migration
        flyway.migrate();
	}

}
