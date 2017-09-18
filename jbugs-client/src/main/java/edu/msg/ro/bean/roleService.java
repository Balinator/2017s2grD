package edu.msg.ro.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import edu.msg.ro.business.user.boundary.RoleFacade;
import edu.msg.ro.business.user.dao.RoleDAO;
import edu.msg.ro.business.user.dto.RoleDTO;
import edu.msg.ro.business.user.dto.mapper.RoleDTOMapper;

/**
 * Controller for Role component.
 * 
 * @author balinc
 *
 */
@ManagedBean(name = "roleService", eager = true)
@ApplicationScoped
public class roleService {

	@EJB
	private RoleDAO roleDAO;

	@EJB
	private RoleDTOMapper roleDTOMapper;

	@EJB
	private RoleFacade roleFacade;

	private Map<Long, RoleDTO> itemMap = new HashMap<Long, RoleDTO>();

	private List<RoleDTO> roleItems;

	public List<RoleDTO> getAllRoles() {
		return roleDTOMapper.mapToDTOs(roleDAO.getAll());
	}

	public List<RoleDTO> getRoles() {
		return roleItems;
	}

	public Map<Long, RoleDTO> getRoleItemMap() {
		return itemMap;
	}

	@PostConstruct
	public void init() {
		roleItems = roleFacade.getAllRoles();
		for (RoleDTO dto : getRoles()) {
			itemMap.put(dto.getId(), dto);
		}
	}
}
