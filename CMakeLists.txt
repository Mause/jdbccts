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

file(GLOB JAVA_SRC_FILES
  jakartaee-tck/jdbc/src/main/java/com/sun/ts/tests/jdbc/ee/*/*/*.java
  jakartaee-tck/common/src/main/java/com/sun/ts/lib/harness/*.java
  src/nl/cwi/da/jdbccts/*.java
)
set(CMAKE_JAVA_INCLUDE_PATH jakartaee-tck/src src)
add_jar(jdbccts ${JAVA_SRC_FILES})
