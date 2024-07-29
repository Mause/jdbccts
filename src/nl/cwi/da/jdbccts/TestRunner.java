package nl.cwi.da.jdbccts;

import com.sun.ts.lib.harness.Status;
import com.sun.ts.lib.harness.ServiceEETest;
import com.sun.ts.tests.jdbc.ee.connection.connection1.connectionClient1;
import com.sun.ts.tests.jdbc.ee.dbMeta.dbMeta1.dbMetaClient1;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt1.prepStmtClient1;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt10.prepStmtClient10;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt11.prepStmtClient11;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt12.prepStmtClient12;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt13.prepStmtClient13;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt14.prepStmtClient14;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt15.prepStmtClient15;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt16.prepStmtClient16;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt2.prepStmtClient2;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt3.prepStmtClient3;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt4.prepStmtClient4;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt5.prepStmtClient5;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt6.prepStmtClient6;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt7.prepStmtClient7;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt8.prepStmtClient8;
import com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt9.prepStmtClient9;
import com.sun.ts.tests.jdbc.ee.resultSet.resultSet1.resultSetClient1;
import com.sun.ts.tests.jdbc.ee.resultSet.resultSet10.resultSetClient10;
import com.sun.ts.tests.jdbc.ee.resultSet.resultSet11.resultSetClient11;
import com.sun.ts.tests.jdbc.ee.resultSet.resultSet14.resultSetClient14;
import com.sun.ts.tests.jdbc.ee.resultSet.resultSet17.resultSetClient17;
import com.sun.ts.tests.jdbc.ee.resultSet.resultSet18.resultSetClient18;
import com.sun.ts.tests.jdbc.ee.resultSet.resultSet41.resultSetClient41;
import com.sun.ts.tests.jdbc.ee.resultSet.resultSet45.resultSetClient45;
import com.sun.ts.tests.jdbc.ee.resultSet.resultSet7.resultSetClient7;
import com.sun.ts.tests.jdbc.ee.rsMeta.rsMetaClient;
import com.sun.ts.tests.jdbc.ee.stmt.stmt1.stmtClient1;
import com.sun.ts.tests.jdbc.ee.stmt.stmt2.stmtClient2;


public class TestRunner {

	private static void run(ServiceEETest t, String[] args) {
		Status s = t.run(args, System.out, System.err);
		if (!s.isPassed()) {
			System.exit(-1);
		}
	}
	
	public static void main(String[] args) {
		run(new stmtClient1(), args);
		run(new stmtClient2(), args);
		run(new dbMetaClient1(), args);
		run(new connectionClient1(), args);
		
		run(new resultSetClient1(), args);
		run(new resultSetClient7(), args);
		run(new resultSetClient10(), args);
		run(new resultSetClient11(), args);
		run(new resultSetClient14(), args);
		run(new resultSetClient17(), args);
		run(new resultSetClient18(), args);
		run(new resultSetClient41(), args);
		run(new resultSetClient45(), args); 
//		run(new resultSetClient47(), args); // varbinary stuff
//		run(new resultSetClient49(), args); // time & timestamps

		
		run(new prepStmtClient1(), args);
		run(new prepStmtClient2(), args);
		run(new prepStmtClient3(), args);
		run(new prepStmtClient4(), args);
		run(new prepStmtClient5(), args);
		run(new prepStmtClient6(), args);
		run(new prepStmtClient7(), args);
		run(new prepStmtClient8(), args);
		run(new prepStmtClient9(), args);
		run(new prepStmtClient10(), args);
		run(new prepStmtClient11(), args);
		run(new prepStmtClient12(), args);
		run(new prepStmtClient13(), args);
		run(new prepStmtClient14(), args);
		run(new prepStmtClient15(), args);
		run(new prepStmtClient16(), args);
		
		
		// special snowflake rsMetaClient has a bug that expects ftable to be ctstable2
		String[] args_meta = new String[args.length+1];
		for (int i = 0; i < args.length; i++) {
			args_meta[i] = args[i];
		}
		args_meta[args_meta.length-1] = "-dftable=ctstable2";
		run(new rsMetaClient(), args_meta);
		
		System.exit(0);
	}

}


/*

TODO

//batchUpdate

//dateTime1
//dateTime2
//dateTime3

//dbMeta1
//dbMeta10
//dbMeta11
//dbMeta12
//dbMeta2
//dbMeta3
//dbMeta4
//dbMeta5
//dbMeta6
//dbMeta7
//dbMeta8
//dbMeta9
//
//scalar1
//scalar2
//scalar3
//scalar4
//
//batUpdExcept
//sqlException

*/
 
