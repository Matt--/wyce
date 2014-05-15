package wyce;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

import wyil.lang.WyilFile.Declaration;
import wyil.lang.WyilFile.FunctionOrMethodDeclaration;

public class Config {

	public static final String SP = " ";
	public static final String PREFIX = "a";

	public static final String PRE = Config.PREFIX;
	public static final String PRE_LOOP = "loop_start_";
	public static final String ARRAY_SIZE = "arraySize";
	public static final String INDENT = "  ";
	public static final String OUTPUT_FILE = "a.c";
	public static final String COMPILER_h = 		"cCompiler/mattCompiler.h";
	public static final String COMPILER_LIBRARY_c = "cCompiler/mattCompiler_library.c";
	public static final String TEST_FILES = "whiley/_testC/";

  // CODE FILES
	public static final String CODE1  = "./whileytoC/main_leds.wyil";
	public static final String CODE2  = "./whileytoC/main_motors.wyil";

  // TEST FILES
	public static final String FILE1  = "./whiley/helloWorld.wyil"; // DONE
	public static final String FILE2  = "./whiley/hellocount.wyil"; // DONE
	public static final String FILE3  = "./whiley/fourBasicMathOps.wyil"; // DONE
	public static final String FILE4  = "./whiley/comparatorOps.wyil"; // DONE
	public static final String FILE5  = "./whiley/mathBrackets.wyil"; // DONE
	public static final String FILE6  = "./whiley/charOps.wyil"; // DONE
	public static final String FILE7  = "./whiley/stringOps.wyil"; // DONE
	public static final String FILE8  = "./whiley/boolOps.wyil"; // DONE
	// examples from Whiley Language Spec
	public static final String FILE9 = "./whiley/3_constantDeclarations.wyil"; // DONE
//	public static final String FILE10 = "./whiley/3_typeDeclarations.wyil"; // exclude 6/5
//	public static final String FILE11  = "./whiley/3_typeAndFunctionNamesNoClash.wyil"; // exclude 6/5
//	public static final String FILE12 = "./whiley/3_functionDeclaration_withEnsures.wyil"; // exclude 6/5
//	public static final String FILE13 = "./whiley/3_methodDeclaration_withPointer.wyil";
	public static final String FILE14 = "./whiley/4_typeUnions.wyil"; // DONE
//	public static final String FILE15 = "./whiley/4_nullAndTree.wyil"; //// ignore recursive data structures. perhaps later. => David 30/4
	public static final String FILE16 = "./whiley/4_boolTypeAndUsesArray.wyil"; // DONE
	public static final String FILE17 = "./whiley/4_byteTypeAndForiInLoop.wyil"; // done loop stuff, rewrite test case to move the byte operations 30/4
//	public static final String FILE18 = "./whiley/4_recursion.wyil"; // skipped 29/4
//	public static final String FILE19 = "./whiley/4_realAndRationalDeconstruction.wyil"; //// ignore => David 29/4

	// mostly done. an issue with the second IfIs entry using label0 instead of a later label.
	// cannot get it compiled with wyc, issue raised.
//	public static final String FILE20 = "./whiley/4_anyType.wyil"; // exclude 6/5
	public static final String FILE21 = "./whiley/4_tuples.wyil"; // DONE, was a pointer nightmare...
//	public static final String FILE22 = "./whiley/4_records.wyil";
//	public static final String FILE23 = "./whiley/4_referencesPointers.wyil"; //// ignore => David 29/4
	public static final String FILE24 = "./whiley/4_sets.wyil";
	public static final String FILE25 = "./whiley/4_maps.wyil";
	public static final String FILE26 = "./whiley/4_lists.wyil";
//	public static final String FILE27 = "./whiley/4_functionMethodTypesAndAssignment.wyil"; //// ignore => David 29/4
	public static final String FILE28 = "./whiley/4_unionTypes.wyil";
//	public static final String FILE29 = "./whiley/4_intersectionTypes.wyil";
//	public static final String FILE30 = "./whiley/4_negationTypes.wyil"; //// ignore => David 29/4
	public static final String FILE31 = "./whiley/5_blocks.wyil";
//	public static final String FILE32 = "./whiley/5_assert.wyil"; // exclude 6/5
	public static final String FILE33 = "./whiley/5_assignment.wyil";
//	public static final String FILE34 = "./whiley/5_assume.wyil"; // exclude 6/5
	public static final String FILE35 = "./whiley/5_break.wyil";
//	public static final String FILE36 = "./whiley/5_continue.wyil";
//	public static final String FILE37 = "./whiley/5_debug.wyil"; // exclude 6/5
//	public static final String FILE38 = "./whiley/5_doWhile.wyil"; // exclude 6/5
//	public static final String FILE39 = "./whiley/5_for.wyil";
//	public static final String FILE40 = "./whiley/5_switch.wyil"; // exclude 6/5
//	public static final String FILE41 = "./whiley/5_tryCatch.wyil"; //// ignore => David 29/4
//	public static final String FILE42 = "./whiley/5_throws.wyil"; //// ignore => David 29/4
//	public static final String FILE43 = "./whiley/5_continue.wyil"; // exclude 6/5
	public static final String FILE44 = "./whiley/5_ifElse.wyil";
//	public static final String FILE45 = "./whiley/5_skip.wyil"; // exclude 6/5
	public static final String FILE46 = "./whiley/5_while.wyil";
	// Whiley Getting Started guide
//	public static final String FILE47 = "./whiley/coercians.wyil";
//	public static final String FILE48 = "./whiley/subtyping.wyil"; // exclude 6/5
//	public static final String FILE49 = "./whiley/prePostconditions.wyil"; // exclude 6/5
//	public static final String FILE50 = "./whiley/typeInvariants.wyil"; //// ignore => David 29/4
//	public static final String FILE51 = "./whiley/recursiveTypes.wyil"; //// ignore => David 29/4
	public static final String FILE52 = "./whiley/whileMinimal.wyil";
	public static final String FILE53 = "./whileytoC/main_leds.wyil";
	public static final String FILE54 = "./whileytoC/main_motors.wyil";
//	public static final String FILE55 = "./whiley/.wyil";
//	public static final String FILE56 = "./whiley/.wyil";

//	public static final String FILE60 = "./whiley/8_loopInvariant.wyil"; //// ignore => David 29/4



	public static String credits(){
		String r ="";
		r += "\nWhiley Intermediate to C Compiler Library.\n";
		r += "Author : Matt Stevens, Honours student, Victoria University 2014\n\n";
		return r;
	}


	////////////////// Helpers //////////////////////

	public static boolean isMainMethod(Declaration d){
		if(d instanceof FunctionOrMethodDeclaration)
			if( ((FunctionOrMethodDeclaration) d).name().equals("main") )
				return true;
		return false;
	}

	//======================================================
	// Test Helpers
	//======================================================

	public static String readFile(String filename) {
		// will throw a wobbly if passed a test filename with ".c"
		// unless it has the correct path too.
		if(!filename.endsWith(".c")){
			filename = TEST_FILES + filename + ".c";
		}
		File f = new File(filename);
		try {
			byte[] bytes = Files.readAllBytes(f.toPath());
			String r = new String(bytes,"UTF-8");
			// end of line stuff causes problems
			r = standardiseEoL(r);
			// labels cause problems
			r = removeLabels(r);
			return r;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	// Label numbers are set by the compiler and uses a counter that does not reset
	// in junit tests. This means the label name varies depending on the previous junit tests.
	// This strips out the labels for comparing results.
	private static String removeLabels(String s){
		return s.replaceAll("label\\d+", "labelToken");
	}
	private static String standardiseEoL(String s){
		return s.replaceAll("\r\n", "\n");
	}
}
