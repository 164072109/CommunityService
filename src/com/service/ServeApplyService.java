package com.service;

import java.util.List;

import com.beans.ServeApply;

public interface ServeApplyService extends BaseService<ServeApply> {

	List<ServeApply> findAll();

}
