package wyce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import wyil.lang.Modifier;
import wyil.lang.Type;
import wyil.lang.Type.FunctionOrMethod;
import wyil.lang.WyilFile.*;

public class Methods {

	String SP = " ";
	String PRE = "a";
	private HashMap<String, ArrayList<Type>> nativeMethods;

	public Methods(){
		nativeMethods = new HashMap<String, ArrayList<Type>>();
	}

	/**
	 * Generate a method declaration
	 * @param Declaration
	 * @return String
	 */
	public String createDeclaration(Declaration declaration){
		String r = "";
		if(declaration instanceof FunctionOrMethodDeclaration){
			FunctionOrMethodDeclaration _dec = (FunctionOrMethodDeclaration) declaration;
			if(_dec.hasModifier(Modifier.NATIVE) && _dec.type().ret() == Type.T_VOID){
				// insert the native method name and a csv string of parameter types into HashMap nativeMethods.
				// do not print out method signature
				nativeMethods.put(_dec.name(), _dec.type().params());
			}else{
				r = createDeclaration(_dec.name(), _dec.type());
			}
		}
		return r;
	}

	private String createDeclaration(String name, FunctionOrMethod declaration){
		String r = "";
		// returnType fName ( param1, param2 ) ;
		r += name.equals("main") ? "int" +SP: "Any" +SP; //dec.ret() +SP
		r += name +SP; // type
		r += "(" +SP;
		if(!name.equals("main")){
			Iterator<Type> itr = declaration.params().iterator();
			boolean first = true;
			while(itr.hasNext()){
				if(!first) r += "," +SP;
				Type type = itr.next();
				r += "Any";
				// TODO is this a list? add[] --perhaps add an array size element? or do this in Whiley instead as SOP.
				if(type instanceof Type.List) r += "[]"; //, Any";
				r += SP;
				first = false;
			}
		}
		r += ")";
		return r + ";";
	}

	/**
	 * Returns empty ArrayList if methodName is not a native method.
	 * @param methodName
	 * @return ArrayList of parameter types
	 */
	public ArrayList<Type> getNativeParameters(String methodName){
		ArrayList<Type> result = nativeMethods.get(methodName);
		return result != null ? result : new ArrayList<Type>();
	}
}

