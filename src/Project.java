import java.util.LinkedList;

public class Project {
  private String projectName;
  private LinkedList<Studant> studants;

  public Project(String projectName){
    this.projectName = projectName;
    studants = new LinkedList<>();
    studants.size();
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }
  
  public void addStudants(String level, String name, int registry){
    //Studants studant = new Studants(name, name, registry); criando variavel studant
    studants.add(new Studant(level, name, registry)); //ja iniciando studant s/ criar variavel
  }
  
}
