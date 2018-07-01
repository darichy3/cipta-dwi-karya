package id.cipta.dwi.karya.ciptadwikarya.service;

import id.cipta.dwi.karya.ciptadwikarya.domain.Inventory;
import java.util.List;

public interface InventoryReportService {
    public List<Inventory> reportInventory(String tglAwal, String tglAkhir);
}
