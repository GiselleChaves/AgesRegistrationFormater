import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class App {
    static LinkedList<Project> projects;
    public static void main(String[] args) throws Exception {

        projects = new LinkedList<>();
        String path = "c:\\Users\\Dell\\Desktop\\AGES\\Banco\\AGES2023-2\\pre-registration\\Ages2023-2.txt";

        readData(path);
        createCsv();
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
            e.printStackTrace();
        }
    }

    public static void handle(String line){
        if(line.isEmpty())
            return;

        if(!line.matches("Ages\\s\\w+,.*")){
            //line = line.replaceAll("\"", "\\\"");
            projects.add(new Project(line));
        }else{
            String name = line.replaceAll(".*,\\s", "");
            String level = line.replaceAll(",.*", "");
            int registry=0;
            Project project = projects.get(projects.size()-1);
            project.addStudants(level, name, registry);
        }
    }

    public static boolean createCsv(){
        String outPath = "c:\\Users\\Dell\\Desktop\\AGES\\Banco\\AGES2023-2\\AgesRegistrationFormater\\Ages2023-2.csv";
        FileWriter file = null;
        try{
            file = new FileWriter(outPath);
            file.write("Total;;;;;;;;;;;;\n");
            file.write("Professor;;;;;;;;;;;;\n");
            file.write("Projeto;;");
            
            String[][] table = new String[projects.size()][30];
            int column=0;
            for(Project project:projects){              
                table[column][0] = project.getProjectName();
                file.write(project.getProjectName());
                for(Student student:project.getStudentsArray()){
                    file.write("\n" + student.getName() + ";;");
                }
                column++;
            }
                  
            file.write("\nAGES I Turma 30");
            /*if(project.student.getLevel() == Level.AGES_I){
                file.write("outPath");
            }*/
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            if(file != null){
                try{
                    file.close();
                }catch(IOException f){
                    System.out.println(f.getMessage());
               }
            }
        }
        return true;
    }
}


