package br.com.dh.meli;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


@Entity
public class Category implements Comparable<Category>{

	@Id
	private String id;
	private String name;
	@ManyToOne
	private Category parent;
	@OneToMany(mappedBy="parent", fetch=FetchType.LAZY)
	private List<Category> children_categories;
	@Transient
	private Long total_items_in_this_category;
	
	@Transient
	private String hierarchy;

	public Category() {

	}
	
	public Category(String id, String name, Category parent) {
		super();
		this.id = id;
		this.name = name;
		this.parent = parent;
	}
	
	public Category(String id, String name, Category parent, String hierarchy) {
		super();
		this.id = id;
		this.name = name;
		this.parent = parent;
		this.hierarchy = hierarchy;
	}

	public Category(String id) {
		super();
		this.id = id;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Category> getChildren_categories() {
		return children_categories;
	}


	public void setChildren_categories(List<Category> children_categories) {
		this.children_categories = children_categories;
	}


	public Category getParent() {
		return parent;
	}


	public void setParent(Category parent) {
		this.parent = parent;
	}


	public Long getTotal_items_in_this_category() {
		return total_items_in_this_category;
	}


	public void setTotal_items_in_this_category(Long total_items_in_this_category) {
		this.total_items_in_this_category = total_items_in_this_category;
	}


	public String getHierarchyFromRDBMS() {
//		String result = this.getName();
		if(this.id.equals("MLB5802")) {
			System.out.println("é esse");
		}
		String result = this.getId();
		Category p = this.parent;
		//while(p != null && p.parent != null) {
		while(p != null) {
			if(p.parent != null) {
				result = p.parent.getId() + "," + result;
				p = p.parent;
			}else {
				result = p.getId() + "," + result;
				p = null;
			}
		}
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(((Category) obj).getId());
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	public String getHierarchy() {
		return hierarchy;
	}

	public void setHierarchy(String hierarchy) {
		this.hierarchy = hierarchy;
	}

	public int compareTo(Category o) {
		return id.compareTo(o.getId());
	}
	
}
