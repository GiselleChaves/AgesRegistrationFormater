import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class App {
    static LinkedList<Project> projects;
    public static void main(String[] args) throws Exception {

        projects = new LinkedList<>();
        FileOutputStream file = null;
        ObjectOutputStream obj = null;
        String path = "c:\\Users\\Dell\\Desktop\\AGES\\Banco\\AGES2023-2\\pre-registration\\Ages2023-2.txt";

        readData(path);
        
    }
    
    public static void readData(String path){
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            while(line != null){
                handle(line);
                System.out.println(line);
                line = br.readLine();
            } 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void handle(String line){
        if(line.isEmpty())
            return;

        if(!line.matches("Ages\\s\\W+,*")){
            projects.add(new Project(line));
        }else{
            String name = line.replaceAll("*,\\s", "");
            String level = line.replaceAll(",*", "");
            int registry=0;
            Project project = projects.get(projects.size()-1);
            project.addStudants(level, name, registry);
        }
    }

    public boolean createCsv(){
        try {
            file = new FileOutputStream("Ages2023-2.csv");
            obj = new ObjectOutputStream(file);//pcte que vai para dentro do arquivo
            
            obj.writeObject(studant);//leva os dados para os buffers
            obj.flush();//escreve os dados no disco

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally{
            if(file != null){
                file.close();
            }
            if(obj != null){
                obj.close();
            }
        }
    }
}


