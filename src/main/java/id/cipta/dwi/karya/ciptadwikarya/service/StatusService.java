package id.cipta.dwi.karya.ciptadwikarya.service;

import id.cipta.dwi.karya.ciptadwikarya.domain.Status;
import java.util.List;


public interface StatusService {
    List<Status> findAll();
    
    Status findOne(Integer idStatus);
}
