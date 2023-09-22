package top.aqlog.service;

import top.aqlog.entity.User;

public interface UserService {
	/**
	 * 找到用户通过用户名和密码
	 *
	 * @param username 用户名
	 * @param password 密码
	 * @return {@link User}
	 */
	User findUserByUsernameAndPassword(String username, String password);

	/**
	 * 找到用户id
	 *
	 * @param id id
	 * @return {@link User}
	 */
	User findUserById(Long id);
}
