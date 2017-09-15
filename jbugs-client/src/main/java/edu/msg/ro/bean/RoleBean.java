package edu.msg.ro.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.msg.ro.business.user.boundary.RoleFacade;
import edu.msg.ro.business.user.dto.RoleDTO;
import edu.msg.ro.persistence.user.entity.Role;

@ManagedBean
@SessionScoped
public class RoleBean {

	@EJB
	RoleFacade roleFacade;

	private List<Role> roleItems;
	private String name;

	public List<RoleDTO> getRoleItems() {
		return roleFacade.getAllRoles();
	}

}
