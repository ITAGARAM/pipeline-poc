package com.agaramtech.qualis.compentencemanagement.service.technique;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.agaramtech.qualis.compentencemanagement.model.Technique;
import com.agaramtech.qualis.compentencemanagement.model.TechniqueTest;
import com.agaramtech.qualis.global.UserInfo;
/**
 * This interface declaration holds methods to perform CRUD operation on 'technique' table
 */

public interface TechniqueService {
		
		/**
		 * This interface declaration is used to get the over all units with respect to site
		 * @param userInfo object is used for fetched the list of active records based on site
		 * @return a response entity which holds the list of unit with respect to site and also have the HTTP response code 
		 * @throws Exception that are thrown in the DAO layer
		 */
		public ResponseEntity<Object> getTechnique(final Integer ntechniquecode,final UserInfo userInfo) throws Exception;
		/**
		 * This interface declaration is used to retrieve active Technique object based
		 * on the specified nunitCode.
		 * @param ntechniqueCode [int] primary key of Technique object
		  * @param userInfo object is used for fetched the list of active records based on site
		 * @return response entity  object holding response status and data of Technique object
		 * @throws Exception that are thrown in the DAO layer
		 */
		public ResponseEntity<Object> getActiveTechniqueById(final int ntechniqueCode,final UserInfo userInfo) throws Exception ;
		/**
		 * This interface declaration is used to add a new entry to Technique  table.
		 * @param objTechnique [Technique] object holding details to be added in Technique table
		 * @param userInfo object is used for fetched the list of active records based on site
		 * @return response entity object holding response status and data of added Technique object
		 * @throws Exception that are thrown in the DAO layer
		 */
		public ResponseEntity<Object> createTechnique(final Technique objTechnique,final UserInfo userInfo) throws Exception;
		/**
		 * This interface declaration is used to update entry in Technique  table.
		 * @param objTechnique [Technique] object holding details to be updated in Technique table
		 * @param userInfo object is used for fetched the list of active records based on site
		 * @return response entity object holding response status and data of updated Technique object
		 * @throws Exception that are thrown in the DAO layer
		 */
		public ResponseEntity<Object> updateTechnique(final Technique objTechnique,final UserInfo userInfo) throws Exception;
		
		/**
		 * This interface declaration is used to delete entry in Technique  table.
		 * @param objTechnique [Technique] object holding detail to be deleted in Technique table
		 * @param userInfo object is used for fetched the list of active records based on site
		 * @return response entity object holding response status and data of deleted Technique object
		 * @throws Exception that are thrown in the DAO layer
		 */
		public ResponseEntity<Object> deleteTechnique(final Technique objTechnique,final UserInfo userInfo) throws Exception;
		
		public ResponseEntity<Object> getTechniqueTest(final int ntechniqueCode, final UserInfo userInfo) throws Exception;
		
		public ResponseEntity<Object> getTechniqueConducted(final int ntechniqueCode, final UserInfo userInfo) throws Exception;
		
		public ResponseEntity<Object> getTechniqueScheduled(final int ntechniqueCode, final UserInfo userInfo) throws Exception;
		
		public ResponseEntity<Object> createTechniqueTest(final List<TechniqueTest> techniqueTestList, final int ntechniqueCode,
				final UserInfo userInfo) throws Exception;
		
		public ResponseEntity<Object> deleteTechniqueTest(final TechniqueTest techniqueTest, final int ntechniqueCode,
				final UserInfo userInfo) throws Exception;
		}
