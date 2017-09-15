package edu.msg.ro.bean;

import java.util.List;

import javax.annotation.PostConstruct;
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

	public List<RoleDTO> getRoleItems() {
		return roleFacade.getAllRoles();
	}

	@PostConstruct
	public void init() {
		roleItems = roleFacade.getAllRoles();
	}

}
