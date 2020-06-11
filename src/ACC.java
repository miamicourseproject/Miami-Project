import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class ACC {
	public static void main(String[] args) {
		Hashtable<String, ArrayList<String>> hash = new Hashtable<String, ArrayList<String>>();
		String key = "";
		int count = 0;
		ArrayList<String> value = new ArrayList<String>();
		File inputFile = new File("New-Text-Document.txt");
		try {
			Scanner in = new Scanner(inputFile);
			while(in.hasNextLine()) {
				String line = in.nextLine();
				if(line.isEmpty())
					continue;
				else if(isUpperCase(line.substring(0, 7))) {
					if(!key.equals("")) {
					ArrayList<String> temp = new ArrayList<String>();
					for(String val : value)
						temp.add(val);
					hash.put(key, temp);
					
					}
					key = line.substring(0, 7);
					count++;
					value.clear();
				}
				else if(line.substring(0, 12).equals("Prerequisite")) {
					String[] vals = line.substring(14).split("and");
					for(String v : vals) {
					value.add(v);
					}
				}
			}
			hash.entrySet().forEach( entry -> {
			    System.out.println( entry.getKey() + "->" + entry.getValue() );
			});
			System.out.println(count);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static boolean isUpperCase(String str) {
		return str.equals(str.toUpperCase());
	}
}
