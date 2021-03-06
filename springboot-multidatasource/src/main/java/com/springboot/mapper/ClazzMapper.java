package com.springboot.mapper;

import com.springboot.annotation.Test2Repository;
import com.springboot.model.Clazz;
@Test2Repository
public interface ClazzMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated
     */
    int insert(Clazz record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated
     */
    int insertSelective(Clazz record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated
     */
    Clazz selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Clazz record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table clazz
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Clazz record);
}