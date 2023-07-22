package designPatterns.creational.abstractFactory;

public class DatabaseService implements Service {

  @Override
  public String runService() {
    return "Database service running";
  }
  
}
