package jenisOOP;

public interface Rules { // abstraction -> membuat interface
	
	// atribut (harus final)
	String rule1 = "Jangan mencuri";
	
	// method (harus abstract)
	public abstract void printPelanggaran();
}
