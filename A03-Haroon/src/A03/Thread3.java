package A03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Thread3 implements Runnable {

	BST Tree = new BST();
	String Fname;
	VocabExist[] VCExist = new VocabExist[100];

	public Thread3(BST BStree, String FileName, VocabExist[] existingWords) {
		Tree = BStree;
		Fname = FileName;
		VCExist = existingWords;
	}

	public void run() {

ArrayList<String> list2 = new ArrayList<String>();
Scanner s = null;
		try {
			s = new Scanner(new File(Fname));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (s.hasNext()) {
			list2.add(s.next());
		}
		
		System.out.println("Input2.txt");
		for(int i=0;i<list2.size();i++) {
			System.out.println(list2.get(i));
		}
		//System.out.println("CHECK");
		
		for(int i=0;i<list2.size();i++) {
			
			for(int j2=0;VCExist[j2].Name!=null;j2++) {
				
				if(VCExist[j2].Name.equals(list2.get(i))) {
					VCExist[j2].Counter++;
					
				}
				
				
			}
		}
		
		
		
	}
}
