package com.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.beans.Comment;
import com.dao.CommentDao;
import com.service.CommentService;

@Service
public class CommentServiceImp implements CommentService {
	@Resource
	private CommentDao commentDao;

	@Override
	public void saveOrUpdate(Comment c) {
		commentDao.saveOrUpdate(c);
	}

}
