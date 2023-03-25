package project1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Test
{
	Scanner input = new Scanner(System.in);
	BinaryTree tree = new BinaryTree();
	FileStuff file;

	public void run()
	{
		String line = " ";

		while(!line.equals("N"))
		{
			System.out.print("Do you have another animal to identify? (Y/N)> ");
			line = input.nextLine().toUpperCase();
			if(line.equals("Y"))
			{
				executeCommand();
			}
			else if(line.equals("N"))
			{
				int arraySize = tree.depthFirst(tree.getRoot()).size();
				int arraySizeAdd = tree.depthFirstAdd(tree.getRoot()).size();

				for(int i = 0; i < arraySize; ++i)
				{
					tree.depthFirst(tree.getRoot()).get(i).setValue(i + 1);
				}
				String[] listToFile = new String[arraySize];
				String[] regList = new String[arraySize];
				String[] listToFileAdd = new String[arraySizeAdd];
				String[] finalList = new String[arraySizeAdd];

				for(int i = 0; i < arraySize;++i)
				{
					listToFile[i] = tree.depthFirst(tree.getRoot()).get(i).getCharic()+"/"+tree.depthFirst(tree.getRoot()).get(i).getValue() +"/"+tree.depthFirst(tree.getRoot()).get(i).getRoot();
					regList[i] = tree.depthFirst(tree.getRoot()).get(i).getCharic();
				}

				for(int i = 0; i < arraySize;++i)
				{
					listToFileAdd[i] = tree.depthFirstAdd(tree.getRoot()).get(i).getCharic();
				}

				for(int i = 0; i < arraySizeAdd; ++i)
				{
					for(int a = 0; a < arraySize; ++a)
					{
						if(listToFileAdd[i].equals(regList[a]))
						{
							finalList[i] = listToFile[a];
						}
					}
				}


				file = new FileStuff(finalList);
				file.save();
			}
			else
			{
				System.out.println("Incorrect input, please try again");
			}
		}
	}

	public void executeCommand()
	{
		String command, newAnimal, newCharic;
		boolean done = false;

		while(!done)
		{
			System.out.print("Is this animal " + tree.getCurrentLocation() + "?(Y/N)> ");
			command = input.nextLine().toUpperCase();
			if(command.equals("Y"))
			{
				if(tree.checkRight() == false)
				{
					System.out.println("Good");
					tree.returnToRoot();
					done = true;
				}
				else
				{
					tree.moveDownRight();
				}

			}
			else if(command.equals("N"))
			{
				if(tree.checkLeft() == false)
				{
					System.out.println("I don't know any " + tree.getPastInfo() + " animals that aren't a " + tree.getCurrentLocation());
					System.out.print("What is the new animal?> ");
					newAnimal = input.nextLine();

					Node newLeafNode = new Node(newAnimal, -1);

					System.out.print("What charactersitic does a " + newLeafNode.getCharic() + " have that a " + tree.getCurrentLocation() + " does not?> ");
					newCharic = input.nextLine();

					Node newStemNode = new Node(newCharic, -1);

					tree.newLeaf(tree.getCurrent(), newLeafNode, newStemNode);
					tree.returnToRoot();
					done = true;
				}
				else
				{
					tree.moveDownLeft();
				}
			}
		}

	}

	public void hardCode()
	{

		FileReader tempFile = null;
		boolean exists = false;
		ArrayList<String> checkList = new ArrayList<>();
		try
		{
			tempFile = new FileReader("C:\\Programs\\S2_college\\bstfile.txt");
			Scanner inFile = new Scanner(tempFile);
			while (inFile.hasNext())
			{
				String value = inFile.nextLine();
				checkList.add(value);
				exists = true;
			}
			inFile.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found.");
		}

		if(exists == false)
		{
			Node n = new Node("aqautic", 0);
			tree.insert(0, "aquatic");
			tree.SetRoot(n);
			tree.insertLeft("Bear");
			tree.insertRight("Whale");
			run();
		}
		else
		{
			int position = 0;
			ArrayList<ArrayList> doubleList = new ArrayList<>();
			try
			{
				tempFile = new FileReader("C:\\Programs\\S2_college\\bstfile.txt");
				Scanner inFile = new Scanner(tempFile);
				while (inFile.hasNext())
				{
					String value = inFile.nextLine();
					ArrayList<String> list = new ArrayList<>();
					int placeHolder = 0;

					while(placeHolder != -1)
					{

						placeHolder = value.indexOf("/");

						if(placeHolder != -1)
						{
							list.add(value.substring(0,placeHolder));
							value = value.substring(placeHolder + 1, value.length());
						}
						else
						{
							list.add(value.substring(0, value.length()));
						}
					}
					doubleList.add(list);

				}
			}
			catch(FileNotFoundException e)
			{
				System.out.println("File not found.");
			}

			for(int i = 0; i < doubleList.size(); ++i)
			{
				String charic = (String) doubleList.get(i).get(0);
				int value = (Integer)Integer.parseInt((String)doubleList.get(i).get(1));
				tree.insert(value, charic);
				if(doubleList.get(i).get(2).equals("true"))
				{

					position = i;
					String v = (String) doubleList.get(i).get(0);
					int d = (Integer)Integer.parseInt((String)doubleList.get(i).get(1));
					Node n = new Node(v,d);
					tree.SetRoot(n);
				}
			}

			run();
		}
	}


}
