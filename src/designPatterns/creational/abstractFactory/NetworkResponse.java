package designPatterns.creational.abstractFactory;

public class NetworkResponse implements Response {

  @Override
  public String getResponse() {
    return "Network response";
  }
}
