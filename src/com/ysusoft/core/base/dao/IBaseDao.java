package com.ysusoft.core.base.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IBaseDao<T> {
	/**
	 * 保存单行
	 * @param t
	 * @return
	 */
	public Serializable save(T t);
	/**
	 * 保存多行
	 * @param list
	 * @return
	 */
	public Serializable save(List<T> list);
	/**
	 * 根据查询条件得到一条记录
	 * @param hql
	 * @return 查询数据
	 */
	public T get(String hql);
	public T get(String hql,Object[] param);
	public T get(String hql,Map<String, Object> map);
	/**
	 * 删除
	 * @param t
	 */
	public Serializable delete(T t);
	/**
	 * 删除多行
	 * @param ids  要删除行id的集合
	 * @param tab 要删除表的名称
	 * @return key 根据删除字段的名称
	 */
	public Serializable deleteAll(String ids,String Table,String key);
	/**
	 * 修改
	 * @param t
	 */
	public Serializable update(T t);
	/**
	 * 保存或修改
	 * @param t
	 */
	public Serializable saveOrUpdate(T t);
	/**
	 * 批量保存或修改
	 * @param list
	 */
	public Serializable saveOrUpdate(List<T> list);
	/**
	 * 根据hql查询数据，不带参数
	 */
	public List<T> find(String hql);
	/**
	 * 查询数据，具有分页功能
	 * @param hql
	 * @param page 当前页数
	 * @param rows 每页显示条数
	 * @return
	 */
	public List<T> find(String hql,int page,int rows);
	/**
	 * 带参数的查询
	 * @param hql
	 * @param map
	 * @return
	 */
	public List<T> find(String hql,Map<String,Object> map);
	/**
	 * 有分页功能的参数查询
	 * @param hql
	 * @param map
	 * @param page 当前页数
	 * @param rows 每页显示多少数据
	 * @return
	 */
	public List<T> find(String hql,Map<String,Object> map,int page,int rows);
	/**
	 * 获得记录数
	 * @param hql
	 * @return
	 */
	public Long count(String hql);
	/**
	 * 获得记录数
	 * @param hql
	 * @param map 参数
	 * @return
	 */
	public Long count(String hql,Map<String,Object> map);
	
	/** 
	 * 条件更新数据及根据SQL删除数据，非特殊情况下禁止使用此方法 
	 * @param sql
	 * @return 大于等于0时数据库操作正常 -1时为异常
	 */
	public int sqlUpdate(String sql);
	
	/**
	 * 执行原声sql 查询
	 * @param sql
	 * @return 返回list<object> 
	 */
	public List sqlQuery(String sql);
	
	/**
	 * 调用存储过程
	 * @param funName 存储过程名称
	 * @param list 存储过程参数，没有参数时，为null
	 * @return String ‘success’ 存储过程调用成功，‘error’ 调用失败
	 */
	public String callProcedure(String funName,List<Object> list);
	
	public  boolean reMove(String hql);
}
