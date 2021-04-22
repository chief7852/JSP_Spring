package kr.or.ddit.example.dao;

public class ExampleDAOFactory {
	public static IExampleDAO getExapleDAO() {
//		return new ExampleDAO_MySql();
		return new ExampleDAO_Oracle();
	}
}
