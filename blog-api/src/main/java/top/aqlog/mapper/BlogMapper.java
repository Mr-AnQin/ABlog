package top.aqlog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.aqlog.entity.Blog;
import top.aqlog.model.dto.BlogView;
import top.aqlog.model.dto.BlogVisibility;
import top.aqlog.model.vo.ArchiveBlog;
import top.aqlog.model.vo.BlogDetail;
import top.aqlog.model.vo.BlogInfo;
import top.aqlog.model.vo.CategoryBlogCount;
import top.aqlog.model.vo.NewBlog;
import top.aqlog.model.vo.RandomBlog;
import top.aqlog.model.vo.SearchBlog;

import java.util.List;

/**
 * 博客映射器
 *
 * @Description 博客文章持久层接口
 * @Author anqin
 * @Date 2020-07-26
 */
@Mapper
@Repository
public interface BlogMapper {
	/**
	 * 被标题和类别id列表
	 *
	 * @param title      标题
	 * @param categoryId 类别id
	 * @return {@link List}<{@link Blog}>
	 */
	List<Blog> getListByTitleAndCategoryId(String title, Integer categoryId);

	/**
	 * 被查询和发布搜索博客列表
	 *
	 * @param query 查询
	 * @return {@link List}<{@link SearchBlog}>
	 */
	List<SearchBlog> getSearchBlogListByQueryAndIsPublished(String query);

	/**
	 * id和标题列表
	 *
	 * @return {@link List}<{@link Blog}>
	 */
	List<Blog> getIdAndTitleList();

	/**
	 * 被发表新博客列表
	 *
	 * @return {@link List}<{@link NewBlog}>
	 */
	List<NewBlog> getNewBlogListByIsPublished();

	/**
	 * 被发表博客信息列表
	 *
	 * @return {@link List}<{@link BlogInfo}>
	 */
	List<BlogInfo> getBlogInfoListByIsPublished();

	/**
	 * 让博客信息列表按类别名称和出版
	 *
	 * @param categoryName 类别名称
	 * @return {@link List}<{@link BlogInfo}>
	 */
	List<BlogInfo> getBlogInfoListByCategoryNameAndIsPublished(String categoryName);

	/**
	 * 让博客信息列表标签名称和出版
	 *
	 * @param tagName 标签名
	 * @return {@link List}<{@link BlogInfo}>
	 */
	List<BlogInfo> getBlogInfoListByTagNameAndIsPublished(String tagName);

	/**
	 * 获得集团年度月出版
	 *
	 * @return {@link List}<{@link String}>
	 */
	List<String> getGroupYearMonthByIsPublished();

	/**
	 * 得到存档在今年月,发表博客列表
	 *
	 * @param yearMonth 年月
	 * @return {@link List}<{@link ArchiveBlog}>
	 */
	List<ArchiveBlog> getArchiveBlogListByYearMonthAndIsPublished(String yearMonth);

	/**
	 * 被限制num和随机博客列表发表建议
	 *
	 * @param limitNum 限制num
	 * @return {@link List}<{@link RandomBlog}>
	 */
	List<RandomBlog> getRandomBlogListByLimitNumAndIsPublishedAndIsRecommend(Integer limitNum);

	/**
	 * 让博客列表视图
	 *
	 * @return {@link List}<{@link BlogView}>
	 */
	List<BlogView> getBlogViewsList();

	/**
	 * 删除博客通过id
	 *
	 * @param id id
	 * @return int
	 */
	int deleteBlogById(Long id);

	/**
	 * 删除博客标签通过博客id
	 *
	 * @param blogId 博客id
	 * @return int
	 */
	int deleteBlogTagByBlogId(Long blogId);

	/**
	 * 保存博客
	 *
	 * @param blog 博客
	 * @return int
	 */
	int saveBlog(top.aqlog.model.dto.Blog blog);

	/**
	 * 保存博客标签
	 *
	 * @param blogId 博客id
	 * @param tagId  标签id
	 * @return int
	 */
	int saveBlogTag(Long blogId, Long tagId);

	/**
	 * 更新博客推荐通过id
	 *
	 * @param blogId    博客id
	 * @param recommend 推荐
	 * @return int
	 */
	int updateBlogRecommendById(Long blogId, Boolean recommend);

	/**
	 * 更新博客能见度id
	 *
	 * @param blogId 博客id
	 * @param bv     bv
	 * @return int
	 */
	int updateBlogVisibilityById(Long blogId, BlogVisibility bv);

	/**
	 * 更新博客通过id
	 *
	 * @param blogId 博客id
	 * @param top    前
	 * @return int
	 */
	int updateBlogTopById(Long blogId, Boolean top);

	/**
	 * 更新视图
	 *
	 * @param blogId 博客id
	 * @param views  观点
	 * @return int
	 */
	int updateViews(Long blogId, Integer views);

	/**
	 * 通过id获取博客
	 *
	 * @param id id
	 * @return {@link Blog}
	 */
	Blog getBlogById(Long id);

	/**
	 * 被博客标题id
	 *
	 * @param id id
	 * @return {@link String}
	 */
	String getTitleByBlogId(Long id);

	/**
	 * 被id和发表博客
	 *
	 * @param id id
	 * @return {@link BlogDetail}
	 */
	BlogDetail getBlogByIdAndIsPublished(Long id);

	/**
	 * 让博客密码
	 *
	 * @param blogId 博客id
	 * @return {@link String}
	 */
	String getBlogPassword(Long blogId);

	/**
	 * 更新博客
	 *
	 * @param blog 博客
	 * @return int
	 */
	int updateBlog(top.aqlog.model.dto.Blog blog);

	/**
	 * 数博客
	 *
	 * @return int
	 */
	int countBlog();

	/**
	 * 数通过发布博客
	 *
	 * @return int
	 */
	int countBlogByIsPublished();

	/**
	 * 数博客通过类别id
	 *
	 * @param categoryId 类别id
	 * @return int
	 */
	int countBlogByCategoryId(Long categoryId);

	/**
	 * 博客通过标签id数
	 *
	 * @param tagId 标签id
	 * @return int
	 */
	int countBlogByTagId(Long tagId);

	/**
	 * 通过博客评论id
	 *
	 * @param blogId 博客id
	 * @return {@link Boolean}
	 */
	Boolean getCommentEnabledByBlogId(Long blogId);

	/**
	 * 让博客发布id
	 *
	 * @param blogId 博客id
	 * @return {@link Boolean}
	 */
	Boolean getPublishedByBlogId(Long blogId);

	/**
	 * 让博客类别数列表
	 *
	 * @return {@link List}<{@link CategoryBlogCount}>
	 */
	List<CategoryBlogCount> getCategoryBlogCountList();
}
