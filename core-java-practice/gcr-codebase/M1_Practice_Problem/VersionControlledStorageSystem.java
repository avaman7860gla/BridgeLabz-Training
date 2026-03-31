package M1_Practice_Problem;

import java.util.*;

public class VersionControlledStorageSystem {
    static class Version{
        String version;
        int size;
        int order;

        public Version(String version, int size, int order){
            this.version=version;
            this.size=size;
            this.order=order;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();

        while(n-->0){
            String input=sc.nextLine();
            solve(input);
        }
    }

    static Map<String, List<Version>> storage=new HashMap<>();
    static int c=0;

    public static void solve(String input){
        String[] parts=input.split(" ");
        String operation=parts[0];

        switch (operation){
            case "UPLOAD": {
                String fileName = parts[1];
                String version = parts[2];
                int size = Integer.parseInt(parts[3]);

                storage.putIfAbsent(fileName, new ArrayList<>());
                List<Version> versions = storage.get(fileName);

                boolean found = false;
                for (Version v : versions) {
                    if (v.version.equals(version)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    versions.add(new Version(version, size, c++));
                }
                break;
            }

            case "FETCH":{
                String fileName=parts[1];
                if(!storage.containsKey(fileName)){
                    System.out.println("File Not Found");
                    break;
                }

                List<Version> versions=storage.get(fileName);

                Collections.sort(versions, (a,b)->{
                    if(a.size!=b.size){
                        return a.size-b.size;
                    }
                    return a.version.compareTo(b.version);
                });

                for(Version v:versions){
                    System.out.println(fileName+" "+v.version+" "+v.size);
                }
                break;
            }

            case "LATEST": {
                String fileName = parts[1];

                if (!storage.containsKey(fileName)) {
                    System.out.println("File Not Found");
                    break;
                }

                List<Version> versions = storage.get(fileName);
                Version latest = versions.get(0);

                for (Version v : versions) {
                    if (v.order > latest.order) {
                        latest = v;
                    }
                }

                System.out.println(fileName + " " + latest.version + " " + latest.size);
                break;
            }

            case "TOTAL_STORAGE":{
                String fileName=parts[1];
                if(!storage.containsKey(fileName)){
                    System.out.println("File Not Found");
                    break;
                }

                int total=0;
                for(Version v: storage.get(fileName)){
                    total+=v.size;
                }

                System.out.println(fileName+" "+total);
                break;
            }
        }
    }
}
