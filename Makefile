.PHONY: all jar clean update test

all: jar
# fixme this is a hardcoded path
# DUCKDB_JAR=/Users/hannes/source/duckdb/build/jdbc/tools/jdbc/DuckDBJ.jar

clean:
	rm -rf build

jar: jakartaee-tck update
	mvn install:install-file -Dfile=jakartaee-tck/lib/javatest.jar -DgroupId=javatest -DartifactId=javatest -Dversion=5.0 -Dpackaging=jar
	mvn install -f jakartaee-tck/pom.xml -pl jdbc -am
	mkdir -p build && cd build && cmake .. && cmake --build .

jakartaee-tck:
	git clone https://github.com/eclipse-ee4j/jakartaee-tck.git --depth 10

update: jakartaee-tck
	(cd jakartaee-tck; git pull)

test: jar
	java -cp $(DUCKDB_JAR):duckdb.jar:jakartaee-tck/libutil/target/libutil-11.0.0-SNAPSHOT.jar:jakartaee-tck/jdbc/target/jdbc-11.0.0-SNAPSHOT.jar:jakartaee-tck/common/target/common-11.0.0-SNAPSHOT.jar:build/jdbccts.jar -Dcurrent.dir=.jakartaee-tck/src/com/sun/ts/tests/jdbc/ee -Dexclude.list=exclude nl.cwi.da.jdbccts.TestRunner -p props
