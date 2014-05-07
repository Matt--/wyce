package wyce;

import java.util.HashMap;

import wyil.lang.Code.AbstractNaryAssignable;
import wyil.lang.Code;
import wyil.lang.Code.IfIs;
import wyil.lang.Type;
import wyil.lang.Code.AbstractAssignable;
import wyil.lang.Code.AbstractSplitNaryAssignable;

public class Statements{
	protected String result;
	private HashMap<Integer, String> register;

	public Statements(){}

	/*
	 * Converts a single bytecode to mostly one, sometimes more, lines of C code.
	 */
	public Statements create(Code code, HashMap<Integer, String> register){
		this.register = register;
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
		case(Code.OPCODE_ifis): 				// TODO issue raised, this should be ifin ?
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
		case(Code.OPCODE_lengthof):
			result = createC(Code.OPCODE_lengthof,  (Code.LengthOf) code); return result;
		case(Code.OPCODE_lshr):
			result = createC(Code.OPCODE_lshr,  (Code.BinArithOp) code); return result;
		case(Code.OPCODE_loop):
			result = createC(Code.OPCODE_loop,  (Code.Loop) code); return result;
		case(-1):								// TODO find an opcode for this case
			result = createC(-1,	 (Code.LoopEnd) code); return result;
		case(Code.OPCODE_mul):
			result = createC(Code.OPCODE_mul,	 (Code.BinArithOp) code); return result;
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
		// Any target = operand;
		String r = "";
		r += firstDeclaration(code);
		r += PRE +code.target +SP;
		r += "=" +SP;
//		r += "AnyCopy(";
		r += PRE +code.operand;
//		r += ")";
		return r + ";";
	}
	private String createC(int opcode, Code.BinArithOp code){
		String r = "";
		switch(opcode){
		//TODO  remainder, bitwiseor, bitwisexor, bitwiseand, leftshift, rightshift
		case(Code.OPCODE_add):
			// type target = constant ;
			r += "Any" +SP;
			r += PRE +code.target +SP;
			r += "=" +SP;
			r += "add(" +SP;
			r += PRE +code.leftOperand +SP;
			r += "," +SP;
			r += PRE +code.rightOperand;
			r += ")";
			break;
		case(Code.OPCODE_sub):
			// type target = constant ;
			r += "Any" +SP;
			r += PRE +code.target +SP;
			r += "=" +SP;
			r += "sub(" +SP;
			r += PRE +code.leftOperand +SP;
			r += "," +SP;
			r += PRE +code.rightOperand;
			r += ")";
			break;
		case(Code.OPCODE_mul):
			// type target = constant ;
			r += "Any" +SP;
			r += PRE +code.target +SP;
			r += "=" +SP;
			r += "mul(" +SP;
			r += PRE +code.leftOperand +SP;
			r += "," +SP;
			r += PRE +code.rightOperand;
			r += ")";
			break;
		case(Code.OPCODE_div):
			// type target = constant ;
			r += "Any" +SP;
			r += PRE +code.target +SP;
			r += "=" +SP;
			r += "div_wyce(" +SP;
			r += PRE +code.leftOperand +SP;
			r += "," +SP;
			r += PRE +code.rightOperand;
			r += ")";
			break;
		case(Code.OPCODE_range):
			if(!firstDeclaration(code).isEmpty()) r += "Any[]" +SP;
			r += PRE +code.target +SP;
			r += "= {";
			r += PRE + code.leftOperand;
			r += "," +SP;
			r += PRE +code.rightOperand;
			r += "}";
			break;
		case(Code.OPCODE_bitwiseand):
			// TODO test case 17
			return "@ignore";
			//break;
		case(Code.OPCODE_rshr): // rightshift... I think...
			// TODO test case 17
			return "@ignore";
			//break;
		case(Code.OPCODE_lshr): // leftshift... I think...
			// TODO test case 17
			return "@ignore";
			//break;
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
			r += firstDeclaration(code);
			r += PRE +code.target +SP;
			r += "=" +SP;
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
			r += firstDeclaration(code);
			r += PRE +code.target +SP;
			r += "=" +SP;
			r += "Str(" +SP;
			r += "strcat (" +SP;
			r += "charNowStr.s, " +SP;
			r += PRE +code.rightOperand +".s" +SP;
			r += ")" +SP;
			r += ");";
			break;
		case APPEND:
			// strcat( a1, a2 ) concatenate onto STRING a1 STRING a2
			r += firstDeclaration(code);
			r += PRE +code.target +SP;
			r += "=" +SP;
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
			r += firstDeclaration(code);
			r += PRE +code.target +SP;
			r += "=" +SP;
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
	 */
	private String createC(int opcode, Code.ForAll code){
		String r = "";
		r += "int count =" +SP;
		r += code.modifiedOperands.length == 0 ? "0" : PRE+code.sourceOperand +"[0]";
		r += ";\n  "; // includes a tab
		r += code.target + ": ;\n  "; // label // includes a tab

		// ref: Code.LoopEnd for "labelEnd" label.
		// TODO solution needed for nested loops, labelEnd is not enough.
		r += "if(count ==" +SP;
		r += code.modifiedOperands.length == 0 ?
			"sizeof(" +PRE+code.sourceOperand +")-1 )" :
			PRE+code.sourceOperand +"[1])";
		r += "{ goto labelEnd; }\n  ";

		r += firstDeclaration(code);
		r += PRE + code.indexOperand +SP;
		r += "=" +SP;
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
		r += firstDeclaration(code);
		r += PRE +code.target +SP;
		r += "=" +SP;
//		r += "Int(" + SP;
		r += PRE + code.leftOperand + "[";
		r += PRE + code.rightOperand + ".i]";
//		r += ")";
		return r + ";";
	}
	private String createC(int opcode, Code.IndirectInvoke code){
		// IndirectInvoke calls functions passed as a method parameter.
		// only case so far, uses println which has been stored as a token earlier
		// Returns @indirectinvoke token and use token already stored in the register
		// to determine the method needed.
		// may not work for the general case...

		// there are four variations on this.. fn, fnv, md, mdv TODO
		switch(opcode){
		case(Code.OPCODE_indirectinvokemdv):
			return "@indirectinvoke";
		}

		throw new Error("IndirectInvoke case not covered yet.");
	}
	private String createC(int opcode, Code.Invoke code){
		String r = "";
		// all four invoke types present
		switch(opcode){
		case(Code.OPCODE_invokefn):
		case(Code.OPCODE_invokemd):
			r += firstDeclaration(code);
			r += PRE +code.target +SP;
			r += "=" +SP;
		case(Code.OPCODE_invokefnv):
		case(Code.OPCODE_invokemdv):
			r += idMethod(code);
		}
		return r + ";";
	}
	private String createC(int opcode, Code.LengthOf code){
		String r = "";
		r += firstDeclaration(code);
		r += PRE +code.target +SP;
		r += "=" +SP;
		r += "Int(" +SP;
		r += "sizeof(" +SP;
		r += PRE + code.operand + SP;
		r +=       ")" +SP;
		r +=    ")";
		return r + ";";
	}
	private String createC(int opcode, Code.Loop code){
		String r = "";
		r += code.target + ": ;";

		return r;
	}
	private String createC(int opcode, Code.LoopEnd code){
		String r = "";
		r += "goto" +SP;
		r += code.label;
		r += ";\n  ";
		r += "labelEnd: ;";
		return r;
	}
	private String createC(int opcode, Code.NewList code){
		// contents of the list are already defined
		// newlist %8 = (%2, %3, %4, %5, %6, %7) : [int]
		String r = "";
		if(firstDeclaration(code).isEmpty())
			new Error("error createC(int, Code.NewList), creating a new list using an existing variable name.");
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
		// TODO not implemented
		String r = "";
		return r;
	}
	private String createC(int opcode, Code.NewTuple code){
		String r = "";
		r += firstDeclaration(code);
		r += PRE +code.target +SP;
		r += "=" +SP;
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
		// return ; OR return operand ;
		String r = "";
		r += "return";
		r += opcode==Code.OPCODE_return ? SP +PRE +code.operand : "";
		return r + ";";
	}
	private String createC(int opcode, Code.TupleLoad code){
		String r ="";
		r += firstDeclaration(code);
		r += PRE +code.target +SP;
		r += "=" +SP;
		r += "Int(" +SP;
		r += "((Any**)" +PRE +code.operand +".ptr)";
		r += "[" + code.index +"]";
		r += "->i";  // TODO will not cope with other types ie: char, real, etc.
		r += ")"; // end Int()
		return r + ";";
	}

	//=============================================
	// HELPERS
	//=======================================>>
	/**
	 * Takes array, returns csv parameter list.
	 * @param operands
	 * @return
	 */
	private String parameters(AbstractNaryAssignable<Type.FunctionOrMethod> code){
		String result = "";
		boolean first = true;
		for(int i=0; i<code.operands.length; i++){
			result += first ? "" : ", ";
			// invoke "println" can refer to (System.Console) =>"out" in the first operand.
			// if so, skip it as we do not need it in the C code
			if(((Code.Invoke)code).name.name().equals("println")
					&& register.get(code.operands[i]) != null
					&& register.get(code.operands[i]).equals("@out"))
				continue;
			result += PRE +code.operands[i];
			first = false;
		}

		return result;
	}

	// TODO make this a target method generating... [Any] a5 =
	private String firstDeclaration(Code.AbstractAssignable code){
		return firstDeclarationDo(code.target);
	}
	private String firstDeclaration(Code.ForAll code){
		return firstDeclarationDo(code.indexOperand);
	}
	private String firstDeclarationDo(int c){
		String r = "";
		if(! register.containsKey(c)){
			r += "Any" +SP;
			register.put(c, PRE +c);
		}
		return r;
	}

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
			r += whileyMethod.name.name() +SP;
			r += "(" +SP;
			r += parameters(whileyMethod) +SP;
			r += ")";
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
