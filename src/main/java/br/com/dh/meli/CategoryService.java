package br.com.dh.meli;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class CategoryService {

	private static final String CATEGORIES_SUMMARY_URI = "https://api.mercadolibre.com/categories/";
	private MercadoLivreGet restGetter = new MercadoLivreGet();
	private Gson gson = new Gson();
	private CategoryDAO categoryDAORDBMS = new RDBMSCategoryDAO();	
	
	
	public void save(Category category) throws RuntimeException{
		categoryDAORDBMS.save(category);
	}
	
	public Category get(String id) {
		return categoryDAORDBMS.get(id);
	}
	
	public List<Category> getList(){
		return categoryDAORDBMS.getList();
	}
	
	public Long loadTotalItens(Category category) throws IOException {
		try {
			StringBuilder json = restGetter.getJson(CATEGORIES_SUMMARY_URI + category.getId());
			Category c = gson.fromJson(json.toString(), Category.class);
			return c.getTotal_items_in_this_category();
		} catch (IOException e) {
			throw e;
		}
	}
	
	public List<Category> getRootCategories(){
		return categoryDAORDBMS.getRootCategories();
	}
		
	public List<Category> getLeafCategories(){
		List<Category> resultList = categoryDAORDBMS.getLeafCategories();
		return resultList;
	}
	
	public List<Category> getLeafCategories(Category root) {
		 List<Category> leafs = recursiveLeafCategoriesGetter(root, new ArrayList<Category>());
		 return leafs;
	}
	
	private List<Category> recursiveLeafCategoriesGetter(Category root, List<Category> leafs){
		List<Category> children_categories = root.getChildren_categories();
		if(!children_categories.isEmpty()) {
			for (Category child : children_categories) {
				if(!child.getChildren_categories().isEmpty()) {
					recursiveLeafCategoriesGetter(child, leafs);
				}else {
					leafs.add(child);
				}	
			}
		}else {
			leafs.add(root);
		}	
		return leafs;
	}
	
	
	public int getTotalOfSubCategoriesDeep(Category category, int children) {
		int totalChildren = children + category.getChildren_categories().size();
		
		for(Category child: category.getChildren_categories())
			return getTotalOfSubCategoriesDeep(child, totalChildren);
		
		return totalChildren;
	}
	
}
