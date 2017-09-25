package edu.msg.ro.business.junit.bug.dto.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import edu.msg.ro.business.bug.dto.mapper.BugDTOMapper;
import edu.msg.ro.business.user.dao.UserDAO;
import edu.msg.ro.business.user.dto.mapper.UserDTOMapper;
import edu.msg.ro.persistence.bug.entity.Bug;
import edu.msg.ro.persistence.user.entity.User;

@RunWith(MockitoJUnitRunner.class)
public class BugDTOMapperTest {

	@InjectMocks
	private BugDTOMapper bugDtoMapper;

	@Mock
	private UserDTOMapper userDtoMapper;

	@Mock
	private UserDAO userDAO;

	@Test
	public void mapToDTO_validEntity() {
		Bug bug = new Bug();
		bug.setAssigned(new User());
		bug.setAttachmentName("");
		bug.setAuthor(new User());
		byte[] b = { 1, 2 };
		bug.setAttachment(b);
	}
}
