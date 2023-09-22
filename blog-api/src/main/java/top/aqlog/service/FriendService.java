package top.aqlog.service;

import top.aqlog.entity.Friend;
import top.aqlog.model.vo.FriendInfo;

import java.util.List;

public interface FriendService {
	List<Friend> getFriendList();

	List<top.aqlog.model.vo.Friend> getFriendVOList();

	void updateFriendPublishedById(Long friendId, Boolean published);

	void saveFriend(Friend friend);

	void updateFriend(top.aqlog.model.dto.Friend friend);

	void deleteFriend(Long id);

	void updateViewsByNickname(String nickname);

	FriendInfo getFriendInfo(boolean cache, boolean md);

	void updateFriendInfoContent(String content);

	void updateFriendInfoCommentEnabled(Boolean commentEnabled);
}
