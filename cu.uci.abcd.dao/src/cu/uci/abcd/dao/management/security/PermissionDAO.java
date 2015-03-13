package cu.uci.abcd.dao.management.security;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cu.uci.abcd.domain.management.security.Permission;

public interface PermissionDAO extends
		PagingAndSortingRepository<Permission, Long> {
	@Query(value = "SELECT dpermission.permission_id, dpermission.functionality_identifier, dpermission.description, dpermission.l10n_en, dpermission.l10n_es FROM abcd.dpermission, abcd.daccountprofile, abcd.dprofilepermission WHERE dpermission.permission_id = dprofilepermission.permission_id AND daccountprofile.profile_id = dprofilepermission.profile_id AND daccountprofile.account_id = ?1", nativeQuery = true)
	List<Permission> findAssignedPermissionsByAccountID(Long accountID);
}
