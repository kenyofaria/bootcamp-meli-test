package br.com.dh.meli;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.List;


import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CategoriesGetter {

	private static final String SUBCATEGORIES_URI = "https://api.mercadolibre.com/categories/";
	private static final String ROOT_CATEGORIES_URI = "https://api.mercadolibre.com/sites/MLB/categories";
	private MercadoLivreGet mercadoLivreGet = new MercadoLivreGet();
	private CategoryService categoryService = new CategoryService();
	
	public void retrieveRootCategories() {
		ArrayList<Category> categories = new ArrayList<Category>();
		try {
			StringBuilder json = mercadoLivreGet.getJson(ROOT_CATEGORIES_URI);
			Gson gson = new Gson();
			Type cat = new TypeToken<ArrayList<Category>>() {
			}.getType();
			categories = gson.fromJson(json.toString(), cat);
			for (Category c : categories) {
				categoryService.save(c);
				getSubCategorias(c);
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void getSubCategorias(Category root) {
		try {
			StringBuilder json = mercadoLivreGet.getJson(SUBCATEGORIES_URI + root.getId());
			Gson gson = new Gson();
			
			Category cat = gson.fromJson(json.toString(), Category.class);
			List<Category> children_categories = cat.getChildren_categories();
			if (!children_categories.isEmpty()){
				for (Category c : children_categories) {
					c.setParent(root);
					categoryService.save(c);
					getSubCategorias(c);
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
