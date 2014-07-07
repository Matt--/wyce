package wyce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

import wyil.lang.Code.AbstractNaryAssignable;
import wyil.lang.Code;
import wyil.lang.Type;
import wyil.lang.Code.AbstractAssignable;
import wyil.lang.Code.AbstractSplitNaryAssignable;

public class Statements{
	protected String result;
	private HashMap<Integer, String> register;
	private Methods c_declarations;
	public Statements(){}

	/*
	 * Converts a single bytecode to mostly one, sometimes more, lines of C code.
	 */
	public Statements create(Code code, HashMap<Integer, String> register, Methods c_declarations){
		this.register = register;
		this.c_declarations = c_declarations;
		this.result = generateLine(code);
		// if tokens returned, they have already been put in register for later use {register_no, token_string}
		if(result.startsWith("@") && code instanceof AbstractAssignable){
			register.put(((AbstractAssignable)code).target, result); // note: indirectinvoke gives key of -1
			// this token may generate code...
			Token token = Token.getInstance().create(result, code, register);
			result = token.isEmpty() ? result : token.toString() ;
		}
		return this;
	}

	public String 	toString(){ return result; }
	public boolean 	startWith(String s){ return result.startsWith(s); }
	public boolean  endWith(String s){ return result.endsWith(s); }
	public void 	setResult(String s){ result = s; }
	public boolean 	isEmpty(){ return result.isEmpty(); }

	private String generateLine(Code code){
		if(code.toString().startsWith(".")){
			result = code.toString().substring(1) + ": ;";
			return result;
		}
		switch(code.opcode()){
		case(Code.OPCODE_add):
			result = createC(Code.OPCODE_add,	 (Code.BinArithOp) code); return result;
		case(Code.OPCODE_assertel):
		case(Code.OPCODE_asserteq):
		case(Code.OPCODE_assertge):
		case(Code.OPCODE_assertgt):
		case(Code.OPCODE_assertle):
		case(Code.OPCODE_assertlt):
		case(Code.OPCODE_assertne):
		case(Code.OPCODE_assertse):
		case(Code.OPCODE_assertss):
			result = createC(Code.OPCODE_assertss, (Code.Assert) code); return result;
		case(Code.OPCODE_bitwiseand):
			result = createC(Code.OPCODE_bitwiseand,  (Code.BinArithOp) code); return result;
		case(Code.OPCODE_assign):
			result = createC(Code.OPCODE_assign,  (Code.Assign) code); return result;
		case(Code.OPCODE_range):
			result = createC(Code.OPCODE_range,   (Code.BinArithOp) code); return result;
		case(Code.OPCODE_const):
			result = createC(Code.OPCODE_const,   (Code.Const) code); return result;
		case(Code.OPCODE_convert):
			result = createC(Code.OPCODE_convert, (Code.Convert) code); return result;
		case(Code.OPCODE_div):
			result = createC(Code.OPCODE_div,	 (Code.BinArithOp) code); return result;
		case(Code.OPCODE_fieldload):
			result = createC(Code.OPCODE_fieldload, (Code.FieldLoad) code); return result;
		case(Code.OPCODE_forall):
			result = createC(Code.OPCODE_forall,	 (Code.ForAll) code); return result;
		case(Code.OPCODE_goto):
			result = createC(Code.OPCODE_goto, (Code.Goto) code); return result;
		// If eq, ne, lt, le, gt, ge, in, ss and sse
		case(Code.OPCODE_ifeq):
			result = createC(Code.OPCODE_ifeq, (Code.If) code); return result;
		case(Code.OPCODE_ifne):
			result = createC(Code.OPCODE_ifne, (Code.If) code); return result;
		case(Code.OPCODE_iflt):
			result = createC(Code.OPCODE_iflt, (Code.If) code); return result;
		case(Code.OPCODE_ifle):
			result = createC(Code.OPCODE_ifle, (Code.If) code); return result;
		case(Code.OPCODE_ifgt):
			result = createC(Code.OPCODE_ifgt, (Code.If) code); return result;
		case(Code.OPCODE_ifge):
			result = createC(Code.OPCODE_ifge, (Code.If) code); return result;
		case(Code.OPCODE_ifis):
			result = createC(Code.OPCODE_ifis, (Code.IfIs) code); return result;
		case(Code.OPCODE_ifss):
			result = createC(Code.OPCODE_ifss, (Code.If) code); return result;
		case(Code.OPCODE_ifse):
			result = createC(Code.OPCODE_ifse, (Code.If) code); return result;
		case(Code.OPCODE_indexof):
			result = createC(Code.OPCODE_indexof, (Code.IndexOf) code); return result;
		case(Code.OPCODE_indirectinvokemdv):
			result = createC(Code.OPCODE_indirectinvokemdv, (Code.IndirectInvoke) code); return result;
		case(Code.OPCODE_invokefn):
			result = createC(Code.OPCODE_invokefn,(Code.Invoke) code); return result;
		case(Code.OPCODE_invokefnv):
			result = createC(Code.OPCODE_invokefnv,(Code.Invoke) code); return result;
		case(Code.OPCODE_invokemd):
			result = createC(Code.OPCODE_invokemd,(Code.Invoke) code); return result;
		case(Code.OPCODE_invokemdv):
			result = createC(Code.OPCODE_invokemdv,(Code.Invoke) code); return result;
		case(Code.OPCODE_lambdamd):
			result = createC(Code.OPCODE_lambdamd,  (Code.Lambda) code); return result;
		case(Code.OPCODE_lengthof):
			result = createC(Code.OPCODE_lengthof,  (Code.LengthOf) code); return result;
		case(Code.OPCODE_lshr):
			result = createC(Code.OPCODE_lshr,  (Code.BinArithOp) code); return result;
		case(Code.OPCODE_loop):
			result = createC(Code.OPCODE_loop,  (Code.Loop) code); return result;
		case(-1):
			result = createC(-1,	 			(Code.LoopEnd) code); return result;
		case(Code.OPCODE_mul):
			result = createC(Code.OPCODE_mul,	 (Code.BinArithOp) code); return result;
		case(Code.OPCODE_neg):
			result = createC(Code.OPCODE_neg,	 (Code.UnArithOp) code); return result;
		case(Code.OPCODE_newlist):
			result = createC(Code.OPCODE_newlist,	 (Code.NewList) code); return result;
		case(Code.OPCODE_newrecord):
			result = createC(Code.OPCODE_newrecord,	 (Code.NewRecord) code); return result;
		case(Code.OPCODE_newtuple):
			result = createC(Code.OPCODE_newtuple,	 (Code.NewTuple) code); return result;
		case(Code.OPCODE_nop):
			result = createC(Code.OPCODE_nop,	 (Code.Nop) code); return result;
		case(Code.OPCODE_return):
			result = createC(Code.OPCODE_return,	 (Code.Return) code); return result;
		case(Code.OPCODE_returnv):
			result = createC(Code.OPCODE_returnv, (Code.Return) code); return result;
		case(Code.OPCODE_rshr):
			result = createC(Code.OPCODE_rshr,  (Code.BinArithOp) code); return result;
		case(Code.OPCODE_sappend):
			result = (createC(Code.OPCODE_sappend, (Code.BinStringOp) code)); return result;
		case(Code.OPCODE_sappendl):
			result = (createC(Code.OPCODE_sappendl, (Code.BinStringOp) code)); return result;
		case(Code.OPCODE_sappendr):
			result = (createC(Code.OPCODE_sappendr, (Code.BinStringOp) code)); return result;
		case(Code.OPCODE_sub):
			result = createC(Code.OPCODE_sub,	 (Code.BinArithOp) code); return result;
		case(Code.OPCODE_tupleload):
			result = createC(Code.OPCODE_tupleload,	 (Code.TupleLoad) code); return result;

		}
		throw new Error("Calling a bytecode that has no corrosponding Statement. opcode : "+code.opcode()+" bytecode : " +code.toString());
	}

	/////////////////// OVERLOADED createC() ///////////////////////////
	protected final String SP = Config.SP;
	protected final String PRE = Config.PREFIX;

	private String createC(int opcode, Code.Assert code){
		// Asserts are ignored, assuming wyc does all the work (checked this assumption, Dave 29/4)
		switch(opcode){
		case(Code.OPCODE_assertel):
		case(Code.OPCODE_asserteq):
		case(Code.OPCODE_assertge):
		case(Code.OPCODE_assertgt):
		case(Code.OPCODE_assertle):
		case(Code.OPCODE_assertlt):
		case(Code.OPCODE_assertne):
		case(Code.OPCODE_assertse):
		case(Code.OPCODE_assertss):
		}
		return "@ignore";
	}
	private String createC(int opcode, Code.Assign code){
		String r = "";
		// Any target = operand;
		r += lhs_assignment(code);
		// case where a method parameter is not in the register, this will bite or be fixed later
		// ref Compiler.jave ln 324
//		r += register.get(code.operand) == null ? PRE + code.operand : register.get(code.operand);
		r += register.get(code.operand);
		return r + ";";
	}
	private String createC(int opcode, Code.BinArithOp code){
		String r = "";
		switch(opcode){
		case(Code.OPCODE_add):
			// type target = constant ;
			r += lhs_assignment(code);
			r += "add(" +SP;
			r += PRE +code.leftOperand +SP;
			r += "," +SP;
			r += PRE +code.rightOperand;
			r += ")";
			break;
		case(Code.OPCODE_sub):
			// type target = constant ;
			r += lhs_assignment(code);
			r += "sub(" +SP;
			r += PRE +code.leftOperand +SP;
			r += "," +SP;
			r += PRE +code.rightOperand;
			r += ")";
			break;
		case(Code.OPCODE_mul):
			// type target = constant ;
			r += lhs_assignment(code);
			r += "mul(" +SP;
			r += PRE +code.leftOperand +SP;
			r += "," +SP;
			r += PRE +code.rightOperand;
			r += ")";
			break;
		case(Code.OPCODE_div):
			// type target = constant ;
			r += lhs_assignment(code);
			r += "div_wyce(" +SP;
			r += PRE +code.leftOperand +SP;
			r += "," +SP;
			r += PRE +code.rightOperand;
			r += ")";
			break;
		case(Code.OPCODE_range):
			if(register.containsKey(code.target)) r += "Any[]" +SP;
			r += PRE + code.leftOperand;
			r += "," +SP;
			r += PRE +code.rightOperand;
			r += "}";
			break;
		case(Code.OPCODE_bitwiseand):
			return "@ignore";
		case(Code.OPCODE_rshr): // rightshift
			return "@ignore";
		case(Code.OPCODE_lshr): // leftshift
			return "@ignore";
		default:
			throw new Error("Error: createC(int opCode, Code.BinArithOp), opcode not catered for.");
		}
		return r + ";";
	}
	private String createC(int opcode, Code.BinStringOp code){
		String r = "";
		switch(code.kind){
		case LEFT_APPEND:
			// strcat( a1, a2 ) concatenate onto STRING a1, CHAR a2
			r += "Any charNowStr = toStr(";
			r += PRE +code.rightOperand;
			r += ");\n  "; // NB 2 space tab here
			r += lhs_assignment(code);
			r += "Str(" +SP;
			r += "strcat (" +SP;
			r += PRE +code.leftOperand +".s ," +SP;
			r += "charNowStr.s )" +SP;
			r += ");";
			break;
		case RIGHT_APPEND:
			// strcat( a1, a2 ) concatenate prepend CHAR a1 to STRING a2
			r += "Any charNowStr = toStr(";
			r += PRE +code.leftOperand;
			r += ");\n  "; // NB 2 space tab here
			r += lhs_assignment(code);
			r += "Str(" +SP;
			r += "strcat (" +SP;
			r += "charNowStr.s, " +SP;
			r += PRE +code.rightOperand +".s" +SP;
			r += ")" +SP;
			r += ");";
			break;
		case APPEND:
			// strcat( a1, a2 ) concatenate onto STRING a1 STRING a2
			r += lhs_assignment(code);
			r += "Str(" +SP;
			r += "strcat (" +SP;
			r += PRE +code.leftOperand +".s ," +SP;
			r += PRE +code.rightOperand +".s )" +SP;
			r += ");";
			break;
		default:
			throw new Error("Error, unknown String append code.");
		}
		return r;
	}
	private String createC(int opcode, Code.Const code){
		String r = "";
		switch(opcode){
		// All variables are "Any" structs {type.i, data}
		case(Code.OPCODE_const):
			// Any target = Int(constant);
			r += lhs_assignment(code);
			switch(code.constant.type().toString()){
			case("null"):
				r += "Null()"; // type
				break;
			case("int"):
				r += "Int("; // type
				r += code.constant;
				r += ")";
				break;
			case("real"):
				r += "Real("; // type
				r += code.constant;
				r += ")";
				break;
			case("char"):
				r += "Char("; // type
				r += code.constant;
				r += ")";
				break;
			case("string"):
				r += "Str("; // type
				r += code.constant;
				r += ")";
				break;
			case("bool"):
				r += "Bool("; // type
				r += code.constant;
				r += ")";
				break;
			case("byte"):
				r += "Byte("; // type
				r += code.constant;
				r += ")";
				break;
			default:
				new Error("error, Code.Const, constant.type not recognised.");
			}
			break;
		}
		return r+";";
	}
	private String createC(int opcode, Code.Convert code){
		// This converts a value type from one to another.
		// convert to "any", do nothing (have not seen a use case yet)
		if(code.result.equals(Type.T_ANY))
			return "@ignore";

		String r = "";

		/* kept because it will likely come in useful...
		// ... this changes the type to an 'int' - probably wrong...

		// type tempVar ; // create temp variable of the new type
		// tempVar = target ; // assign the value to it
		// type target ; // re-declare the target as the new type
		// target = tempVar ;
		String r = "";
		r += "int temp";

		r += "temp" +SP;
		r += "=" +SP;
		r += PRE +code.target +";";

		r += "int a99" +SP;
		r += "=" +SP;

		r += code +SP;
		return r + ";";
		*/
		return r;
	}
	private String createC(int opcode, Code.FieldLoad code){
		// FieldLoad extracts the value of a field from the main parameters. ref Code.FieldLoad
		/* case: sample program has method main(System.console console):
		 * this is used to get access to the println statement.
		 * Need to ignore these fieldloads... yet remember the println is needed and insert it where needed.
		 */

		// try this, return tokens to be stored as char in Any struct
		switch(code.field){
		case("out"):
			return"@out";
		case("println"):
			return "@println";
		}
		throw new Error("A FieldLoad case that has not been catered for. code.field : "+code.field);
	}
	/*
	 * __No forAll equivalent in C__
	 * create a count register
	 * label0 for goto returning here
	 * check if count is greater than number of elements
	 * assign this ith value to the target var
	 * increment count
	 *
	 * C throws a wobbly when you attempt a sizeof on an array passed as a parameter.
	 * The standard solution (stackoverflow) is to pass the size of the list at the same time.
	 */
	private String createC(int opcode, Code.ForAll code){
		String r = "";
		r += "int count =" +SP;
		r += code.modifiedOperands.length == 0 ? "0" : PRE+code.sourceOperand +"[0]";
		r += ";\n  "; // includes a tab

		r += Config.PRE_LOOP + code.target + ": ;\n  "; // Top of loop label

		r += "if(count ==" +SP;
		r += code.modifiedOperands.length == 0 ?
			Config.ARRAY_SIZE + ".i )" :
			PRE+code.sourceOperand +"[1])";
		r += "{ goto" + SP;
		r += code.target + ";" +SP;
		r += "}\n  ";

		r += lhs_assignment(code);
		r += PRE + code.sourceOperand +"[count];\n  "; // includes a tab

		r += "count++;";

		return r;
	}
	private String createC(int opcode, Code.Goto code){
		// Any target = operand;
		String r = "";
		r += "goto" +SP;
		r += code.target;
		return r + ";";
	}
	private String createC(int opcode, Code.If code){
		String r = "";
		r += "if (" +SP;
		// need a runtime determination of the data type
		// this will not work for (for example) comparing strings
		r += "dataAsInt( "+PRE + code.leftOperand +" )" +SP;
		switch(code.op){
		// If eq, ne, lt, le, gt, ge, elemof/in, ss and sse
		case EQ:
			r += "==" +SP; break;
		case NEQ:
			r += "!=" +SP; break;
		case LT:
			r += "<" +SP; break;
		case LTEQ:
			r += "<=" +SP; break;
		case GT:
			r += ">" +SP; break;
		case GTEQ:
			r += ">=" +SP; break;
		case ELEMOF:
			r += "@TODO" +SP; break;
		case SUBSET:
			r += "@TODO" +SP; break;
		case SUBSETEQ:
			r += "@TODO" +SP; break;
		default:
			break;
		}
		r += "dataAsInt( " +PRE + code.rightOperand +" )" +SP;
		r += ") {" +SP;
		r += "goto" +SP;
		r += code.target +";" +SP;
		r += "};";
		return r;
	}
	private String createC(int opcode, Code.IfIs code){
		String r = "";
		r += "if(";
		r += PRE +code.operand +".type" +SP;
		r += "==" +SP;
		switch(code.rightOperand.toString()){
		case("int"):
			r += "INT_TYPE"; break;
		case("char"):
			r += "CHAR_TYPE"; break;
		case("real"):
			r += "REAL_TYPE"; break;
		case("bool"):
			r += "BOOL_TYPE"; break;
		case("string"):
			r += "STR_TYPE"; break;
		case("null"):
			r += "NULL_TYPE"; break;
		case("byte"):
			r += "BYTE_TYPE"; break;
		default:
			new Error("error, Code.IfIs, type not recognised.");
		}
		r += "){ goto" +SP;
		r += code.target +";" +SP;
		r += "}";
		return r +";";
	}
	private String createC(int opcode, Code.IndexOf code){
		String r = "";
		r += lhs_assignment(code);
		r += PRE + code.leftOperand + "[";
		r += PRE + code.rightOperand + ".i]";
		return r + ";";
	}
	private String createC(int opcode, Code.IndirectInvoke code){
		// IndirectInvoke calls functions passed as a method parameter.
		// only case so far, uses println which has been stored as a token earlier
		// Returns @indirectinvoke token and use token already stored in the register
		// to determine the method needed.
		// may not work for the general case...

		// there are four variations on this.. fn, fnv, md, mdv
		switch(opcode){
		case(Code.OPCODE_indirectinvokemdv):
			return "@indirectinvoke";
		default:
			throw new Error("ERROR: createC(), IndirectInvoke case not covered yet.");
		}

	}
	private String createC(int opcode, Code.Invoke code){
		String r = "";
		// all four invoke types present
		switch(opcode){
		case(Code.OPCODE_invokefn):
		case(Code.OPCODE_invokemd):
			r += lhs_assignment(code); // TODO
		case(Code.OPCODE_invokefnv):
		case(Code.OPCODE_invokemdv):
			r += idMethod(code);
		}
//		// if there is an extra left bracket, added by lhs_assignment_do, add a right bracket
//		String s = r;
//		int left =  s.length() - s.replace("(", "").length();
//		int right = s.length() - s.replace(")", "").length();
//		if(left == right+1){ r+= " )";}
		return r + ";";
	}

	private String createC(int opcode, Code.Lambda code){
		String r = "";
		r += "Any a2 = Ptr( ";
		r += "&" + code.name.name();
		r += " );";




		return r;
	}

	/*
	 * lengthof
	 * In C length of an array is size of the array divided by the size of the first element
	 *      sizeof(A) / sizeof(A[0])
	 */
	private String createC(int opcode, Code.LengthOf code){
		String r = "";
		r += lhs_assignment(code);
		r += "Int(" +SP;
		r += "sizeof(" +SP;
		r += PRE + code.operand + SP;
		r +=       ")" +SP;
		r += "/" +SP;
		r += "sizeof(" +SP;
		r += PRE + code.operand +"[0]" +SP;
		r +=       ")" +SP;
		r +=    ")";
		return r + ";";
	}
	private String createC(int opcode, Code.Loop code){
		String r = "";
		r += Config.PRE_LOOP + code.target + ": ;";

		return r;
	}
	private String createC(int opcode, Code.LoopEnd code){
		String r = "";
		r += "goto" +SP;
		r += Config.PRE_LOOP + code.label;
		r += ";\n  ";
		r += code.label + ": ;"; // TODO, need this for if statements, but causes gcc warnings in while(true) statements
		return r;
	}
	private String createC(int opcode, Code.NewList code){
		// contents of the list are already defined
		// newlist %8 = (%2, %3, %4, %5, %6, %7) : [int]
		String r = "";
		if(register.containsKey(code.target))
			new Error("error createC(int, Code.NewList), creating a new list using an existing variable name.");
		register.put(code.target, PRE+ code.target);
		r += "Any" +SP;
		r += PRE + code.target +"[]" +SP;
		r += "=" +SP;
		r += "{";
		boolean first = true;
		for(int i=0; i < code.operands.length; i++){
			if( !first) r += "," +SP;
			r += PRE + code.operands[i];
			first = false;
		}
		r += "}";
		return r +";";
	}
	private String createC(int opcode, Code.NewRecord code){
		String r = "";
		return r;
	}
	private String createC(int opcode, Code.NewTuple code){
		String r = "";
		r += lhs_assignment(code);
		switch(code.operands.length){
		case(2):
			r += "Tuple"; break;
		case(3):
			r += "Tuple3"; break;
		default:
			new Error("error, Code.NewTuple, only coded for 2 and 3 element tuples.");
		}
		r += "(" +SP;
		int i = 0;
		boolean first = true;
		while( i < code.operands.length){
			r += first ? "" : ", ";
			r += PRE +code.operands[i++];
			first = false;
		}
		r += ")";
		return r +";";
	}
	private String createC(int opcode, Code.Nop code){
		// A no-operation bytecode, just ignore.
		String r = "@ignore";
		return r;
	}
	private String createC(int opcode, Code.Return code){
		// if return type is void, do nothing
		if(code.type == Type.Void.T_VOID){
			return ""; }
		String r = "";
		r += "return" +SP;
		r += PRE +code.operand;
		switch(code.type.toString()){
		case("Any"):
			 break;
		case("int"):
			 r += ".i"; break;
		case("real"):
			 r += ".r"; break;
		case("string"):
			 r += ".s"; break;
		case("bool"):
			 r += ".b"; break;
		default:
			new Error("Return operation code not captured.");
		}
		return r + ";";
	}
	private String createC(int opcode, Code.TupleLoad code){
		String r ="";
		r += lhs_assignment(code);
		r += "Int(" +SP;
		r += "((Any**)" +PRE +code.operand +".ptr)";
		r += "[" + code.index +"]";
		r += "->i";  // will not cope with other types ie: char, real, etc.
		r += ")"; // end Int()
		return r + ";";
	}
	private String createC(int opCode,	Code.UnArithOp code){
		String r = "";
		r += lhs_assignment(code);
		r += "neg("+PRE+code.operand+")";
		return r+";";
	}

	//=============================================
	// HELPERS
	//=======================================>>
	/**
	 * Creates a csv parameter list. Empty string if there are no parameters.
	 * @param AbstractNaryAssignable<Type.FunctionOrMethod> code
	 * @return CSV String that plugs in as a methods parameter list.
	 */
	private String parameters(AbstractNaryAssignable<Type.FunctionOrMethod> code){
		String result = "";

		// native parameters use int, char, pointer, etc. Not type Any.
		// translate to type Any and call the correct value.
		// arraylist is empty if n/a
		ArrayList<Type> parameters = c_declarations.getNativeParameters(((Code.Invoke)code).name.name());
		Iterator<Type> itr = parameters.iterator();

		boolean first = true;
		for(int i=0; i<code.operands.length; i++){
			result += first ? "" : ", ";
			first = false;
			// invoke "println" can refer to (System.Console) =>"out" in the first operand.
			// if so, skip it as we do not need it in the C code
			if(((Code.Invoke)code).name.name().equals("println")
					&& register.get(code.operands[i]) != null
					&& register.get(code.operands[i]).equals("@out"))
				continue;
			result += PRE +code.operands[i];
			// add to Any type to get the correct paramater for the native method
			if(itr.hasNext()){
				String type = itr.next().toString().trim();
				switch(type){
				case("int"):
					result += ".i"; break;
				case("char"):
					result += ".c"; break;
				case("bool"):
					result += ".b"; break;
				case("real"):
					result += ".r"; break;
				case("string"):
					result += ".s"; break;
				default:
					if(type.matches("method.*")){ // lambda address
						result += ""; break; // just pass through the Any
					}
					String sr, si, sc, sb;
					sr = Pattern.quote("[real]");
					si = Pattern.quote("[int]");
					sc = Pattern.quote("[char]");
					sb = Pattern.quote("[bool]");
					if(		type.matches(sr) ||
							type.matches(si) ||
							type.matches(sc) ||
							type.matches(sb)){
						result += ""; break;
					}
					throw new Error("Error: parameters(Code), parameter type not catered for.");
				}
			}
		}

		return result;
	}

	// TODO make this a target method generating... [Any] a5 =
	private String lhs_assignment(Code.AbstractAssignable code){
		// is this an array - yes then "a6[] =" else "a6 ="
		boolean invokingMethod = false;
		String m = code.toString();
		if(m.contains("method")){ invokingMethod = true; }
		boolean assigningArray = false;
		String r = code.assignedType().toString();
		if(r.contains("[int]") || r.contains("[real]")){ assigningArray = true; }

		return lhs_assignment_do(code.target, invokingMethod, assigningArray);
	}
	private String lhs_assignment(Code.ForAll code){
		return lhs_assignment_do(code.indexOperand, false, false);
	}
	private String lhs_assignment_do(int c, boolean invokingMethod, boolean assigningArray){
		String r = "";
		if( !register.containsKey(c)){
			r += "Any" +SP;
			r += assigningArray ? "*" : "";
			register.put(c, (invokingMethod && assigningArray ? "" : "")+PRE+ c); // TODO tidy?
		}
		r += PRE + c;
//		r +=  invokingMethod && assigningArray ? "[]" : "";
		r += SP+ "=" +SP;
//		r +=  invokingMethod && assigningArray ? "Ptr( " : "";
		return r;
	}

	/*
	 * Identifies special cases; Library methods, Native methods
	 */
	private String idMethod(Code.Invoke whileyMethod){
		String err = "error, Code.Invoke, idMethod() ";
		String r = "";


		switch(whileyMethod.name.module().toString()){
		case("whiley/lang/Any"):
			switch(whileyMethod.name.name()){
			case("toString"):
				r += "toStr" +SP;
				r += "( ";
//				r += "( &";
				r += parameters(whileyMethod) +SP;
				r += ")";
				return r;
			default:
				new Error(err +"method in Whiley \"Any\" library not recognised.");
			}
		case("whiley/lang/Math"):
			switch(whileyMethod.name.name()){
			case("floor"):
				r += "Int(" +SP;
				r += "floor(" +SP;
				r += parameters(whileyMethod) +".r" +SP;
				r += "));";
				return r;
			default:
				new Error(err +"method in Whiley \"Math\" library not recognised.");
			}
		// not a library function or method
		default:
			// assuming a declared native method, returning a C primitive, wrap it in a Any constructor
			boolean constructor = false;
			String returnType = whileyMethod.assignedType().toString();
			if		(returnType.equals("int")){    constructor = true; r += "Int("; }
			else if	(returnType.equals("bool")){   constructor = true; r += "Bool("; }
			else if	(returnType.equals("string")){ /*no constructor needed*/ }
			else if	(returnType.equals("[real]")){ /*no constructor needed*/ }
			else if	(!returnType.equals("void")){
				new Error (err + "invoke bytecode, return type not yet catered for."); }
			r += whileyMethod.name.name() +SP;
			r += "(" +SP;
			r += parameters(whileyMethod) +SP;
			r += ")";
			r += constructor ? ")" : "";
		}
		return r;
	}

	//========================================================================
	// Token Class
	//========================================================================
	public static class Token extends Statements{

		private static Token tokenSingleton;

		private Token(){}

		public static Token getInstance(){
			if(tokenSingleton == null){
				// double checked locking
				synchronized(Token.class){
					if(tokenSingleton == null){
						tokenSingleton = new Token();
					}
				}
			}
			return tokenSingleton;
		}

		public Token create(String token, Code code, HashMap<Integer, String> register){
			result = switchToGenerate(token, code, register);
			return tokenSingleton;
		}

		/////////////////// OVERLOADED TOKENS //////////////////////////////
		private String switchToGenerate(String token, Code code, HashMap<Integer, String> register){
			switch(token){
			case("@ignore"):
				// compiler instruction, ignore this token
				return "";
			case("@indirectinvoke"):
				// is invoking an earlier declared method.
				// only case so far is println
				return invokeEarlierMethod(token, code, register);

			case("@println"):
				if(code instanceof AbstractSplitNaryAssignable<?> &&
						((AbstractSplitNaryAssignable<?>)code).operands.length > 0)
					return println(code);
				return "";

			case("@out"):
				// result of Whiley getting the System.Console package.
				// <stdio> is included automatically in the compiler header file, so ignore.
				return "";
			}
			throw new Error("Calling a Token that has no corrosponding Statement.");
		}


		private String invokeEarlierMethod(String token, Code code, HashMap<Integer, String> register){
			// a recursive call back to switchToGenerate(), with called token and the existing code.
			int key = ((AbstractSplitNaryAssignable<?>)code).operand;
			return switchToGenerate(register.get(key), code, register);
		}

		/////////////////// Printing Specific Token Code ///////////////////////////////////
		private String println(Code code){
			String r = "println (" +SP;
			r += PRE +((AbstractSplitNaryAssignable<?>)code).operands[0] +SP;
			r += ");";
			return r;
		}
	}
}
