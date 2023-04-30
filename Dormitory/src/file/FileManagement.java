package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Dormitory;

public class FileManagement{
	private File file;
	
	
	
	public FileManagement(File file) {
		this.file = file;
	}
	
	
	
	public void write(Dormitory dormitory) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
			objectOutputStream.writeObject(dormitory);
			objectOutputStream.flush();
			
			objectOutputStream.close();
			fileOutputStream.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	public Dormitory read() {
		Dormitory dormitory = new Dormitory();
		if(file.length()!=0) {
			try {
				InputStream inputStream = new FileInputStream(file);
				ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
				
				dormitory = (Dormitory)objectInputStream.readObject();
				
				objectInputStream.close();
				inputStream.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return dormitory;
	}
}
	


