/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.plc.ventas.model;

import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import java.io.File;

/**
 *
 * @author poloche
 */
public class DBController {

    private Environment myDbEnvironment = null;
    private Database myDatabase = null;
    private static DBController dBController;

    public static DBController getInstance() {
        if (dBController == null) {
            dBController = new DBController();
        }
        return dBController;
    }

    private DBController() {

    }

    public void connect() {

        try {
            // Open the environment, creating one if it does not exist
            EnvironmentConfig envConfig = new EnvironmentConfig();
            envConfig.setAllowCreate(true);
            myDbEnvironment = new Environment(new File("/tmp/plc"),
                    envConfig);

            // Open the database, creating one if it does not exist
            DatabaseConfig dbConfig = new DatabaseConfig();
            dbConfig.setAllowCreate(true);
            myDatabase = myDbEnvironment.openDatabase(null,
                    "Ventas", dbConfig);
        } catch (DatabaseException dbe) {
            //  Exception handling
        }
    }

}
