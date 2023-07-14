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
  
  public void addStudants(String level, String name, String gradeCoefficient){
    //Studants studant = new Studants(name, name, gradeCoefficient); criando variavel studant
    students.add(new Student(level, name, gradeCoefficient)); //ja iniciando studant s/ criar variavel
  }

  public int size(){
    return students.size();
  }  

  public Student[] getStudentsArray(){
    Student[] studentsArray = new Student[size()];
    for(int i=0; i<students.size();i++){
      studentsArray[i] = students.get(i);
    }
    return studentsArray;
  }

  public static int getBiggestLevelSize(LinkedList<Project> projects, String level){
    int quantity = 0, maior = 0;
    
    for(Project projectsInterate:projects){
      quantity = 0;
      for(Student student:projectsInterate.getStudentsArray()){
        if(student.getLevel().equals(level)){
          quantity++;  
        }
        if(maior < quantity){
          maior = quantity;
        }
      }
    }
    return maior;
  }

  public static int levelSize(LinkedList<Project> projects, String level){
    if(level.equals("Ages I")){
      return 1;
    }else if(level.equals("Ages II")){
      return getBiggestLevelSize(projects, "Ages I") + 1;
    }else if(level.equals("Ages III")){
      return (getBiggestLevelSize(projects, "Ages I") + getBiggestLevelSize(projects, "Ages II") + 1);
    }else
      return getBiggestLevelSize(projects, "Ages I") + getBiggestLevelSize(projects, "Ages II") + getBiggestLevelSize(projects, "Ages III");
  }
}
