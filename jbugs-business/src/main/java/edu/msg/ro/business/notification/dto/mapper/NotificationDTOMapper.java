package edu.msg.ro.business.notification.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.msg.ro.business.common.dto.mapper.AbstractDTOMapper;
import edu.msg.ro.business.notification.dto.NotificationDTO;
import edu.msg.ro.business.notification.enums.NotificationEnum;
import edu.msg.ro.business.user.dao.UserDAO;
import edu.msg.ro.business.user.dto.mapper.UserDTOMapper;
import edu.msg.ro.persistence.notification.entity.Notification;
import edu.msg.ro.persistence.notification.entity.NotificationOption;

@Stateless
public class NotificationDTOMapper extends AbstractDTOMapper<Notification, NotificationDTO> {

	@EJB
	private UserDTOMapper userDTOMapper;

	@EJB
	private UserDAO userDAO;

	@Override
	public NotificationDTO getDTOInstance() {
		return new NotificationDTO();
	}

	@Override
	protected void mapEntityToDTOFields(Notification entity, NotificationDTO dto) {
		List<String> options = new ArrayList<>();
		entity.getOptions().forEach(o -> options.add(o.getOption()));
		dto.setOptions(options);
		dto.setType(NotificationEnum.values()[entity.getType() - 1]);
		dto.setUsers(userDTOMapper.mapToDTOs(entity.getUsers()));
		dto.setCreated(entity.getCreated());
	}

	@Override
	protected void mapDTOToEntityFields(NotificationDTO dto, Notification entity) {
		List<NotificationOption> options = new ArrayList<>();
		dto.getOptions().forEach(o -> {
			NotificationOption option = new NotificationOption();
			option.setOption(o);
			options.add(option);
		});

		entity.setOptions(options);
		entity.setType(dto.getType().getTypeId());
		entity.setUsers(userDTOMapper.mapToEntities(dto.getUsers(), userDAO));
	}

}
