package designPatterns.creational.abstractFactory;

public interface DataSourceAbstractFactory {
  Service createService();
  Response createResponse();
}
