package wyce;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import wyautl_old.lang.Automaton;
import wycc.lang.Attribute;
import wyil.lang.Block;
import wyil.lang.Constant;
import wyil.lang.Type;
import wyil.lang.Type.Record.State;
import wyil.lang.WyilFile;
import wyil.lang.Block.Entry;
import wyil.lang.WyilFile.Case;
import wyil.lang.WyilFile.ConstantDeclaration;
import wyil.lang.WyilFile.Declaration;
import wyil.lang.WyilFile.FunctionOrMethodDeclaration;
import wyil.lang.WyilFile.TypeDeclaration;

public class PrettyPrinter {
	private final int TERMINAL = 1; // terminal output : 1 => on, 0 => off
	private final int FILE = 2;
	private final String INDENT = Config.INDENT;
	private final String SP = Config.SP;

	private HashMap<String,HashMap<Integer, String>> scopeCollection;
	private boolean outputFileCreated = false;

	public PrettyPrinter(){
		scopeCollection = new HashMap<String,HashMap<Integer, String>>();
	}

	public void print(WyilFile wyilFile){
		print(TERMINAL, Config.credits());
		print(TERMINAL, "Terminal Printer");
		print(TERMINAL, "Prints a C file to; " +Config.OUTPUT_FILE +"\n");

		print(TERMINAL, "# Whiley Intermediate Object ID : " +wyilFile.id());
		print(TERMINAL, "# ToString : " +wyilFile.toString());
		print(TERMINAL, "# Filename : " +wyilFile.filename());
		print(TERMINAL, "# HashCode : " +wyilFile.hashCode());

		print_Header(wyilFile);
		print_methods(wyilFile);
	}

	/**
	 * Create the header information.
	 * Included in the output .c file.
	 */
	private void print_Header(WyilFile wyilFile){
		print(TERMINAL, "\n"+INDENT+INDENT +"####################################################"
				+ "\n"+INDENT+INDENT +"### HEADER FILE ####################################\n");
		print(TERMINAL+FILE, "#define LIBRARY_TESTING 0\n");
		print(TERMINAL+FILE, "#include \""+Config.COMPILER_h +"\"");
		print(TERMINAL+FILE, "#include \""+Config.COMPILER_LIBRARY_c +"\"");

		print_constants(wyilFile);
		print_types(wyilFile);
		print_declarations(wyilFile);

		print(TERMINAL, "\n"+INDENT+INDENT+"### end of HEADER FILE #############################"
				+ "\n"+INDENT+INDENT+"####################################################");
	}

	/////////////////////// CONSTANTS ////////////////////////////////////////////
	private void print_constants(WyilFile wyilFile){
		print(TERMINAL, "\n"+INDENT+INDENT +"####################################################");
		print(TERMINAL, "### Constants : " +wyilFile.constants());
		print(TERMINAL, "# Constants count : " +wyilFile.constants().size());
		String r = "";
		Iterator<ConstantDeclaration> itr = wyilFile.constants().iterator();
		while(itr.hasNext()){
			r += "const" +SP;
			ConstantDeclaration decl = itr.next();
			Constant constant = decl.constant();
			if  (constant instanceof Constant.Integer){ r += "int" +SP; }
			else if(constant instanceof Constant.Bool){ r += "bool" +SP; }
			else if(constant instanceof Constant.Char){ r += "char" +SP; }
			else if(constant instanceof Constant.Strung){ r += "char*" +SP; }
			else if(constant instanceof Constant.Decimal){ r += "double" +SP; }
			else throw new Error("Constant error, not yet allowed for.");
			r += decl.name() +SP;
			r += "=" +SP;
			r += constant +SP;
			r += ";\n";
		}
		print(TERMINAL+FILE, r);
	}
	/////////////////////// TYPES ////////////////////////////////////////////
	private void print_types(WyilFile wyilFile){
		print(TERMINAL, "\n"+INDENT+INDENT +"####################################################");
		print(TERMINAL, "### Types : " +wyilFile.types());
		print(TERMINAL, "# Types count : " +wyilFile.types().size());
		String r = "";
		Iterator<TypeDeclaration> itr = wyilFile.types().iterator();
		while(itr.hasNext()){
			r += "const" +SP;
			TypeDeclaration decl = itr.next();
			Type type = decl.type();
			if  (type instanceof Type.Int){ r += "int" +SP; }
			else if(type instanceof Type.Bool){ r += "bool" +SP; }
			else if(type instanceof Type.Char){ r += "char" +SP; }
			else if(type instanceof Type.Strung){ r += "char*" +SP; }
			else if(type instanceof Type.Real){ r += "double" +SP; }
			else if(type instanceof Type.Tuple){ r += "tuple XXX" +SP; }
			else if(type instanceof Type.Record){ r += "record XXX" +SP; }
			else if(type instanceof Type.Union){
				// this method deals with the generation
				print(TERMINAL+FILE, generateUnionType(decl)); continue; }
			else throw new Error("type error, not yet allowed for.");
			r += decl.name() +SP;
			r += "=" +SP;
			r += type +SP;
			r += ";\n";
		}
		print(TERMINAL+FILE, r);

	}
	/*
	 * Union types are interesting...
	 * By using an "Any" type, the union choice is made at the struct level.
	 * typedef struct {
     * 	  int type;
     * 	  union Data data;
	 * } Any;
	 *
	 * union Data{
     *    int i;
	 * 	  bool b;
     * 	  char c;
     * 	  char s[MAXCHAR+1];
     *    void *ptr;
	 * };
	 *
	 * It gets complicated when a part of the union is a new struct. In this case, we create a new struct
	 * and use the void *ptr to point to it.
	 * typedef struct{
	 *    int data;
	 *    Tree left;
	 *    Tree right;
	 * } Tree
	 *
	 * This means a malloc to create the memory space for the pointer and freeing it afterwards.
	 *    ptr = (void *)malloc(sizeof(int));
	 *    free(ptr);
	 * AND every time the contents of the pointer is read, it must be cast.
	 *    int x = (int *)ptr; or (int)&ptr; ???
	 */
	private String generateUnionType(TypeDeclaration decl){
		String r = "";

		/*
		 * Leaving this alone for the time being.
		 * Union Types use Automaton which allows recursive data structures like trees.
		 * But to write code to utilise it will take too much time at this point for
		 * possibly limited gain.
		 * Davids view is to not include recursive data structures. 30/04/14
		 */
//		Type type = decl.type();
//		Type.Union union = (Type.Union) type;
//		r += union.automaton +"\n\n";
//		r += "union" +SP;
//		r += decl.name() +SP;
//		r += "{" +SP;
//		int i = 0;
//		while( i< union.automaton.states.length -1){
//			i = i+1;
//			r += "," +SP;
//			if(union.automaton.states[i].data != null){
//				Automaton.State rec = union.automaton.states[i];
//				r += union.automaton.states[i].data;
//				r += union.automaton.states[i].kind;
//			}
//		}
//		r += "}";

		return r; // just returning an empty string
	}

	/////////////////////// DECLARATIONS ////////////////////////////////////////////
	private void print_declarations(WyilFile wyilFile){
		Collection<Declaration> list = wyilFile.declarations();
		print(TERMINAL, "\n"+INDENT+INDENT +"####################################################");
		print(TERMINAL, "### Declarations : " +wyilFile.declarations());
		print(TERMINAL, "# Declarations count : " +wyilFile.declarations().size());

		Iterator<Declaration> itr = list.iterator();
		while(itr.hasNext()){
			Declaration d = itr.next();
			print(TERMINAL, "\n"+INDENT+INDENT +"##### Declaration start #####");
			print(TERMINAL, "# Declaration toString : " + d.toString());
			print(TERMINAL, "# Declaration Class toString : " + d.getClass().toString());

			List<Attribute> l = d.attributes();
			Iterator<Attribute> attItr = l.iterator();
			if(!attItr.hasNext()) print(TERMINAL, "# Holds no attributes.");
			while(attItr.hasNext()){
				Attribute att = attItr.next();
				print(TERMINAL, "# Declaration attribute toString : " + att.toString());
			}

			// method declarations
			if(Config.isMainMethod(d))
				print(TERMINAL, "# Main method declaration, not printed to file.");
			else
				print(TERMINAL+FILE, new C_Declarations(d).toString());
		}
	}

	/////////////////////// METHODS ////////////////////////////////////////////
	private void print_methods(WyilFile wyilFile){
		Collection<FunctionOrMethodDeclaration> list = wyilFile.methods();
		print(TERMINAL, "\n"+INDENT+INDENT +"####################################################");
		print(TERMINAL, "### Methods    : " +wyilFile.methods());
		print(TERMINAL, "# Methods count : " +list.size());

		Iterator<FunctionOrMethodDeclaration> itr = list.iterator();
		while(itr.hasNext()){
			FunctionOrMethodDeclaration method = itr.next();
			print(TERMINAL, "\n"+INDENT+INDENT +"##### Method start #####");
			print(TERMINAL, "# Method name : " + method.name());
			print(TERMINAL, "# Method isa method ? : " + method.isMethod());

			String signature = new C_Declarations(method).toString();
			signature = signature.substring(0, signature.length()-1);
			signature = insertParamName(signature);

			// each method gets its own register of variable names
			HashMap<Integer, String> register = new HashMap<Integer, String>();
			register.put(Integer.MAX_VALUE, "new scope");
			scopeCollection.put(method.name(), register);

			// method name and block
			print(TERMINAL+FILE, "\n" +signature +"{");
			print_cases(method.name(), method);
			print(TERMINAL+FILE, "}");

		}

	}

	private void print_cases(String methodName, FunctionOrMethodDeclaration method){
		Iterator<Case> caseItr = method.cases().iterator();
		Case _case = caseItr.next();

		print(TERMINAL, "\n" +INDENT+INDENT +"# Method case toString : " + _case.toString());
		Block block = _case.body();
		List<String> locals = _case.locals();
		print(TERMINAL, "# Method case locals : " + locals);
		print(TERMINAL, "# Method case locals count : " + locals.size());

		print(TERMINAL, "# Method case block : " + block.toString());
		print(TERMINAL, "# Method case block count : " + block.size());

		// statements within a method block
		print_statements(methodName, block);
	}

	private void print_statements(String methodName, Block block){
		Iterator<Entry> entryItr = block.iterator();
		Statements statements = new Statements();
		int i=0;
		print(TERMINAL, "");
		while(entryItr.hasNext()){
			Entry entry = entryItr.next();
			print(TERMINAL, "\n" +INDENT+INDENT +"# Method case block entry "+ i++ +"    : " + entry.toString());
			print(TERMINAL, " # Method case block attributes : " + entry.attributes().toString());

			// statements within a method block
			statements.create(entry.code, scopeCollection.get(methodName));

			print(TERMINAL+FILE, INDENT +statements);
		}
	}

	/////////////// HELPERS ///////////////////////////
	/** Inserts parameter names into a method signature.
	 *  TODO currently uses a0, a1, a2... for parameter names, might be a problem later?
	 */
	private String insertParamName(String sig){
		//if(sig.startsWith("main")) return "";
		String params = sig.substring(sig.indexOf("(")+1, sig.length()-2).trim();
		if(!params.equals("")){
			int i = 0;
			String[] tokens = params.split(",");
			// tidy up tokens, add the var name
			while(i< tokens.length){
				String token = tokens[i].trim();
				int index = token.indexOf("[]");
				if(index == -1){
					token = token +" " +Config.PRE +i;
				}else{
					token = token.substring(0, index) + SP;
					token += Config.PRE +i;
					token += "[]";
					tokens[i++] = token;
					// next element is arraySize
					tokens[i++] = "Any " + Config.ARRAY_SIZE;
					continue;
				}
				tokens[i++] = token;
			}
			// reset params, ready for changes
			params = "";
			i = 0;
			// recreate the param list
			boolean first = true;
			while(i< tokens.length){
				params += first ? "" : ", ";
				params += tokens[i++];
				first = false;
			}
			params = " "+params+" ";
		}
		sig = sig.substring(0, sig.indexOf("(")+1) + params + ")";

		return sig;
	}

	/**
	 * Print function to terminal and/or output file.
	 * Tokens are not printed to the output file
	 * @param destination : 1 => terminal, 2 => output file, 3 => both
	 * @param text : a single statement. May be empty or null,
	 */
	private void print(int destination, String text){
		if(text != null && !text.isEmpty()){
			String indent = INDENT;
			if(destination == 2 || destination == 3)
				indent = "";
			if(destination == TERMINAL){
				System.out.println(indent+indent+indent +text);
			}else if(destination == FILE){
				if(!text.trim().startsWith("@")) // check for tokens, do not print in file
					outputFileCreated = file_println(Config.OUTPUT_FILE, outputFileCreated, text);
			}else if(destination == TERMINAL + FILE){
				System.out.println(indent+indent+indent +text);
				if(!text.trim().startsWith("@")) // check for tokens, do not print in file
					outputFileCreated = file_println(Config.OUTPUT_FILE, outputFileCreated, text);
			}
		}
	}

	/**
	 * Append text to the end of an output file.
	 * @param output_file
	 * @param text
	 */
	private boolean file_println(String output_file, boolean outputFileCreated, String text){
		try{
    		File file =new File(output_file);

    		// create file?
    		if(!outputFileCreated){
    			file.delete();
    			file.createNewFile();
    			outputFileCreated = true;
    		}

    		//append line to file
    		FileWriter fileWritter = new FileWriter(file.getPath(),true);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
    	        bufferWritter.write(text +"\n");
    	        bufferWritter.close();

    	}catch(IOException e){
    		e.printStackTrace();
    	}
		return outputFileCreated;
	}
}
