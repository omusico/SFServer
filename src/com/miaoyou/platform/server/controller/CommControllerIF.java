package com.miaoyou.platform.server.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miaoyou.platform.server.entity.common.ComResponse;
import com.miaoyou.platform.server.entity.common.CommFindEntity;

/**
 *
 * @author Chen Xiaoping
 * @param <T>
 *            是表的entity
 * @param <C>
 *            是表的主键类型，如果是符合主键或者多个主键，就再写一个service interface， extends
 *            CommServiceIF<T, C>来实现自己的service interface
 */
public interface CommControllerIF<T, C> {

	public @ResponseBody T getById(@PathVariable C id);

	public @ResponseBody CommFindEntity<T> getAll(
			@RequestParam(value = "psi", defaultValue = "0") int page,
			@RequestParam(value = "pst", defaultValue = "20") int perPage,
			@RequestParam(value = "conditionSql", defaultValue = "") String conditionSql);

	public @ResponseBody ComResponse<T> add(@RequestBody T bean);
	
	public @ResponseBody ComResponse<T> update(@RequestBody T bean);
	
	public @ResponseBody ComResponse<T> delete(@PathVariable C id); 
}
