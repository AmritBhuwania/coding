package designPatterns.creational.abstractFactory;

public class NetworkService implements Service {

  @Override
  public String runService() {
    return "Network service running";
  }
  
}
