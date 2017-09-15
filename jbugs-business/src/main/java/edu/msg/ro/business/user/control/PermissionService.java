package edu.msg.ro.business.user.control;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.user.dao.PermissionDAO;
import edu.msg.ro.business.user.dto.PermissionDTO;
import edu.msg.ro.business.user.dto.mapper.PermissionDTOMapper;

/**
 * Controller for Permission component.
 * 
 * @author varadp
 *
 */
@Stateless
public class PermissionService {

	@EJB
	private PermissionDAO permissionDAO;

	@EJB
	private PermissionDTOMapper permissionDTOMapper;

	public List<PermissionDTO> getAllPermissions() {
		return permissionDTOMapper.mapToDTOs(permissionDAO.getAll());
	}

}
