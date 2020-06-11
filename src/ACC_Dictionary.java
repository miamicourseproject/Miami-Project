import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class ACC_Dictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<String, ArrayList<String>> dict = new Hashtable<String, ArrayList<String>>();
		String key = "";
		ArrayList<String> value = new ArrayList<String>();
		File file = new File("ACC.txt");
		try {
			Scanner in = new Scanner(file);
			while(in.hasNextLine()) {
				String line = in.nextLine();
				if(line.length() == 7) {
					key = line;
					ArrayList<String> empty = new ArrayList<String>();
					dict.put(key, empty);
				}
				else {
				key = line.substring(0, 7);
				value.clear();
				String val = line.substring(8);
				while(val.length() != 0) {
					if(val.length() <= 7) {
						value.add(val);
						break;
					}
					else {
					value.add(val.substring(0, 7));
					val = val.substring(8);
					}
				}
				ArrayList<String> temp = new ArrayList<String>();
				for(String v : value)
					temp.add(v);
				dict.put(key, temp);
			}
			}
			dict.entrySet().forEach( entry -> {
			    System.out.println( entry.getKey() + "->" + entry.getValue() );
			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
