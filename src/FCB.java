package 文件模拟程序;

public class FCB {
	private String fileName;
	private String fileType;
	int start;
	int length;

	public FCB(String fileType, String fileName) {
		// TODO Auto-generated constructor stub
		this.fileType = fileType;
		this.fileName = fileName;

	}

	public void showFCB() {
		try {
			System.out.printf("File Name: %-5s " + "File Type: %-5s" + "start: %-2d" + "length: %-2d%n", fileName,
					fileType, start, length);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No such file!");
		}

	}

}
