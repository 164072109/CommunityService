package com.dao;

import com.beans.Comment;

public interface CommentDao {
	void saveOrUpdate(Comment c);
}
