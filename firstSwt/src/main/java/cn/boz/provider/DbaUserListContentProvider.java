package cn.boz.provider;

import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.boz.domain.ora.pojo.DbaUsers;
import cn.boz.domain.ora.pojo.DbaUsersExample;
import cn.boz.ora.mapper.DbaUsersMapper;

@Component
public class DbaUserListContentProvider extends ArrayContentProvider {

	@Autowired
	private DbaUsersMapper usersMapper;

	public List<DbaUsers> getElements() {
		DbaUsersExample example = new DbaUsersExample();
		example.setOrderByClause("USERNAME ASC");
		return usersMapper.selectByExample(example);
	}
}
