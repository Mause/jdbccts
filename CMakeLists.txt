cmake_minimum_required(VERSION 3.0)

find_package(Java 1.8)

if(NOT Java_FOUND)
  message(FATAL_ERROR No
                      compatible
                      Java
                      found)
endif()

include(UseJava)
project(jdbccts NONE)

file(GLOB JAVA_SRC_FILES src/nl/cwi/da/jdbccts/*.java)
set(CMAKE_JAVA_INCLUDE_PATH jakartaee-tck/src src)
add_jar(jdbccts ${JAVA_SRC_FILES}
  INCLUDE_JARS
  jakartaee-tck/jdbc/target/jdbc-11.0.0-SNAPSHOT.jar
  jakartaee-tck/common/target/common-11.0.0-SNAPSHOT.jar
)
