import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;


public class CharCounter implements ICharCounter {
		
	//Hash map stores char frequency (Char, Val)
	private static HashMap<Integer,Integer> freq = new HashMap<>();	
	private ArrayList<String> freq_collection = new ArrayList<>();

	public CharCounter(){
	}
	
	public ArrayList<String> getFreqCollection(){
		return freq_collection;
	}
	
	public HashMap<Integer,Integer> getFreqMap(){
		return freq;
	}
	
	@Override
	public int getCount(int ch) {
		return freq.get(ch);
	}

	@Override
	public int countAll(InputStream stream) throws IOException {
		// TODO Auto-generated method stub	
		try{
		int ch;
		ch = stream.read();		
		while(ch != -1){
			//if first occurance of character, create a new entry.
			if(freq.get(ch) == null){
				freq.put(ch, 1);
			}
			else{
				//if char already exists, increment count.
				int count = freq.get(ch);				
				freq.put(ch, ++count);
			}			
			ch = stream.read();
		}
		}
		catch(IOException e){
			System.out.println("IOException!");
			e.printStackTrace();
		}
		System.out.println("Character weights:");
		for(HashMap.Entry<Integer,Integer> ent : freq.entrySet()){
			System.out.printf("Ch: %d Val: %d;", ent.getKey(), ent.getValue());
			freq_collection.add( Integer.toString(ent.getKey()) + " " + Integer.toString(ent.getValue()));
		}
		return 0;
	}

	@Override
	public void add(int i) {
		// TODO Auto-generated method stub
		int count = freq.get(i);
		freq.put(i, ++count);
	}

	@Override
	public void set(int i, int value) {
		// TODO Auto-generated method stub
		freq.put(i, value);
	}

	@Override
	public void clear() {
		// removes all mappings of chunk - value sets.
		freq.clear();
	}
	
	
	

}
