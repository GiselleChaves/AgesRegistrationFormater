public class Student {
  private String name;
  private String level;
  private String gradeCoefficient;

  public Student(String name, String level, String gradeCoefficient){
    this.name = name;
    this.level = level;
    this.gradeCoefficient = gradeCoefficient;
  }
  
  public String getName() {
    return name;
  }

  public String getLevel() {
    return level;
  }

  public String getGradeCoefficient() {
    return gradeCoefficient;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public void setRegistry(String gradeCoefficient) {
    this.gradeCoefficient = gradeCoefficient;
  }
}


