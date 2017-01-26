package com.dao;

import java.util.List;

import com.beans.ServeApply;

public interface ServeApplyDao extends BaseDao<ServeApply> {
	List<ServeApply> findAll();
}
