import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class App {
    static LinkedList<Project> projects;
    public static void main(String[] args) throws Exception {

        projects = new LinkedList<>();
        String path = "c:\\Users\\Dell\\Desktop\\AGES\\Banco\\AGES2023-2\\AgesRegistrationFormater\\GiTeste.txt";

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

        if(!line.matches("Ages\\s\\w+;.*")){
            projects.add(new Project(line));
        }else{
            String level = line.replaceAll(";\\s.*","");
            String name = line.replaceAll("Ages\\s\\w+;\\s","");
            name = name.replaceAll(";.*","");
            String gradeCoefficient = line.replaceAll(".*;\\s","");
            //int registry=0;
            Project project = projects.get(projects.size()-1);
            project.addStudants(name, level, gradeCoefficient);
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
            
            int AgesIPosition = Project.levelSize(projects, "Ages I");
            int AgesIIPosition = Project.levelSize(projects, "Ages II");
            int AgesIIIPosition = Project.levelSize(projects, "Ages III");
            int AgesIVPosition = Project.levelSize(projects, "Ages IV");

            int levelsSize = 
                Project.getBiggestLevelSize(projects, "Ages I") + 
                Project.getBiggestLevelSize(projects, "Ages II") + 
                Project.getBiggestLevelSize(projects, "Ages III") + 
                Project.getBiggestLevelSize(projects, "Ages IV"); 

            String[][] table = new String[projects.size()][levelsSize];
            int column = 0;
           
            double gradeCoefficient=0.0;
            for(Project project:projects){              
                table[column][0] = project.getProjectName();  
                int line = 0, offset = 0;
                String level="";
                for(Student student:project.getStudentsArray()){
                    if(!student.getLevel().equals(level)){
                        line = 0;
                        level = student.getLevel();
                        if(student.getLevel().equals("Ages I")){
                            offset = AgesIPosition;
                        }else if(student.getLevel().equals("Ages II")){
                            offset = AgesIIPosition;
                        }else if(student.getLevel().equals("Ages III")){
                            offset = AgesIIIPosition;
                        }else
                            offset = AgesIVPosition;
                        }
                        table[column][offset + line] = student.getName() + ";;" + gradeCoefficient;
                        line++;
                    }
                    column++;
                    
                }
            
                for(int row=0; row<table[0].length; row++){
                    for(column=0; column<table.length; column++){
                        if(table[column][row] == null){
                            file.write(";;");
                        }else{
                            file.write(table[column][row] + ";;");
                        }
                            
                    }
                    if(row < AgesIIPosition-1){
                        file.write("\nAges I Turma 30;;");
                    }else if(row < AgesIIIPosition-1){
                        file.write("\nAges II Turma 30;;");
                    }else if(row < AgesIVPosition-1){
                        file.write("\nAges III Turma 30;;");
                    }else{
                        file.write("\nAges IV Turma 30;;");
                    }
                    
                }
         
            } catch (Exception e) {
                e.printStackTrace();
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


