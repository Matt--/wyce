package wyce;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {
	String header = "#define LIBRARY_TESTING 0\n\n"+
			"#include \"cCompiler/mattCompiler.h\"\n"+
			"#include \"cCompiler/mattCompiler_library.c\"\n";//107
	String TEST = "true";

	@Test
	public void test_file01() {
		Wyce.main( new String[]{TEST, Config.FILE1} );
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("helloWorld");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}
	@Test
	public void test_file02() {
		Wyce.main( new String[]{TEST, Config.FILE2} );
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("hellocount");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}
	@Test
	public void test_file03() {
		Wyce.main( new String[]{TEST, Config.FILE3} );
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("fourBasicMathOps");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}
	@Test
	public void test_file04() {
		Wyce.main( new String[]{TEST, Config.FILE4} );
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("comparatorOps");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}
	@Test
	public void test_file05() {
		Wyce.main( new String[]{TEST, Config.FILE5} );
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("mathBrackets");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}
	@Test
	public void test_file06() {
		Wyce.main( new String[]{TEST, Config.FILE6} );
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("charOps");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}
	@Test
	public void test_file07() {
		Wyce.main( new String[]{TEST, Config.FILE7} );
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("stringOps");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}
	@Test
	public void test_file08() {
		Wyce.main( new String[]{TEST, Config.FILE8} );
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("boolOps");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}
	@Test
	public void test_file09() {
		Wyce.main( new String[]{TEST, Config.FILE9} );
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("3_constantDeclarations");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}
	@Test
	public void test_file14() {
		Wyce.main( new String[]{TEST, Config.FILE14} );
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("4_typeUnions");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}
	@Test
	public void test_file16() {
		Wyce.main( new String[]{TEST, Config.FILE16} );
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("4_boolTypeAndUsesArray");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}
	@Test
	public void test_file21() {
		Wyce.main( new String[]{TEST, Config.FILE21} );
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("4_tuples");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}
	@Test
	public void test_file52() {
		Wyce.main( new String[]{TEST, Config.FILE52} );
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("whileMinimal");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}
	@Test
	public void test_file53() {
		Wyce.main( new String[]{"false", Config.FILE53} );
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("whiley_main_leds");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}
	@Test
	public void test_file54() {
		Wyce.main( new String[]{"false", Config.FILE54} );
		String result = Config.readFile(Config.OUTPUT_FILE);
		String expect = Config.readFile("whiley_main_motors");

		assertEquals(expect, result);
		assertEquals(expect.length(), result.length());
	}


}
