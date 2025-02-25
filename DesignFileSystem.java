import java.util.ArrayList;
import java.util.List;

interface FileSystem {
    String getName();
    int getSize();
    void delete();
    void display();

}

class File implements FileSystem {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void display() {
        System.out.println("File: " + name + ", Size: " + size);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void delete() {
        System.out.println("Deleting file: " + name);
    }
}

class Folder implements FileSystem {
    private String name;

    private List<FileSystem> files = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (FileSystem file: files) {
            totalSize += file.getSize();
        }
        return totalSize;
    }

    @Override
    public void display() {
        System.out.println("Folder: " + name + ", Size: " + getSize());
        for (FileSystem file: files) {
            file.display();
        }
    }

    @Override
    public void delete() {
        for (FileSystem file: files) {
            file.delete();
        }
        System.out.println("Deleting folder: " + name);
    }

    void addFile(FileSystem file) {
        files.add(file);
    }

}
public class DesignFileSystem {
    public static void main(String[] args) {
        FileSystem file1 = new File("file1", 10);
        FileSystem file2 = new File("file2", 15);
        FileSystem file3 = new File("file3", 20);
        Folder folder1 = new Folder("folder1");
        folder1.addFile(file1);
        folder1.addFile(file2);
        folder1.addFile(file3);
        Folder folder2 = new Folder("folder2");
        FileSystem file4 = new File("file4", 30);
        FileSystem file5 = new File("file5", 20);
        FileSystem file6 = new File("file6", 90);
        folder2.addFile(file4);
        folder2.addFile(file5);
        folder2.addFile(file6);
        Folder mainFolder = new Folder("mainFolder");
        mainFolder.addFile(folder1);
        mainFolder.addFile(folder2);
        mainFolder.display();
    }

}
