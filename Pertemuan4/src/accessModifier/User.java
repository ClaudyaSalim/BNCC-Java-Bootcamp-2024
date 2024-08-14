package accessModifier;

import teoriAwal.Person;

public class User extends Person{ // class User merupakan turunan dari class Person

	public User(String nameParam, int ageParam, String dobParam) { // constructor class user
		super(nameParam, ageParam, dobParam);
	}
	
	void displayUser() {
//		Person person1 = new Person("Caca", 20, "8 Agustus 1994");
		System.out.println(age); // utk akses yg protected
	}

}
