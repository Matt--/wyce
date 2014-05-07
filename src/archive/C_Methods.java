package archive;
//package wyil2C_Compiler;
//
//import java.util.HashMap;
//
//import wyil.lang.Code;
//import wyil.lang.Type;
//import wyil.lang.Code.AbstractSplitNaryAssignable;
//
//public class C_Methods {
//
//	Code code;
//	String token;
//	String c_code;
//	HashMap<Integer, String> register;
//	Statement statement = new Statement();
//	private static String PRE = Config.PREFIX;
//
//	public C_Methods(Code code){
//		this.code = code;
//		this.c_code = statement.generateLine(code);
//	}
//	public C_Methods(Code code, String token, HashMap<Integer, String> register){
//		this.code = code;
//		this.token = token;
//		this.register = register;
//		this.c_code = switchToGenerate(token);
//	}
//	public String toString(){
//		return c_code;
//	}
//
//
//
//	/////////////////// OVERLOADED TOKENS //////////////////////////////
//	private String switchToGenerate(String token){
//		String r = "";
//		switch(token){
//			case("@indirectinvoke"):
//			int key = ((AbstractSplitNaryAssignable<?>)code).operand;
//			switch(register.get(key)){
//				case("@println"):
//				r += "println(";
//				r += PRE +((AbstractSplitNaryAssignable<?>)code).operands[0];
//				r += ");";
//				break;
//			}
//			break;
//		}
//		return r;
//	}
//
//
//
//
//
//}
