import java.util.LinkedList;

public class Project {
  private String projectName;
  private LinkedList<Student> students;

  public Project(String projectName){
    this.projectName = projectName;
    students = new LinkedList<>();
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }
  
  public void addStudants(String level, String name, int registry){
    //Studants studant = new Studants(name, name, registry); criando variavel studant
    students.add(new Student(level, name, registry)); //ja iniciando studant s/ criar variavel
  }

  public int size(){
    return students.size();
  }  

  public Student[] getStudentsArray(){
    return (Student[]) students.toArray();
  }
}
