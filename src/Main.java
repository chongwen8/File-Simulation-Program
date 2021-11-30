package 文件模拟程序;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static  String fileNameInput() {
		System.out.println("Please input your file name");
		Scanner file_name = new Scanner(System.in);
		String fileName = file_name.nextLine();
		return fileName;
	}
	public static void main(String[] args) {
		File_Operator file = new File_Operator();
		System.out.println("Welcome to File simulator");
		System.out.println("Quit:q Create File: c Open File: o Delete File: d Close File: g");
		System.out.println("Read File: r Write File: w Look up disk: l Show FCB: s");
		FCB fileInode = null;
		while (true) {
			System.out.println("Please input your instruction");
			Scanner instruction = new Scanner(System.in);
			String instructionString = instruction.nextLine();
			if (instructionString.equals("q")) {
				System.out.println("Quit successfully!");
				break;
			}
			switch (instructionString) {
			case "c":
				file.fileCreate(Main.fileNameInput());
				System.out.println("Create successfully!");
				break;
			case "o":
				fileInode = file.fileOpen(Main.fileNameInput());
				if (fileInode != null) {
					System.out.println("Open successfully!");
				}
				else {
					System.out.println("Open unsuccessfully!");
				}
				break;
			case "d":
				System.out.println("Are u sure to delete a file?  [y/n]");
				Scanner sureInstruction = new Scanner(System.in);
				String sureInstructionString = instruction.nextLine();
				if (sureInstructionString.equals("y")) {
					file.fileDelete(Main.fileNameInput());
				}
				else {
					System.out.println("Delete unsuccessfully!");
				}
				break;
			case "r":
				if (fileInode != null) {
					file.fileRead(fileInode);
					fileInode = null;
					System.out.println("Read successfully!");
				}
				else {
					System.out.println("Please open file first");
				}
				break;
			case "w":
				if (fileInode != null) {
					file.fileWrite(fileInode);
					fileInode = null;
					System.out.println("Write successfully!");
				}
				else {
					System.out.println("Please open file first");
				}
				break;
			case "l":
				file.diskShow();
				System.out.println("Look up successfully!");
				break;
			case "s":
				try {
					Inode.fileInode.get(Main.fileNameInput()).showFCB();
					System.out.println("Show successfully!");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("No such file!");
				}
				break;
			case "g":
				fileInode = null;
				System.out.println("Close successfully!");
				break;
			default:
				System.out.println("Invalid instruction!");
				break;
			}
		}
		
 
	}
	
}
