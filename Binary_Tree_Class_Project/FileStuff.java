package project1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileStuff
{
	private String[] data;
	public FileStuff(String[] data) {
		this.data = data;
	}

	public String[] returnData()
	{
//		System.out.println(data.length);
//		for (int i = 0; i < data.length; i++)
//		{
//			System.out.println(data[i]);
//		}
		return data;
	}

	public FileReader returnFile()
	{
		FileReader file = null;
		try
		{
			file = new FileReader("C:\\Programs\\S2_college\\bstfile.txt");
			Scanner inFile = new Scanner(file);
			inFile.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found.");
		}
		return file;
	}

	public boolean isEmpty()
	{
		boolean empty = true;
		try
		{

			FileReader file = new FileReader("C:\\Programs\\S2_college\\bstfile.txt");
			Scanner inFile = new Scanner(file);
			if(!inFile.hasNext())
			{
				empty = false;
			}

			inFile.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found.");
		}
		return empty;
	}

	public int sizeOfFile()
	{
		int a = 0;
		try
		{
			FileReader file = new FileReader("C:\\Programs\\S2_college\\bstfile.txt");
			Scanner inFile = new Scanner(file);

			while(!inFile.hasNext())
			{
				++a;
			}
			inFile.close();

		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found.");
		}
		return a;
	}

	public void load() {
		try {
			FileReader file = new FileReader("C:\\Programs\\S2_college\\bstfile.txt");
			Scanner inFile = new Scanner(file);

			ArrayList<String> tempList = new ArrayList<>();
			while (inFile.hasNext())
			{
				String value = inFile.nextLine();
				tempList.add(value);
			}
			inFile.close();
			data = tempList.toArray(new String[tempList.size()]);
		} catch (FileNotFoundException e) {
			//do whatever you want to happen if the file doesn't exist yet.
			System.out.println("File not found.");
		}
	}

	public void save() {
		Scanner in = new Scanner(System.in);
		try {
			PrintWriter outFile = new PrintWriter("C:\\Programs\\S2_college\\bstfile.txt");

			for (int i = 0; i < data.length; i++) {
				outFile.println(data[i]);
			}
			outFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find that file");
		}
	}

}
