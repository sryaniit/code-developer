package com.shopping.dao;

import com.shopping.dao.CardDetailDao;
import com.shopping.model.CardDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public class CardDetailDaoImpl implements CardDetailDao{

    @Autowired
    private SessionFactory sessionFactory;

    public void addCardDetail(CardDetail cardDetail) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cardDetail);

        session.flush();
    }

}
