public class Student {
  private String name;
  private String level;
  private int registry;

  public Student(String name, String level, int registry){
    this.name = name;
    this.level = level;
    this.registry = registry;
  }
  
  public String getName() {
    return name;
  }

  public String getLevel() {
    return level;
  }

  public int getRegistry() {
    return registry;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public void setRegistry(int registry) {
    this.registry = registry;
  }

}


