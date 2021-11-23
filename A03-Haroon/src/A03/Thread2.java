
package A03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.stream.Collectors;

public class Thread2 implements Runnable {

	BST Tree = new BST();
	String[] Fnames;
	VocabExist[] VCExist = new VocabExist[100];

	public Thread2(BST BStree, String[] FileName, VocabExist[] existingWords) {
		Tree = BStree;
		Fnames = FileName;
		VCExist = existingWords;
	}

	public void run() {
		ArrayList<String> list = new ArrayList<String>();
		Scanner s = null;
		try {
			s = new Scanner(new File(Fnames[1]));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (s.hasNext()) {
			list.add(s.next());
		}
		System.out.println("Input1.txt");
	for(int i=0;i<list.size();i++) {
		System.out.println(list.get(i));
	}
		
		
		try {
			s = new Scanner(new File(Fnames[2]));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (s.hasNext()) {
			list.add(s.next());
		}
		s.close();
		
		
		
		

		List<String> newList = list.stream().distinct().collect(Collectors.toList());


		int j=0;
		for(int i=0;i<newList.size();i++) {
			if(Tree.search(newList.get(i))==true) {
				
			
			VCExist[j].Name=newList.get(i);
			j++;
			}
		}
		
		ArrayList<String> list2 = new ArrayList<String>();
		
		try {
			s = new Scanner(new File(Fnames[1]));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (s.hasNext()) {
			list2.add(s.next());
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
