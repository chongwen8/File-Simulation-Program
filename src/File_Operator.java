package 文件模拟程序;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class File_Operator {
	private String[] disk = new String[50];

	public void fileCreate(String fileName) {
		System.out.println("Please input your file type");
		Scanner file_type = new Scanner(System.in);
		String fileType = file_type.nextLine();
		Inode.fileInode.put(fileName, new FCB(fileType, fileName));

	}

	public FCB fileOpen(String fileName) {
		return Inode.fileInode.get(fileName);
	}

	public void fileWrite(FCB fileInode) {
		System.out.println("Please input your file content");
		Scanner file_content = new Scanner(System.in);
		String fileContent = file_content.nextLine();
		int contentLength = (fileContent.length() < 10) ? 1 : (fileContent.length() / 10) + 1;
		StringBuilder tempString = new StringBuilder(fileContent);
		for (int i = 0; i < disk.length; i++) {
			if (disk[i] == null && disk[i + contentLength - 1] == null) {
				for (int j = 0; j < contentLength; j++) {
					disk[i + j] = getStringFromFilecontent(tempString);
				}
				fileInode.start = i;
				fileInode.length = contentLength;
				break;
			} else if (i == disk.length - 1) {
				System.out.println("No available memory!");
				break;
			}
		}
	}

	public void fileRead(FCB fileInode) {
		String FileContent = "";
		for (int i = fileInode.start; i < (fileInode.start + fileInode.length); i++) {
			FileContent += disk[i];
		}
		System.out.println(FileContent);
		
	}

	public void fileDelete(String fileName) {
		try {
			for (int i = Inode.fileInode.get(fileName).start; i < (Inode.fileInode.get(fileName).start + Inode.fileInode.get(fileName).length); i++) {
				disk[i] = null;
			}
			Inode.fileInode.remove(fileName);
			System.out.println("Delete successfully!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No such file!");
		}
	}

	public void diskShow() {
		for (int i = 0; i < disk.length; i++) {
			System.out.print(i + ": " + disk[i] + " ");
			if (i % 10 == 0 && i != 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	String getStringFromFilecontent(StringBuilder sb) {
		String str = (sb.length() < 10) ? sb.substring(0, sb.length()) : sb.substring(0, 10);
		sb.delete(0, 10);
		return str;
	}

}
