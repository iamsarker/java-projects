import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class HasMap {
	public static void main(String args[]){
		Map<String, String> capitalList = new HashMap<String, String>();
		Scanner scanner = new Scanner(System.in);
		
		String country, capital;
		int a = scanner.nextInt();
		while( a>0 ){
			country = scanner.next();
			capital = scanner.next();
			capitalList.put(country, capital);
			//System.out.println(capitalList.get(country));
			a--;
		}
		
		System.out.println(":::All Country List:::");
		for(String cName : capitalList.keySet()){
			System.out.println("Country: " + cName);
		}
		
		System.out.println("--------------------------\n:::All Capital List:::");
		for(String capName : capitalList.values()){
			System.out.println("Capital: " + capName);
		}
		
		System.out.println("--------------------------\n:::With Iterator List:::");
		Iterator itList = (Iterator) capitalList.entrySet().iterator();
		while(itList.hasNext()){
			Map.Entry entries = (Map.Entry) itList.next();
			System.out.println(entries.getKey() +" : "+ entries.getValue());
		}
	}
	
}
