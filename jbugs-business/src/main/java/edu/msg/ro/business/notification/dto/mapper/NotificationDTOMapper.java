package edu.msg.ro.business.notification.dto.mapper;

import edu.msg.ro.business.common.dto.mapper.AbstractDTOMapper;
import edu.msg.ro.business.notification.dto.NotificationDTO;
import edu.msg.ro.persistence.notification.entity.Notification;

/**
 * Mapper for {@link Notification} and {@link NotificationDTO}
 * 
 * @author balinc
 *
 */
public class NotificationDTOMapper extends AbstractDTOMapper<Notification, NotificationDTO> {

	@Override
	public NotificationDTO getDTOInstance() {
		return new NotificationDTO();
	}

	@Override
	protected void mapEntityToDTOFields(Notification entity, NotificationDTO dto) {
		dto.setMessage(entity.getVariables());
		dto.setTarget(entity.getTarget());
		dto.setType(entity.getType());
	}

	@Override
	protected void mapDTOToEntityFields(NotificationDTO dto, Notification entity) {
		entity.setVariables(dto.getMessage());
		entity.setTarget(dto.getTarget());
		entity.setType(dto.getType());
	}

}
