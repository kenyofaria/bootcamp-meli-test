package br.com.dh.meli;

import java.util.List;


public interface CategoryDAO {
	
	public void save(Category category) throws RuntimeException;
	public Category get(String id);
	public List<Category> getList();
	public List<Category> getRootCategories();
	public List<Category> getLeafCategories();
}
