package top.aqlog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @Description 用户实体类
 * @Author anqin
 * @Date 2020-07-19
 */

@NoArgsConstructor
@Getter
@Setter
@ToString
public class User implements UserDetails {
	/**
	 * id
	 */
	private Long id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 昵称
	 */
	private String nickname;
	/**
	 * 作者
	 */
	private String avatar;
	/**
	 * 电子邮件
	 */
	private String email;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 角色
	 */
	private String role;

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorityList = new ArrayList<>();
		authorityList.add(new SimpleGrantedAuthority(role));
		return authorityList;
	}

	/**
	 * 是账户非过期
	 *
	 * @return boolean
	 */
	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * 是账户非锁定
	 *
	 * @return boolean
	 */
	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}
}
