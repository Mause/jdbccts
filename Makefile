.PHONY: all jar clean update test

all: jar

DUCKDB_JAR=duckdb.jar

clean:
	rm -rf build

build/jdbccts.jar: jakartaee-tck update
	mkdir -p build && cd build && cmake .. && cmake --build .

jar: build/jdbccts.jar

jakartaee-tck:
	git clone https://github.com/eclipse-ee4j/jakartaee-tck.git --depth 10

update: jakartaee-tck
	(cd jakartaee-tck; git pull)

test: jar
	java -cp $(DUCKDB_JAR):build/jdbccts.jar -Dcurrent.dir=.jakartaee-tck/src/com/sun/ts/tests/jdbc/ee -Dexclude.list=exclude nl.cwi.da.jdbccts.TestRunner -p props
