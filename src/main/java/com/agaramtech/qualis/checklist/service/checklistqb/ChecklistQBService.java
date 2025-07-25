package com.agaramtech.qualis.checklist.service.checklistqb;

import org.springframework.http.ResponseEntity;

import com.agaramtech.qualis.checklist.model.ChecklistQB;
import com.agaramtech.qualis.global.UserInfo;

public interface ChecklistQBService {
	public ResponseEntity<Object> getChecklistQB(UserInfo userInfo)throws Exception;
	public ResponseEntity<Object> createChecklistQB(ChecklistQB objChecklistQB,UserInfo userInfo)throws Exception;
	public ResponseEntity<Object> updateChecklistQB(ChecklistQB objChecklistQB,UserInfo userInfo)throws Exception;
	public ResponseEntity<Object> deleteChecklistQB(ChecklistQB objChecklistQB,UserInfo userInfo)throws Exception;
	public ResponseEntity<Object> getActiveChecklistQBById(final int nchecklistQBCode,UserInfo userInfo) throws Exception;
	public ResponseEntity<Object> getAddEditData(UserInfo userInfo)throws Exception;

}
