package generic;

// Tipe generik ditandai dengan 'T'
// liat penamaan generik lainnya 
// https://medium.com/@barbieri.santiago/java-generics-class-level-vs-method-level-type-parameters-fb869af40d29#:~:text=Adhering%20to%20naming%20conventions%20(%20T,parameter%20is%20intended%20to%20represent.

public class GenericClass <T> { // class generik
	
	T atribut1; T atribut2; // atribut generik

	public GenericClass(T atribut1, T atribut2) { // constructor dengan parameter generik
		this.atribut1 = atribut1;
		this.atribut2 = atribut2;
	}

	public T getAtribut1() { // tipe method yg generik
		return atribut1;
	}

	public void setAtribut1(T atribut1) { // method dengan parameter generik
		this.atribut1 = atribut1;
	}

	public T getAtribut2() {
		return atribut2;
	}

	public void setAtribut2(T atribut2) {
		this.atribut2 = atribut2;
	}
	
	public void compareAttributes() {
		if(atribut1 == atribut2) {
			System.out.println("Same");
		}
		else {
			System.out.println("Different");
		}
	}

}
