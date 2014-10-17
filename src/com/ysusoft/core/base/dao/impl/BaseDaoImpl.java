package com.ysusoft.core.base.dao.impl;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ysusoft.core.base.dao.IBaseDao;

@Repository("baseDao")
public class BaseDaoImpl<T> implements IBaseDao<T> {
	private SessionFactory sessionFactory;
	private static final Logger logger = Logger.getLogger(BaseDaoImpl.class);

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Serializable save(T t) {
		try {
			this.sessionFactory.getCurrentSession().save(t);
			return "success";
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return "error";
		}
	}

	@Override
	public Serializable save(List<T> list) {
		try {
			for(int i=0;i<list.size();i++){
				this.sessionFactory.getCurrentSession().save(list.get(i));
				//logger.info("保存成功》》》》》》》》》》》》》》》"+i);
			}
			return "success";
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return "error";
		} 
	}

	@Override
	public T get(String hql) {
		try {
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			List<T> list = query.list();
			if (query.list() != null && query.list().size() != 0)
				return list.get(0);
			return null;
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public T get(String hql, Object[] param) {
		try {
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			if (param != null && param.length > 0) {
				for (int i = 0; i < param.length; i++) {
					query.setParameter(i, param[i]);
				}
			}
			List<T> list = query.list();
			if (query.list() != null && query.list().size() != 0)
				return list.get(0);
			return null;
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public T get(String hql, Map<String, Object> map) {
		try {
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			if (map != null && !map.isEmpty()) {
				for (String key : map.keySet()) {
					query.setParameter(key, map.get(key));
				}
			}
			List<T> list = query.list();
			if (query.list() != null && query.list().size() != 0)
				return list.get(0);
			return null;
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Serializable delete(T t) {
		try {
			this.sessionFactory.getCurrentSession().delete(t);
			return "success";
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return "error";
		}
	}

	@Override
	public Serializable update(T t) {
		try {
			this.sessionFactory.getCurrentSession().update(t);
			return "success";
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return "error";
		}
	}

	@Override
	public Serializable saveOrUpdate(T t) {
		try {
			this.sessionFactory.getCurrentSession().saveOrUpdate(t);
			return "success";
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return "error";
		}
	}

	@Override
	public Serializable saveOrUpdate(List<T> list) {
		try {
			this.sessionFactory.getCurrentSession().saveOrUpdate(list);
			return "success";
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return "error";
		}
	}

	@Override
	public List<T> find(String hql) {
		try {
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			return query.list();
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<T> find(String hql, Map<String, Object> map) {
		try {
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			if (map != null && !map.isEmpty()) {
				for (String key : map.keySet()) {
					query.setParameter(key, map.get(key));
				}
			}
			return query.list();
		} catch (HibernateException e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<T> find(String hql, Map<String, Object> map, int page, int rows) {
		try {
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			if (map != null && !map.isEmpty()) {
				for (String key : map.keySet()) {
					query.setParameter(key, map.get(key));
				}
			}
			return query.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
		} catch (HibernateException e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			return null;
		}
	}

	@Override
	public List<T> find(String hql, int page, int rows) {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		return query.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	public Long count(String hql) {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		return (Long) query.uniqueResult();
	}

	@Override
	public Long count(String hql, Map<String, Object> map) {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (map != null && !map.isEmpty()) {
			for (String key : map.keySet()) {
				query.setParameter(key, map.get(key));
			}
		}
		return (Long) query.uniqueResult();
	}

	@Override
	public boolean reMove(String hql) {
		try {
			Query q = this.sessionFactory.getCurrentSession().createQuery(hql);
			q.executeUpdate();
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public int sqlUpdate(String sql) {
		try {
			Query query = this.sessionFactory.getCurrentSession().createSQLQuery(sql);
			return query.executeUpdate();
		} catch (HibernateException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public Serializable deleteAll(String ids, String Table, String key) {
		try {
			if (ids == null || ids.equals(""))
				return "error";
			String hql = "delete  from " + Table + " where " + key + " in (";
			String[] nids = ids.split(",");
			for (int i = 0; i < nids.length; i++) {
				if (i > 0) {
					hql += ",";
				}
				hql += "'" + nids[i] + "'";
			}
			hql += ")";
			Query query = this.sessionFactory.getCurrentSession().createSQLQuery(hql);
			int result = query.executeUpdate();
			return result >= 0 ? "success" : "error";
		} catch (HibernateException e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return "error";
		}
	}

	@Override
	public List sqlQuery(String sql) {
		try {
			Query query = this.sessionFactory.getCurrentSession().createSQLQuery(sql);
			List list = query.list();
			return list;
		} catch (HibernateException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String callProcedure(String funName, List<Object> list) {
		try {
			CallableStatement stmt = this.sessionFactory.getCurrentSession().disconnect().prepareCall(funName);
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) != null) {
						stmt.setObject(i, list.get(i));
					} else {
						stmt.setObject(i, Types.NULL);
					}
				}
			}
			stmt.registerOutParameter("out_code", Types.VARCHAR);
			stmt.executeUpdate();
			String keycode = stmt.getString("out_code");
			return keycode==null||keycode.equals("")?"success":keycode;
		} catch (HibernateException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return "error";
	}

}
