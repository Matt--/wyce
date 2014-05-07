package wyce;

import java.util.ArrayList;
import java.util.Iterator;

import wyil.lang.Type;
import wyil.lang.Type.FunctionOrMethod;
import wyil.lang.WyilFile.*;

public class C_Declarations {

	String c_code;
	String SP = " ";
	String PRE = "a";

	public C_Declarations(Declaration dec){
		this.c_code = switchToGenerate(dec);
	}
	public String toString(){
		return c_code;
	}

	private String switchToGenerate(Declaration dec){
		String r = "";
		if(dec instanceof FunctionOrMethodDeclaration)
			r = createD(((FunctionOrMethodDeclaration) dec).name(), ((FunctionOrMethodDeclaration) dec).type());
		//		else if(dec instanceof WyilFile.ConstantDeclaration)
		//			r = createD((ConstantDeclaration) dec);
		//		else if(dec instanceof WyilFile.NamedDeclaration)
		//			r = createD((NamedDeclaration) dec);



		return r;
	}

	/////////////////// OVERLOADED createD() ///////////////////////////
	public String createD(String name, FunctionOrMethod dec){
		String r = "";
		// returnType fName ( param1, param2 ) ;
		r += name.equals("main") ? "int" +SP: "Any" +SP; //dec.ret() +SP
		r += name +SP; // type
		r += "(" +SP;
		if(!name.equals("main")){
			Iterator<Type> itr = dec.params().iterator();
			boolean first = true;
			while(itr.hasNext()){
				if(!first) r += "," +SP;
				Type type = itr.next();
				r += "Any";
				// is this a list?
				if(type instanceof Type.List) r += "[]";
				r += SP;
				first = false;
			}
		}
		r += ")";
		return r + ";";
	}
}

