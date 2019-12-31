package org.springboot.statement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springboot.statement.model.Team;

@Mapper
public interface TeamMapper {
	/**
     * 查询所有
     */
	@Select("select * from team")
    List<Team> selectAll();
}
