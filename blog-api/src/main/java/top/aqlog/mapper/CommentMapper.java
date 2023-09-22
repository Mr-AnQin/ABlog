package top.aqlog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.aqlog.entity.Comment;
import top.aqlog.model.vo.PageComment;

import java.util.List;

/**
 * @Description 博客评论持久层接口
 * @Author anqin
 * @Date 2020-08-03
 */
@Mapper
@Repository
public interface CommentMapper {
	List<Comment> getListByPageAndParentCommentId(Integer page, Long blogId, Long parentCommentId);

	List<Comment> getListByParentCommentId(Long parentCommentId);

	List<PageComment> getPageCommentListByPageAndParentCommentId(Integer page, Long blogId, Long parentCommentId);

	Comment getCommentById(Long id);

	int updateCommentPublishedById(Long commentId, Boolean published);

	int updateCommentNoticeById(Long commentId, Boolean notice);

	int deleteCommentById(Long commentId);

	int deleteCommentsByBlogId(Long blogId);

	int updateComment(Comment comment);

	int countByPageAndIsPublished(Integer page, Long blogId, Boolean isPublished);

	int countComment();

	int saveComment(top.aqlog.model.dto.Comment comment);
}
