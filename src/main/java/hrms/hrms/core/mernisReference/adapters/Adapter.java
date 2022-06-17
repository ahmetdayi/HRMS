//package hrms.hrms.core.mernisReference.adapters;
//
//import hrms.hrms.core.business.abstracts.JobSeekerCheckService;
//import hrms.hrms.entities.concretes.JobSeeker;
//
//public class Adapter implements JobSeekerCheckService {
//    @Override
//    public boolean checkIfRealPerson(JobSeeker jobSeeker) {
//        MDEKPSPublicSoap client = new MDEKPSPublicSoap();
//        try {
//            return client.TCKimlikNoDogrula(jobSeeker.getNationalityId(),jobSeeker.getFirstName().toUpperCase(),
//                    jobSeeker.getLastName().toUpperCase(),jobSeeker.getBirthDate().getYear());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return false;
//    }
//
//}
