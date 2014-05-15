package wyce;

import java.io.IOException;

import wyil.io.WyilFileReader;
import wyil.lang.WyilFile;

public class Wyce {

	public static void main(String[] args){
		String filename = Config.FILE53;
		boolean tests = false;

		if(args.length > 0){
			tests = Boolean.parseBoolean(args[0]);
			filename = args[1];
		}

		WyilFile wyilFile = null;
		try {
			WyilFileReader handle = new WyilFileReader(filename);
			wyilFile = handle.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		new Compiler(tests).print(wyilFile);
	}

}
