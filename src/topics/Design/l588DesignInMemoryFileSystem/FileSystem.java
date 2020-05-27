package topics.Design.l588DesignInMemoryFileSystem;
import java.util.*;

public class FileSystem {

    FileNode root;
    public FileSystem() {
        root = new FileNode(false, " ");
    }

    public List<String> ls(String path) {
        FileNode target = getFileNode(path, false);
        if(target.isFile) {
            List<String> res = new ArrayList();
            res.add(target.name);
            return res;
        }
        else {
            List<String> res = new ArrayList<>(target.children.keySet());
            Collections.sort(res);
            return res;   
        }
    }
    
    public void mkdir(String path) {
        FileNode target = getFileNode(path, false);
    }
    
    private FileNode getFileNode(String path, boolean isFile) {
        String[] paths = path.split("/");
        FileNode cur = root;
        // the first entry is empty
        for(int i = 1; i <paths.length; ++i) {
            if(!cur.children.containsKey(paths[i])) {
                if(i == paths.length - 1) {
                    cur.children.put(paths[i], new FileNode(isFile, paths[i]));
                }
                else {
                    cur.children.put(paths[i], new FileNode(false, paths[i]));
                }
            }
            cur = cur.children.get(paths[i]);
        }
        return cur;
    }
    
    public void addContentToFile(String filePath, String content) {
        FileNode target = getFileNode(filePath, true);
        target.sb.append(content);
    }
    
    public String readContentFromFile(String filePath) {
        FileNode target = getFileNode(filePath, true);
        return target.sb.toString();
    }
    
    class FileNode {
        boolean isFile;
        StringBuilder sb;
        Map<String, FileNode> children;
        String name;
        public FileNode(boolean isFile, String name) {
            this.isFile = isFile;
            sb = new StringBuilder();
            children = new HashMap<>();
            this.name = name;

        }
    }
}