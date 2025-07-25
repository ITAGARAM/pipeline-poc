package com.agaramtech.qualis.configuration.service.passwordpolicy;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.agaramtech.qualis.configuration.model.PasswordPolicy;
import com.agaramtech.qualis.credential.model.UserRole;
import com.agaramtech.qualis.global.UserInfo;

/**
 * This interface declaration holds methods to perform CRUD operation on
 * 'passwordpolicy' table through its DAO layer.
 * 
 * @author ATE113
 * @version 9.0.0.1
 * @since 06- Jul- 2020
 */
public interface PasswordPolicyService {
	/**
	 * This interface declaration is used to retrieve list of all active
	 * passwordpolicy for the specified site through its DAO layer
	 * 
	 * @param npolicycode [int] key to check the userrolepolicy object contains or not
	 * @param userInfo [UserInfo] holding logged in user details and nmasterSiteCode [int] primary key of site object for 
	 * 							  which the list is to be fetched
	 * @return response entity object holding response status and list of all active
	 *         passwordpolicy
	 * @throws Exception that are thrown in the DAO layer
	 */
	public ResponseEntity<Object> getPasswordPolicy(Integer npolicycode, final UserInfo userInfo) throws Exception;

	/**
	 * This interface declaration is used to retrieve list of all active
	 * passwordpolicy for the specified site.
	 * 
	 * @param nuserrolepolicycode [int] key of userrolepolicy object for which the
	 *                            list is to be fetched
	 * @param userInfo [UserInfo] holding logged in user details based on 
	 * 							  which the list is to be fetched
	 * @return response entity object holding response status and list of all active
	 *         passwordpolicy
	 * @throws Exception that are thrown in the DAO layer
	 */
	public ResponseEntity<Object> getPasswordPolicyByUserRoleCode(Integer nuserrolepolicycode, final UserInfo userInfo)
			throws Exception;

	/**
	 * This interface declaration is used to retrieve active passwordpolicy object
	 * based on the specified npolicycode through its DAO layer.
	 * 
	 * @param npolicycode [int] primary key of passwordpolicy object
	 * @param userInfo [UserInfo] holding logged in user details based on 
	 * 							  which the list is to be fetched
	 * @return response entity object holding response status and data of
	 *         passwordpolicy object
	 * @throws Exception that are thrown in the DAO layer
	 */
	public ResponseEntity<Object> getActivePasswordPolicyById(final int npolicycode, final UserInfo userInfo)
			throws Exception;

	/**
	 * This interface declaration is used to add a new entry to passwordpolicy table
	 * through its DAO layer.
	 * 
	 * @param passwordpolicy [PasswordPolicy] object holding details to be added in
	 *                       passwordpolicy table
	 * @param userInfo [UserInfo] holding logged in user details based on 
	 * 							  which the list is to be fetched
	 * @param nuserrolecode [int] primary key of userrole object for which the passwordpolicy
	 *                    record will get
	 * @return response entity object holding response status and data of added
	 *         passwordpolicy object
	 * @throws Exception that are thrown in the DAO layer
	 */
	public ResponseEntity<Object> createPasswordPolicy(PasswordPolicy passwordPolicy, UserInfo userInfo,
			Integer nuserrolecode) throws Exception;

	/**
	 * This interface declaration is used to update entry in passwordpolicy table
	 * through its DAO layer.
	 * 
	 * @param passwordpolicy [PasswordPolicy] object holding details to be updated
	 *                       in passwordpolicy table
	 * @param userInfo [UserInfo] holding logged in user details based on 
	 * 							  which the list is to be fetched
	 * @return response entity object holding response status and data of updated
	 *         passwordpolicy object
	 * @throws Exception that are thrown in the DAO layer
	 */
	public ResponseEntity<Object> updatePasswordPolicy(PasswordPolicy passwordPolicy, UserInfo userInfo)
			throws Exception;

	/**
	 * This interface declaration is used to delete entry in passwordpolicy table
	 * through its DAO layer.
	 * 
	 * @param passwordpolicy [PasswordPolicy] object holding detail to be deleted in
	 *                       passwordpolicy table
	 * @param userInfo [UserInfo] holding logged in user details based on 
	 * 							  which the list is to be fetched
	 * @return response entity object holding response status and data of deleted
	 *         passwordpolicy object
	 * @throws Exception that are thrown in the DAO layer
	 */
	public ResponseEntity<Object> deletePasswordPolicy(PasswordPolicy passwordPolicy, UserInfo userInfo)
			throws Exception;

	/**
	 * This interface declaration is used to approve entry in userrolepolicy table
	 * through its DAO layer.
	 * 
	 * @param userrolepolicy [UserRolePolicy] object holding detail to be approved
	 *                       in userrolepolicy table
	 * @param userInfo [UserInfo] holding logged in user details based on 
	 * 							  which the list is to be fetched
	 * @return response entity object holding response status and data of approved
	 *         userrolepolicy object
	 * @throws Exception that are thrown in the DAO layer
	 */
	public ResponseEntity<Object> approveUserRolePolicy(PasswordPolicy passwordPolicy, UserInfo userInfo)
			throws Exception;

	/**
	 * This interface declaration is used to retrieve active userrolepolicy object
	 * 
	 * @param userInfo [UserInfo] holding logged in user details based on 
	 * 							  which the list is to be fetched
	 * @return response entity object holding response status and data of
	 *         userrolepolicy object
	 * @throws Exception that are thrown in the DAO layer
	 */
	public ResponseEntity<Object> getUserRolePolicy(UserInfo userInfo) throws Exception;

	/**
	 * This method is used to copy the active passwordpolicy to the specified
	 * userrole.
	 * 
	 * @param npolicyCode [int] primary key of passwordpolicy object for which the
	 *                    record is copied to specified userrole
	 * @param lstuserRole [UserRole] object holding list of details of userrole
	 * @param userInfo [UserInfo] holding logged in user details based on 
	 * 							  which the list is to be fetched
	 * @param spolicyname [String] string field of passwordpolicy object for which the passwordpolicy name to check for duplicate record
	 * @return response entity object holding response status and list of all active
	 *         passwordpolicy
	 * @throws Exception that are thrown from this DAO layer
	 */
	public ResponseEntity<Object> copyPasswordPolicyToSelectedRole(List<UserRole> lstuserRole, final int npolicycode,
			UserInfo userInfo, final String spolicyname) throws Exception;

}
