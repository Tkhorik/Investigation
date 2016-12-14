package ru.maven;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class ICompanyServiceImplTest {
    @Test
    public void whenCompanySingleThenTopTheSameCompany() {
        Company root = new Company(1, null, 0);
        ICompanyService service = new CompanyServiceImpl();
        Company result = service.getTopLevelParent(root);
        assertThat(result, is(root));
    }

    @Test
    public void whenCompanyInChainIsNotOnTheTopWithParrentNull() {
        Company root = new Company(1, null, 0);
        Company manager = new Company(2, root, 0);
        Company dev = new Company(3, manager, 0);
        ICompanyService service = new CompanyServiceImpl();
        Company result = service.getTopLevelParent(dev);
        assertThat(result, is(root));
    }

    @Test
    public void whenCompanySingleThenImployesInIt() {
        Company root = new Company(1, null, 0);
        ICompanyService service = new CompanyServiceImpl();
        List<Company> comps = singletonList(root);
        long result = service.getEmployeeCountForCompanyAndChildren(root, comps);
        assertThat(result, is(1L));
    }

    @Test
    public void whenCompanySingleThenSummEmployes() {
        Company root = new Company(1, null,10);
        Company manager = new Company(2, root, 10);
        Company dev = new Company(3, manager, 10);
        ICompanyService service = new CompanyServiceImpl();
        List<Company> comps = Arrays.asList(root, manager, dev);
        long result = service.getEmployeeCountForCompanyAndChildren(root, comps);
        assertThat(result, is(1L));

    }
}