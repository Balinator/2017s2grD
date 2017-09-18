package edu.msg.ro.business.user.control;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.user.dao.RoleDAO;
import edu.msg.ro.business.user.dto.RoleDTO;
import edu.msg.ro.business.user.dto.mapper.RoleDTOMapper;
import edu.msg.ro.persistence.user.entity.Role;

/**
 * Controller for Role component.
 * 
 * @author balinc
 *
 */
@Stateless
public class RoleService {

	@EJB
	private RoleDAO roleDAO;

	@EJB
	private RoleDTOMapper roleDTOMapper;

	public List<RoleDTO> getAllRoles() {
		return roleDTOMapper.mapToDTOs(roleDAO.getAll());
	}

	public RoleDTO update(RoleDTO roleDTO) {
		Role persistedRole = roleDAO.findEntity(roleDTO.getId());
		roleDTOMapper.mapToEntity(roleDTO, persistedRole);
		return roleDTOMapper.mapToDTO(persistedRole);
	}
}
