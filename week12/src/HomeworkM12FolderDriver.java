import java.util.List;
import java.util.Stack;

public class HomeworkM12FolderDriver {

    public static void main(String[] args) {
        Folder folder1 = new Folder("Folder1");
        Folder folder2 = new Folder("Folder2");
        Folder folder3 = new Folder("Folder3");
        Folder folder4 = new Folder("Folder4");
        Folder folder1a = new Folder("Folder1a");
        Folder folder1b = new Folder("Folder1b");
        Folder folder2a = new Folder("Folder2a");
        Folder folder2b = new Folder("Folder2b");
        Folder folder2c = new Folder("Folder2c");
        Folder folder4a = new Folder("Folder4a");
        Folder folder4b = new Folder("Folder4b");
        folder1.addFolder(folder1a);
        folder1.addFile(new File("File1-1"));
        folder1.addFile(new File("File1-2"));
        folder1.addFolder(folder1b);
        folder2.addFolder(folder2a);
        folder2.addFolder(folder2b);
        folder2.addFolder(folder2c);
        folder3.addFile(new File("File3-1"));
        folder4.addFolder(folder4a);
        folder4.addFile(new File("File4-1"));
        folder4.addFile(new File("File4-2"));
        folder4.addFolder(folder4b);

        folder1a.addFile(new File("File1a-1"));
        folder1a.addFile(new File("File1a-2"));
        folder1b.addFile(new File("File1b-1"));
        folder2a.addFile(new File("File2a-1"));
        folder2a.addFile(new File("File2a-2"));
        folder2a.addFile(new File("File2a-3"));
        folder2c.addFile(new File("File2c-1"));
        folder4b.addFile(new File("File4b-1"));
        folder4b.addFile(new File("File4b-2"));
        folder4b.addFile(new File("File4b-3"));

        Folder topFolder = new Folder("TopFolder");
        topFolder.addFolder(folder1);
        topFolder.addFolder(folder2);
        topFolder.addFolder(folder3);
        topFolder.addFolder(folder4);

//        printFolderContentsRecursive(topFolder);
        DriverUtil.printDashes();
        DriverUtil.printDashes();
        DriverUtil.printDashes();
        DriverUtil.printDashes();
        printFolderContentsWithStack(topFolder);

    }

    public static void printFolderContentsRecursive(Folder topFolder) {
        printFolderContentsHelper(topFolder, 0);
    }

    private static void printFolderContentsHelper(Folder topFolder, int indentationIndex) {
        for (int i = 0; i < indentationIndex; i++) {
            System.out.print("   ");
        }
        System.out.println(topFolder);
        if (!topFolder.getFileList().isEmpty()) {
            for (int i = 0; i < indentationIndex + 1; i++) {
                System.out.print("   ");
            }
            System.out.println(topFolder.getFileList()); // small part solving now- print the files in the current folder
        }

        List<Folder> subfolderList = topFolder.getFolderList();
        for (Folder subfolder : subfolderList) {
            printFolderContentsHelper(subfolder, indentationIndex + 1); // recursive call
        }


        // implicit base case- happens when a folder has no more subfolders- the recursion will end

    }

    /**
     * Print folder structure using a stack
     * @param topFolder root folder
     */
    public static void printFolderContentsWithStack(Folder topFolder) {
        Stack<Folder> folderStack = new Stack<Folder>();
        Stack<Integer> levelStack = new Stack<Integer>();
        folderStack.push(topFolder);
        levelStack.push(0);
        while (!folderStack.isEmpty()) {
            Folder currentFolder = folderStack.pop();
            Integer level = levelStack.pop();

            for (int i = 0; i < level; i++) {
                System.out.print("   ");
            }

            System.out.println(currentFolder); // print current folder name

            List<File> fileList = currentFolder.getFileList();

            if (fileList.size() > 0) {
                for (int i = 0; i < level + 1; i++) {
                    System.out.print("   ");
                }
                System.out.println(fileList); // print file names;
            }

            List<Folder> subfolderList = currentFolder.getFolderList();

            if (subfolderList.size() > 0) {
                Stack<Folder> tempStack = new Stack<>();
                for (Folder subfolder : subfolderList) {
                    tempStack.push(subfolder);
                }
                while(!tempStack.empty()) {
                    folderStack.push(tempStack.pop());
                    levelStack.push(level + 1);
                }
            }
        }
    }


}
