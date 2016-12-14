package ru.maven;

import java.util.List;


class CompanyServiceImpl implements ICompanyService {
    @Override
    public Company getTopLevelParent(Company child) {
        Company result = child;
        if (child.getParent() != null) this.getTopLevelParent(child.getParent());
        return child;
    }

    @Override
    public long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies) {
        long result = company.getEmployeeCount();
//        return result;
        for (Company comp : companies) {
            if (comp.getParent() != null && comp.getParent().equals(company))
                result = this.getEmployeeCountForCompanyAndChildren(comp, companies);
        }
        return result;
    }
}
