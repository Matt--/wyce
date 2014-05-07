package archive;

import wyil.lang.Code;

public class Const {

	String cText;
	String SP = " ";

	public Const(Code.Const code){
		cText = createText(code);
	}

	private String createText(Code.Const code){
		// type reciever = value ;
		String result ="";
		result += code.constant.type() + SP; // type
		//result += code.

		return result;
	}


	public String toString(){
		return cText;
	}

	/**
	 * Simple print function to terminal
	 * if text == null, no error, does not print.
	 */
//	private static void print(String text){
//		String INDENT = "  ";
//		if(text != null)
//			System.out.println(INDENT + text);
//	}

	public static void main(){
		//Const c = new Const(new Code.Const(2, null));
	}
}
