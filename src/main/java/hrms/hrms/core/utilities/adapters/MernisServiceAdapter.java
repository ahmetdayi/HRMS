package hrms.hrms.core.utilities.adapters;

import hrms.hrms.core.business.abstracts.JobSeekerCheckService;
import hrms.hrms.core.mernisReference.KICKPSPublicSoap;
import hrms.hrms.entities.concretes.JobSeeker;
import org.springframework.context.annotation.Bean;

public class MernisServiceAdapter implements JobSeekerCheckService {
    @Override
    public boolean checkIfRealPerson(JobSeeker jobSeeker) {
        KICKPSPublicSoap client = new KICKPSPublicSoap();
        try {
            return client.TCKimlikNoDogrula(jobSeeker.getNationalityId(),jobSeeker.getFirstName().toUpperCase(),
                    jobSeeker.getLastName().toUpperCase(),jobSeeker.getBirthDate().getYear());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}