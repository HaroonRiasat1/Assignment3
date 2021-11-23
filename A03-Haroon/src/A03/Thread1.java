package A03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Thread1 implements Runnable {

	BST Tree = new BST();
	String Fname;

	public Thread1(BST BStree, String FileName) {
		Tree = BStree;
		Fname = FileName;
	}

	public void run() {

		// Reading from File
		Scanner s = null;
		try {
			s = new Scanner(new File(Fname));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> list = new ArrayList<String>();
		while (s.hasNext()) {
			list.add(s.next());
		}
		s.close();

		// Putting Values into BST
		for (int i = 0; i < list.size(); i++) {
			Tree.insert(list.get(i));
		}

	}
}
