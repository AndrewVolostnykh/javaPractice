package patterns;

import java.io.*;
// we have nice example in java io
public class DecoratorMain {
	public static void main(String[] args) {
		FileStream stream = new FileStream();
		stream.read(); // but here i wanna read not "read file" but "read file by string
		System.out.println("+++++++++++++++++++++");
		var strinReader = new FileStrinReader(stream); // nice! 
	}
}

interface FileStream {
	void read(); // only for demonstration
}

class MyFileStreamReader implements FileStream {
	@Override
	public void read(){
		System.out.println("read file");
	}
	
}

abstract class FileDecorator implements FileStream {// here realisation of decorator abstract
	FileStream decorator;
	
	public FileDecorator(FileStream decorator){
		this.decorator = decorator;
	}
	
	abstract void read();
}

class FileStringReader extends FileDecorator { // using of Decorator	
	public FileStringReader(FileDecorator decorator){
		super(decorator);
	}
	
	@Override
	public void read(){
		decorator.read();
		System.out.print("by string");
	}
}