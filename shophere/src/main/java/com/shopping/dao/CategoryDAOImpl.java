package com.shopping.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.model.Category;
import com.shopping.model.UsersDetail;

@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
    private SessionFactory sessionFactory;
	
public void saveOrUpdate(Category category){
    Session session = sessionFactory.getCurrentSession();
	session.saveOrUpdate(category);
}
public List<Category> list() {
    Session session = sessionFactory.getCurrentSession();
    Query query = session.createQuery("from Category");
    @SuppressWarnings("unchecked")
	List<Category> category = query.list();

    return category;
}
public Category get(String id) {
    Session session = sessionFactory.getCurrentSession();
    return (Category) session.get(Category.class,id);
}
public Category getByName(String name) {
    Session session = sessionFactory.getCurrentSession();
    Query query = session.createQuery("from Category where name = ?");
    query.setString(0, name);

    return (Category) query.uniqueResult();
}
public void delete(String id) {
    Session session = sessionFactory.getCurrentSession();
    Category CategoryToDelete = new Category();
	CategoryToDelete.setId(id);
	session.delete(CategoryToDelete);
}
}