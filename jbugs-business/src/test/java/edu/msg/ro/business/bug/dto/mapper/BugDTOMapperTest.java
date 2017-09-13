package edu.msg.ro.business.bug.dto.mapper;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import edu.msg.ro.business.AbstractIntegrationTest;
import edu.msg.ro.business.bug.dto.BugDTO;
import edu.msg.ro.persistence.bug.entity.Bug;
import edu.msg.ro.persistence.user.entity.User;

public class BugDTOMapperTest extends AbstractIntegrationTest {

	@EJB
	private BugDTOMapper bdm;

	@Test
	public void mapToDTO_validEntity() {

		User testUser = new User();
		testUser.setFirstname("John");
		testUser.setLastname("Doe");
		testUser.setActive(true);

		Bug entity = new Bug();
		entity.setId(1L);
		entity.setTitle("Bug title");
		entity.setDescription("Description");
		entity.setAssigned(testUser);
		entity.setAuthor(testUser);
		entity.setVersion("v2.0");
		entity.setFixedIn("v2.2");
		entity.setTargetDate("2012-01-01");
		entity.setLockVersion(1L);
		entity.setSeverity("bug");
		entity.setStatus(1);

		BugDTO bugDTO = bdm.mapToDTO(entity);

		Assert.assertEquals("Id mapping failed", entity.getId(), bugDTO.getId());
		Assert.assertEquals("Title mapping failed", entity.getTitle(), bugDTO.getTitle());
		Assert.assertEquals("Description mapping failed", entity.getDescription(), bugDTO.getDescription());
		Assert.assertEquals("Assigned mapping failed", entity.getAssigned(), bugDTO.getAssigned());
		Assert.assertEquals("Author mapping failed", entity.getAuthor(), bugDTO.getAuthor());
		Assert.assertEquals("Version mapping failed", entity.getVersion(), bugDTO.getVersion());
		Assert.assertEquals("FixedIn mapping failed", entity.getFixedIn(), bugDTO.getFixedIn());
		Assert.assertEquals("Target Date mapping failed", entity.getTargetDate(), bugDTO.getTargetDate());
		Assert.assertEquals("LockVersion mapping failed", entity.getLockVersion(), bugDTO.getLockVersion());
		Assert.assertEquals("Severity mapping failed", entity.getSeverity(), bugDTO.getSeverity());
		Assert.assertEquals("Status mapping failed", entity.getStatus(), bugDTO.getStatus());

	}

	@Test
	public void mapToDTO_NullEntity() {
		BugDTO bugDTO = bdm.mapToDTO(null);
		Assert.assertNull("Return value of an NULL input should be also NULL", bugDTO);
	}
}
