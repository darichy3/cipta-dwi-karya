package id.cipta.dwi.karya.ciptadwikarya.service;

import id.cipta.dwi.karya.ciptadwikarya.domain.Inventory;
import id.cipta.dwi.karya.ciptadwikarya.repository.InventoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryReportServiceImpl implements InventoryReportService{

    @Autowired
    private InventoryRepository repository;
    
    @Override
    public List<Inventory> reportInventory(String tglAwal, String tglAkhir) {
        return repository.findByDateInBetween(tglAwal, tglAkhir);
    }
    
}
