package cn.boz.provider;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.boz.domain.ora.pojo.DbaRolePrivs;
import cn.boz.domain.ora.pojo.DbaRolePrivsExample;
import cn.boz.domain.ora.pojo.DbaRolePrivsExample.Criteria;
import cn.boz.domain.ora.pojo.DbaSysPrivs;
import cn.boz.domain.ora.pojo.DbaSysPrivsExample;
import cn.boz.domain.ora.pojo.RoleRolePrivs;
import cn.boz.domain.ora.pojo.RoleRolePrivsExample;
import cn.boz.domain.ora.pojo.RoleSysPrivs;
import cn.boz.domain.ora.pojo.RoleSysPrivsExample;
import cn.boz.ora.mapper.DbaRolePrivsMapper;
import cn.boz.ora.mapper.DbaSysPrivsMapper;
import cn.boz.ora.mapper.RoleRolePrivsMapper;
import cn.boz.ora.mapper.RoleSysPrivsMapper;

@Component
public class DbaUserPrivsTreeConentProvider extends ArrayContentProvider implements ITreeContentProvider {

	// 角色表
	@Autowired
	private DbaRolePrivsMapper dbaRolePrivsMapper;

	@Autowired
	private DbaSysPrivsMapper sysPrivsMapper;

	// 角色的角色
	@Autowired
	private RoleRolePrivsMapper roleRolePrivsMapper;

	// 角色权限
	@Autowired
	private RoleSysPrivsMapper roleSysPrivsMapper;

	public Object[] getRoots(String username) {
		DbaRolePrivsExample example = new DbaRolePrivsExample();
		Criteria criteria = example.createCriteria();
		example.setOrderByClause("GRANTED_ROLE ASC");
		criteria.andGranteeEqualTo(username);
		var list = new ArrayList<Object>();
		List<DbaRolePrivs> rolePrivs = dbaRolePrivsMapper.selectByExample(example);
		list.addAll(rolePrivs);
		var exam = new DbaSysPrivsExample();
		exam.setOrderByClause("PRIVILEGE ASC");
		cn.boz.domain.ora.pojo.DbaSysPrivsExample.Criteria c2 = exam.createCriteria();
		c2.andGranteeEqualTo(username);
		List<DbaSysPrivs> sysPrivs = sysPrivsMapper.selectByExample(exam);
		list.addAll(sysPrivs);
		return list.toArray();
	}

	@Override
	public Object[] getChildren(Object obj) {
		if (obj instanceof DbaRolePrivs) {
			DbaRolePrivs rp = (DbaRolePrivs) obj;
			// 得到角色
			String grantedRole = rp.getGrantedRole();
			// 获取角色授予的角色
			ArrayList<Object> rst = findRoleSubs(grantedRole);
			return rst.toArray();
		}else if(obj instanceof  RoleRolePrivs) {
			RoleRolePrivs roleRolePrivs=(RoleRolePrivs) obj;
			String grantedRole = roleRolePrivs.getGrantedRole();
			ArrayList<Object> rst = findRoleSubs(grantedRole);
			return rst.toArray();
			
		}
		return null;
	}

	private ArrayList<Object> findRoleSubs(String grantedRole) {
		RoleRolePrivsExample exam1 = new RoleRolePrivsExample();
		exam1.setOrderByClause("GRANTED_ROLE ASC");
		cn.boz.domain.ora.pojo.RoleRolePrivsExample.Criteria c1 = exam1.createCriteria();
		c1.andRoleEqualTo(grantedRole);
		List<RoleRolePrivs> roleRoles = roleRolePrivsMapper.selectByExample(exam1);

		RoleSysPrivsExample exam2 = new RoleSysPrivsExample();
		exam2.setOrderByClause("PRIVILEGE ASC");
		cn.boz.domain.ora.pojo.RoleSysPrivsExample.Criteria c2 = exam2.createCriteria();
		c2.andRoleEqualTo(grantedRole);
		List<RoleSysPrivs> roleSyss = roleSysPrivsMapper.selectByExample(exam2);

		ArrayList<Object> rst = new ArrayList<Object>();
		rst.addAll(roleRoles);
		rst.addAll(roleSyss);
		return rst;
	}

	@Override
	public Object getParent(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object obj) {
		if (obj instanceof DbaRolePrivs) {
			DbaRolePrivs rp = (DbaRolePrivs) obj;
			// 得到角色
			String grantedRole = rp.getGrantedRole();
			// 获取角色授予的角色
			boolean rst = findRoleSubFlag(grantedRole);
			return rst;
		}else if(obj instanceof  RoleRolePrivs) {
			RoleRolePrivs roleRolePrivs=(RoleRolePrivs) obj;
			String grantedRole = roleRolePrivs.getGrantedRole();
			//ArrayList<Object> rst = findRoleSubs(grantedRole);
			//return rst.toArray();
			boolean rst = findRoleSubFlag(grantedRole);
			return rst;
			
		}
		return false;
	}

	private boolean findRoleSubFlag(String grantedRole) {
		RoleRolePrivsExample exam1 = new RoleRolePrivsExample();
		exam1.setOrderByClause("GRANTED_ROLE ASC");
		cn.boz.domain.ora.pojo.RoleRolePrivsExample.Criteria c1 = exam1.createCriteria();
		c1.andRoleEqualTo(grantedRole);
		long num1 = roleRolePrivsMapper.countByExample(exam1);

		RoleSysPrivsExample exam2 = new RoleSysPrivsExample();
		exam2.setOrderByClause("PRIVILEGE ASC");
		cn.boz.domain.ora.pojo.RoleSysPrivsExample.Criteria c2 = exam2.createCriteria();
		c2.andRoleEqualTo(grantedRole);
		long num2 = roleSysPrivsMapper.countByExample(exam2);
		boolean rst=num1 + num2 == 0 ? false : true;
		return rst;
	}

}
