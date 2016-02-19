package com.mindtree.util;

import org.flywaydb.core.Flyway;

public class DbVersioning {
	
	public void callflyway()
	{
		Flyway flyway = new Flyway();

        // Point it to the database
        flyway.setDataSource("jdbc:mysql://104.215.249.127:3306/employee_order_db","demo","Welcome123");

        // Start the migration
        flyway.migrate();
	}

}
