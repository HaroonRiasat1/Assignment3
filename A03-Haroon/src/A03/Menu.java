package A03;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Menu {
	
	public static boolean find(File f, String searchString) {
        boolean result = false;
        Scanner in = null;
        try {
            in = new Scanner(new FileReader(f));
            while(in.hasNextLine() && !result) {
                result = in.nextLine().indexOf(searchString) >= 0;
            }
        }
        catch(IOException e) {
            e.printStackTrace();      
        }
        finally {
            try { in.close() ; } catch(Exception e) { /* ignore */ }  
        }
        return result;
    
}
	
	

	public static void main(String[] args) throws InterruptedException {

		BST BSTree = new BST();
		VocabExist[] ExistingWords = new VocabExist[100];
		

		for (int i = 0; i < 100; i++) {
			ExistingWords[i] = new VocabExist();
		}

		boolean T=false;
		int choice = 0;
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.println();
			System.out.println("1.To Display BST Populated with Vocabulary File");
			System.out.println("2.To Display Vector Files Built");
			System.out.println("3.To Display Words and Frequency");
			System.out.println("4.To do Search Query");
			System.out.println("5.To Exit");

			System.out.println("Enter your option:");
			choice = scan.nextInt();
			scan.nextLine();
			Customexception exp=new Customexception();
			try
			{
			if(choice==1)
			{
				T=true;
			}else if(T!=true)
			{
			exp.populateData();
			}
			}catch (Exception e)
			{
				
			}
			
			
			switch (choice) {
			case 1:
				System.out.println("Processing BST...");

				Runnable T1 = new Thread1(BSTree, args[0]);
				new Thread(T1).start();

				Thread.sleep(1000);
				System.out.println();
				System.out.println();
				System.out.println("BST Inorder:");
				BSTree.Inorder();

				
				break;
			case 2:


				System.out.println("Processing Files...");
				
				Runnable T2 = new Thread2(BSTree, args, ExistingWords);
				new Thread(T2).start();

				Thread.sleep(1000);

				Runnable T3 = new Thread3(BSTree, args[2], ExistingWords);
				new Thread(T3).start();

				Thread.sleep(1000);

			

			
				break;
			case 3:
				System.out.println("Words and Frequency:");
				for (int i = 0; ExistingWords[i].Name != null; i++) {
					if (ExistingWords[i].Counter > 0)
						System.out.println(ExistingWords[i].Name + " " + ExistingWords[i].Counter);
				}
				
				break;
			case 4:
				System.out.println("Enter search Query:");
				String query =scan.nextLine();
				try {
					exp.NullException(query);
				}
				catch (Exception A)
				{
					System.out.println(A);
				}
				
				for(int i=1;i<args.length;i++) {
					File f = new File(args[i]);
			        String search = query;
			        System.out.printf("Result of searching for %s in %s was %b\n", search, f.getName(),find(f, search));
				}
				
				break;
			case 5:
				System.out.println("System Exits.");
				choice=-1;
				break;
			}

		} while (choice != -1);

	}

}
