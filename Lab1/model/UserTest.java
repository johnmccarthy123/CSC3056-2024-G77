package model;
import model.User;
public class UserTest {
	public static void main(String[] args) {
		User testUser = new User("Dummy", "dummypw", "Dummyfn", "Dummy ln", "dummyno");
		
		System.out.println(testUser);
	}

}
