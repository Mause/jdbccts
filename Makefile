.PHONY: all jar clean update test

all: jar
# fixme this is a hardcoded path
# DUCKDB_JAR=/Users/hannes/source/duckdb/build/jdbc/tools/jdbc/DuckDBJ.jar

clean:
	rm -rf build

jar: jakartaee-tck update
	mvn package -f jakartaee-tck/jdbc/pom.xml
	mkdir -p build && cd build && cmake .. && cmake --build .

jakartaee-tck:
	git clone https://github.com/eclipse-ee4j/jakartaee-tck.git --depth 10

update: jakartaee-tck
	(cd jakartaee-tck; git pull)

test: jar
	java -cp $(DUCKDB_JAR):build/jdbccts.jar -Dcurrent.dir=.jakartaee-tck/src/com/sun/ts/tests/jdbc/ee -Dexclude.list=exclude nl.cwi.da.jdbccts.TestRunner -p props
