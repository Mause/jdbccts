package nl.cwi.da.jdbccts;

import com.sun.javatest.Status;
import com.sun.ts.lib.harness.ServiceEETest;
import com.sun.ts.tests.jdbc.ee.connection.connection1.connectionClient1;
import com.sun.ts.tests.jdbc.ee.dateTime.dateTime1.dateTimeClient1;
import com.sun.ts.tests.jdbc.ee.dateTime.dateTime2.dateTimeClient2;
import com.sun.ts.tests.jdbc.ee.dateTime.dateTime3.dateTimeClient3;
import com.sun.ts.tests.jdbc.ee.dbMeta.dbMeta1.dbMetaClient1;
import com.sun.ts.tests.jdbc.ee.dbMeta.dbMeta2.dbMetaClient2;
import com.sun.ts.tests.jdbc.ee.dbMeta.dbMeta5.dbMetaClient5;
import com.sun.ts.tests.jdbc.ee.dbMeta.dbMeta6.dbMetaClient6;
import com.sun.ts.tests.jdbc.ee.dbMeta.dbMeta7.dbMetaClient7;
import com.sun.ts.tests.jdbc.ee.dbMeta.dbMeta10.dbMetaClient10;
import com.sun.ts.tests.jdbc.ee.dbMeta.dbMeta11.dbMetaClient11;
import com.sun.ts.tests.jdbc.ee.dbMeta.dbMeta12.dbMetaClient12;
import com.sun.ts.tests.jdbc.ee.dbMeta.dbMeta3.dbMetaClient3;
import com.sun.ts.tests.jdbc.ee.dbMeta.dbMeta4.dbMetaClient4;
import com.sun.ts.tests.jdbc.ee.dbMeta.dbMeta9.dbMetaClient9;
import com.sun.ts.tests.jdbc.ee.dbMeta.dbMeta8.dbMetaClient8;
import com.sun.ts.tests.jdbc.ee.escapeSyntax.scalar1.scalarClient1;
import com.sun.ts.tests.jdbc.ee.escapeSyntax.scalar2.scalarClient2;
import com.sun.ts.tests.jdbc.ee.escapeSyntax.scalar3.scalarClient3;
import com.sun.ts.tests.jdbc.ee.escapeSyntax.scalar4.scalarClient4;
import com.sun.ts.tests.jdbc.ee.exception.batUpdExcept.batUpdExceptClient;
import com.sun.ts.tests.jdbc.ee.exception.sqlException.sqlExceptionClient;
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
import com.sun.ts.tests.jdbc.ee.resultSet.resultSet47.resultSetClient47;
import com.sun.ts.tests.jdbc.ee.resultSet.resultSet49.resultSetClient49;
import com.sun.ts.tests.jdbc.ee.resultSet.resultSet7.resultSetClient7;
import com.sun.ts.tests.jdbc.ee.rsMeta.rsMetaClient;
import com.sun.ts.tests.jdbc.ee.stmt.stmt1.stmtClient1;
import com.sun.ts.tests.jdbc.ee.stmt.stmt2.stmtClient2;
import com.sun.ts.tests.jdbc.ee.stmt.stmt3.stmtClient3;

import java.util.ArrayList;
import java.util.List;


public class TestRunner {
	static List<ServiceEETest> failed = new ArrayList<>();

	private static void run(ServiceEETest t, String[] args) {
		System.setProperty("exclude.list", "exclude");
		System.setProperty("current.dir", "jakartaee-tck/src/com/sun/ts/tests/jdbc/ee");
		Status s = t.run(args, System.out, System.err);
		if (!s.isPassed()) {
			failed.add(t);
		}
	}

	public static void main(String[] args) {
		run(new connectionClient1(), args);

		run(new dateTimeClient1(), args);
		run(new dateTimeClient2(), args);
		run(new dateTimeClient3(), args);

		run(new dbMetaClient1(), args);
		run(new dbMetaClient2(), args);
		run(new dbMetaClient3(), args);
		run(new dbMetaClient4(), args);
		run(new dbMetaClient5(), args);
		run(new dbMetaClient6(), args);
		run(new dbMetaClient7(), args);
		run(new dbMetaClient8(), args);
		run(new dbMetaClient9(), args);
		run(new dbMetaClient10(), args);
		run(new dbMetaClient11(), args);
		run(new dbMetaClient12(), args);

		run(new scalarClient1(), args);
		run(new scalarClient2(), args);
		run(new scalarClient3(), args);
		run(new scalarClient4(), args);

		run(new batUpdExceptClient(), args);
		run(new sqlExceptionClient(), args);

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

		run(new resultSetClient1(), args);
		run(new resultSetClient7(), args);
		run(new resultSetClient10(), args);
		run(new resultSetClient11(), args);
		run(new resultSetClient14(), args);
		run(new resultSetClient17(), args);
		run(new resultSetClient18(), args);
		run(new resultSetClient41(), args);
		run(new resultSetClient45(), args);
		run(new resultSetClient47(), args); // varbinary stuff
		run(new resultSetClient49(), args); // time & timestamps

		// run(new batUpdExceptClient(), args); // not supported yet

		// special snowflake rsMetaClient has a bug that expects ftable to be ctstable2
		String[] args_meta = new String[args.length+1];
		System.arraycopy(args, 0, args_meta, 0, args.length);
		args_meta[args_meta.length-1] = "-dftable=ctstable2";
		run(new rsMetaClient(), args_meta);

		run(new stmtClient1(), args);
		run(new stmtClient2(), args);
		run(new stmtClient3(), args);

		if (failed.isEmpty()) {
			System.exit(0);
		} else {
			for (ServiceEETest test : failed) {
				System.out.printf("%s failed%n", test.getClass().getName());
			}
			System.exit(-1);
		}
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
 