package edu.msg.ro.business.bug.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import edu.msg.ro.business.common.dao.AbstractDao;
import edu.msg.ro.persistence.bug.entity.Comment;

@Stateless
public class CommentDAO extends AbstractDao<Comment> {

	@Override
	public Class<Comment> getEntityClass() {
		return Comment.class;
	}

	public List<Comment> getAllCommentForBug(Long id) {
		Query query = this.em.createQuery(
				"SELECT c FROM Comment c WHERE c.bug.id = :id ORDER BY c.id DESC, c.targetDate DESC", Comment.class);
		query.setParameter("id", id);
		return query.getResultList();
	}

}
