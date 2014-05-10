package wyce;

import java.io.IOException;

import wyil.io.WyilFileReader;
import wyil.lang.WyilFile;

public class Wyce {

	public static void main(String[] args){
		String filename = Config.FILE3;
		if(args.length > 0)
			filename = args[0];

		WyilFile wyilFile = null;
		try {
			WyilFileReader handle = new WyilFileReader(filename);
			wyilFile = handle.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		new PrettyPrinter().print(wyilFile);
	}

}
