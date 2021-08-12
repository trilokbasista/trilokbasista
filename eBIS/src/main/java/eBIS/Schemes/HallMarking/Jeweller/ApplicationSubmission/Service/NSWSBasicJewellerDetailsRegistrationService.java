package eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Service;

import java.util.List;

import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Model.NSWSBasicJewellerDetailsRegistrationModel;
import eBIS.nswsAPI.Domain.NSWSApplicationFormMapping;

public interface NSWSBasicJewellerDetailsRegistrationService {

	int generateBranchId(int districtId, String application_for);

	String syncCheck(int branchId);

	List<NSWSApplicationFormMapping> getAppidNSWSId(String nsws_unique_application_id);

	String saveApplicationData(NSWSBasicJewellerDetailsRegistrationModel mod);

}
