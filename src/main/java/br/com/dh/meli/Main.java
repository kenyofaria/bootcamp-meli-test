package br.com.dh.meli;

public class Main {

	
	
	public static void main(String[] args) {
		CategoriesGetter getter = new CategoriesGetter();
		getter.retrieveRootCategories();
		System.out.println("done");
	}
}
