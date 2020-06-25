package patterns;

import java.util.*;

// like a tree object oriented struct
// rules : composite must to have a leafs 
// 			leafs cant have another leafs (childs)
public class CompositeMain {
	public static void main(String[] args){
		
	}
	
}

class File {
	String fileName;
}

class Folder {
	String name;
	Date creatingDate;
	List<Folder> folders = new ArrayList<>(); // Composite is a tree-type struct that store himselfs 
	List<File> files = new ArrayList<>();
	
	public Folder(String name){
		this.name = name;
	}
	
	void addFolder(Folder folder){ // but here also have to be instruments (methods) to work with this "store"
		folders.add(folder);
	}
	
	void removeFolder(Folder folder){
		folders.remove(folder);
	}
	
	List<Folder> getFolders(){
		return this.folders;
	}
	
	void addFile(File file){
		files.add(file);
	}
	
	void removeFile(File file){
		files.remove(file);
	}
	
	List<File> getFiles(){
		return files;
	}
}