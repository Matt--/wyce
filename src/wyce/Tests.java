package wyce;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {
	String header = "#define LIBRARY_TESTING 0\n\n"+
			"#include \"cCompiler/mattCompiler.h\"\n"+
			"#include \"cCompiler/mattCompiler_library.c\"\n";//107

	@Test
	public void test_file01() {
		String[] args = {Config.FILE1};
		Wyce.main(args);
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("helloWorld");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}
	@Test
	public void test_file02() {
		String[] args = {Config.FILE2};
		Wyce.main(args);
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("hellocount");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}
	@Test
	public void test_file03() {
		String[] args = {Config.FILE3};
		Wyce.main(args);
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("fourBasicMathOps");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}
	@Test
	public void test_file04() { // TODO fails, not fleshed out
		String[] args = {Config.FILE4};
		Wyce.main(args);
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("comparatorOps");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}
	@Test
	public void test_file05() {
		String[] args = {Config.FILE5};
		Wyce.main(args);
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("mathBrackets");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}
	@Test
	public void test_file06() { // TODO fails, not fleshed out
		String[] args = {Config.FILE6};
		Wyce.main(args);
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("charOps");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}
	@Test
	public void test_file07() {
		String[] args = {Config.FILE7};
		Wyce.main(args);
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("stringOps");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}
	@Test
	public void test_file08() {
		String[] args = {Config.FILE8};
		Wyce.main(args);
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("boolOps");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}
	@Test
	public void test_file09() {
		String[] args = {Config.FILE9};
		Wyce.main(args);
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("3_constantDeclarations");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}
	@Test
	public void test_file14() {
		String[] args = {Config.FILE14};
		Wyce.main(args);
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("4_typeUnions");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}
	@Test
	public void test_file16() {
		String[] args = {Config.FILE16};
		Wyce.main(args);
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("4_boolTypeAndUsesArray");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}
	@Test
	public void test_file21() {
		String[] args = {Config.FILE21};
		Wyce.main(args);
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("4_tuples");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}
	@Test
	public void test_file52() {
		String[] args = {Config.FILE52};
		Wyce.main(args);
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("whileMinimal");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}


}
